/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.janusamaia.meusinvestimentos.controller;

import br.com.janusamaia.meusinvestimentos.dao.ContaDAO;
import br.com.janusamaia.meusinvestimentos.dao.DataSource;
import br.com.janusamaia.meusinvestimentos.dao.InvestimentoDAO;
import br.com.janusamaia.meusinvestimentos.model.Conta;
import br.com.janusamaia.meusinvestimentos.model.Investimento;
import br.com.janusamaia.meusinvestimentos.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
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
public class EfetivaInvestimentoServlet extends HttpServlet {

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "./";
        try{
            Usuario usuario = (Usuario)request.getSession().getAttribute("Usuario");
            if(usuario != null){
                String conta = request.getParameter("selectNomeConta");
                String nome = request.getParameter("inputNome");
                String categoria = request.getParameter("selectCategoria");
                String dataI = request.getParameter("inputDataI");
                String dataF = request.getParameter("inputDataF");
                String valorInicial = request.getParameter("inputValorInicial");
                String valorAtual = request.getParameter("inputValorInicial");
                
                DataSource datasource = new DataSource();
                Investimento investimento = new Investimento();
                
                ContaDAO contaDao = new ContaDAO(datasource);
                Conta contaS = new Conta();
                contaS = (Conta)contaDao.readByIdConta(Integer.parseInt(conta));
                investimento.setConta(contaS);
                investimento.setNomeInvestimento(nome);
                investimento.setCategoria(categoria);
                
                try {
                    investimento.setDataDoInvestimento(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(dataI).getTime()));
                } catch (ParseException ex) {
                    Logger.getLogger(EfetivaInvestimentoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    investimento.setDataDeVencimento(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(dataF).getTime()));
                } catch (ParseException ex) {
                    Logger.getLogger(EfetivaInvestimentoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                investimento.setValorInicial(Double.parseDouble(valorInicial));
                investimento.setValorAtual(Double.parseDouble(valorInicial));
                
                InvestimentoDAO investimentoDao = new InvestimentoDAO(datasource);
                investimentoDao.create(investimento);
               
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
            System.out.println("Erro ao cadastrar Investimento - "+ex.getMessage());
            request.setAttribute("erroSTR", "Erro ao criar investimento.");
            pagina = "/error.jsp";
        }    
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);   
    }
}
