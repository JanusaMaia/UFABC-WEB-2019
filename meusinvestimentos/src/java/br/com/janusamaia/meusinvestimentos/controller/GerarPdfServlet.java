/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.janusamaia.meusinvestimentos.controller;

import br.com.janusamaia.meusinvestimentos.dao.DataSource;
import br.com.janusamaia.meusinvestimentos.model.Usuario;
import br.com.janusamaia.meusinvestimentos.util.GeradorDeRelatorios;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author janus
 */
public class GerarPdfServlet extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "/";
        try{
            Usuario usuario = (Usuario)request.getSession().getAttribute("Usuario");
            if(usuario != null){

                ServletContext contexto = request.getServletContext();
                String jrxml = contexto.getRealPath("./relatorios/Investimentos.jrxml");
//                String jasper = contexto.getRealPath("./relatorios/Simple_Blue_1.jasper");

                Map<String, Object> parametros = new HashMap<>();
                parametros.put("codigoUsuario", usuario.getId());

                DataSource datasource = new DataSource();

                GeradorDeRelatorios gerador = new GeradorDeRelatorios(datasource);
                gerador.geraPdf(jrxml, parametros, response.getOutputStream());

                datasource.getConnection().close();
            }
            else{
                pagina = "/login.jsp";
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao recuperar contas. "+ex.getMessage());
            request.setAttribute("erroSTR", "Erro ao recuperar dados.");
            pagina = "/error.jsp";
            
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
    }

}
