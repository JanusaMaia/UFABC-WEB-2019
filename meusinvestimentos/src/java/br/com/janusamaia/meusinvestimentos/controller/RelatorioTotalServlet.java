/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.janusamaia.meusinvestimentos.controller;

import br.com.janusamaia.meusinvestimentos.dao.DataSource;
import br.com.janusamaia.meusinvestimentos.dao.InvestimentoDAO;
import br.com.janusamaia.meusinvestimentos.model.Conta;
import br.com.janusamaia.meusinvestimentos.model.Investimento;
import br.com.janusamaia.meusinvestimentos.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author janus
 */
public class RelatorioTotalServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "/";
        try{
            Usuario usuario = (Usuario)request.getSession().getAttribute("Usuario");
            if(usuario != null){
                if(usuario.getContas() != null){
                    DataSource datasource = new DataSource();
                    InvestimentoDAO investimentoDao = new InvestimentoDAO(datasource);
                    ArrayList<Investimento> lista = investimentoDao.readInvestimentos(usuario);
                    List<Double> valoresTotais = investimentoDao.getValorTotalAplicado(usuario);
                    datasource.getConnection().close();
                    
                    if(lista != null){
//                        ArrayList<Investimento> listaInvest = new ArrayList<Investimento>();
//                        for(Object inv : lista){
//                            Investimento novoInvest = (Investimento)inv;
//                            listaInvest.add(novoInvest);
//                        }

                        request.getSession().setAttribute("Usuario", usuario);
                        request.getSession().setAttribute("Totais", valoresTotais);
                        request.getSession().setAttribute("Investimentos", lista);
                    };       
                }
                pagina = "/relatoriototal.jsp";
            }
            else{
                pagina = "/login.jsp";
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao recuperar investimento para relatório. "+ex.getMessage());
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
    }

}
