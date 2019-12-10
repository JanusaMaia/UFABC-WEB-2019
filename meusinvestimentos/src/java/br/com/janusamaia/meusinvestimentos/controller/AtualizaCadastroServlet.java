/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.janusamaia.meusinvestimentos.controller;

import br.com.janusamaia.meusinvestimentos.dao.DataSource;
import br.com.janusamaia.meusinvestimentos.dao.UsuarioDAO;
import br.com.janusamaia.meusinvestimentos.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author janus
 */
public class AtualizaCadastroServlet extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "/login.jsp";
//        Usuario usuario = new Usuario();
        Usuario usuario = (Usuario)request.getSession().getAttribute("Usuario");
        try{
            String nome = request.getParameter("inputNome");
            String username = request.getParameter("inputUsername");
            String cep = request.getParameter("inputCep");
            String tipo = request.getParameter("inputTipo"); 
            String rua = request.getParameter("inputRua"); 
            String numero = request.getParameter("inputNumero");
            String complemento = request.getParameter("inputComplemento");
            String bairro = request.getParameter("inputBairro");
            String cidade = request.getParameter("inputCidade");
            String estado = request.getParameter("inputEstado");

            usuario.setNome(nome);
            usuario.setUsername(username);
            usuario.setCep(cep);
            usuario.setRua(rua);
            usuario.setTipo(tipo);
            usuario.setNumero(numero);
            usuario.setComplemento(complemento);
            usuario.setBairro(bairro);
            usuario.setCidade(cidade);
            usuario.setEstado(estado);
            

            DataSource datasource = new DataSource();
            UsuarioDAO usuarioDao = new UsuarioDAO(datasource);
            usuarioDao.update(usuario);

            datasource.getConnection().close();
        }
        catch(SQLException ex){
            System.out.println("Erro ao atualizar cadastro - "+ex.getMessage());
            request.setAttribute("erroSTR", "Erro ao atualizar cadastro de usuário.");
            pagina = "/error.jsp";
        }
        if(usuario.getId() != 0){
            pagina = "/myaccount.jsp";
            request.getSession().setAttribute("Usuario", usuario);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
    }

}
