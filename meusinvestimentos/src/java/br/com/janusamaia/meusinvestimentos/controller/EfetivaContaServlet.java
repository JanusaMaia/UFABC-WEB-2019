/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.janusamaia.meusinvestimentos.controller;

import br.com.janusamaia.meusinvestimentos.dao.ContaDAO;
import br.com.janusamaia.meusinvestimentos.dao.DataSource;
import br.com.janusamaia.meusinvestimentos.model.Conta;
import br.com.janusamaia.meusinvestimentos.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author janus
 */
public class EfetivaContaServlet extends HttpServlet {


   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "./";
        try{
            Usuario usuario = (Usuario)request.getSession().getAttribute("Usuario");
            if(usuario != null){
                String banco = request.getParameter("inputBanco");
                String nome = request.getParameter("inputNomeConta");
                String agencia = request.getParameter("inputAgencia");
                String numero = request.getParameter("inputNumero");
                Conta conta = new Conta();
                conta.setBanco(banco);
                conta.setApelidoConta(nome);
                conta.setAgencia(agencia);
                conta.setNumero(numero);
                conta.setUsuario(usuario);
                
                DataSource datasource = new DataSource();
                ContaDAO contaDao = new ContaDAO(datasource);
                contaDao.create(conta);
                datasource.getConnection().close();
                if(usuario.getContas() == null){
                    usuario.setContas(new ArrayList<Conta>());
                }
                usuario.getContas().add(conta);
                request.getSession().setAttribute("Usuario", usuario);
                pagina = "/minhascontas.jsp";
            }
            else{
                pagina = "/login.jsp";
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao cadastrar conta - "+ex.getMessage());
            request.setAttribute("erroSTR", "Erro ao criar conta.");
            pagina = "/error.jsp";
            
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);   
    }
   
}
