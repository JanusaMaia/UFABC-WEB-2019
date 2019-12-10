/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.janusamaia.meusinvestimentos.controller;

import br.com.janusamaia.meusinvestimentos.dao.DataSource;
import br.com.janusamaia.meusinvestimentos.dao.EvolucaoDAO;
import br.com.janusamaia.meusinvestimentos.dao.InvestimentoDAO;
import br.com.janusamaia.meusinvestimentos.model.Evolucao;
import br.com.janusamaia.meusinvestimentos.model.Investimento;
import br.com.janusamaia.meusinvestimentos.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author janus
 */
public class EfetivaAtualizarInvestimentoServlet extends HttpServlet {

    
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "./";
       try{
            Usuario usuario = (Usuario)request.getSession().getAttribute("Usuario");
            if(usuario != null){
                           
                String id = request.getParameter("inputId");
                String data = request.getParameter("inputData");
                String valorAtual = request.getParameter("inputValor");
                
                DataSource datasource = new DataSource();
                Investimento investimento = new Investimento();
                investimento.setId(Integer.parseInt(id));
                investimento.setValorAtual(Double.parseDouble(valorAtual));
                
                EvolucaoDAO evolucaoDao = new EvolucaoDAO(datasource);
                InvestimentoDAO investimentoDao = new InvestimentoDAO(datasource);
                Evolucao evolucao = new Evolucao();
                
                evolucao.setInvestimento(investimento);
                
                try{
                    SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd" );
                    java.util.Date date1=dateFormat.parse(data);
                    Timestamp dataInicial=new Timestamp(date1.getTime());
                    investimento.setDataDoInvestimento(dataInicial);
                }catch (ParseException ex) {    
                    Logger.getLogger(EfetivaInvestimentoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
//                try {
//                    evolucao.setData(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(data).getTime()));
//                } catch (ParseException ex) {
//                    Logger.getLogger(EfetivaInvestimentoServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
                evolucao.setValorAtualizado(Double.parseDouble(valorAtual));
                evolucaoDao.create(evolucao);
                investimentoDao.update(investimento);
               
                List contaList = investimentoDao.read(usuario);
                usuario.setContas(contaList);
                List<Double> valoresTotais = investimentoDao.getValorTotalAplicado(usuario);
                
                datasource.getConnection().close();
                request.getSession().setAttribute("Usuario", usuario);
                request.getSession().setAttribute("Totais", valoresTotais);
                pagina = "/meusinvestimentos.jsp";
            }
            else{
                pagina = "/login.jsp";
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao atualizar Investimento - "+ex.getMessage());
            request.setAttribute("erroSTR", "Erro ao atualizar investimento.");
            pagina = "/error.jsp";
        }    
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);   
    }
    

}
