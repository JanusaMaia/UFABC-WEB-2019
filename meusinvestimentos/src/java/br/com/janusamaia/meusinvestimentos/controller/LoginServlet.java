/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.janusamaia.meusinvestimentos.controller;

import br.com.janusamaia.meusinvestimentos.dao.ContaDAO;
import br.com.janusamaia.meusinvestimentos.dao.DataSource;
import br.com.janusamaia.meusinvestimentos.dao.UsuarioDAO;
import br.com.janusamaia.meusinvestimentos.model.Conta;
import br.com.janusamaia.meusinvestimentos.model.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author janusam
 */
public class LoginServlet extends HttpServlet {

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
        String email = request.getParameter("inputEmail");
        String senha = request.getParameter("inputSenha");
        
        Usuario user = new Usuario();
        user.setEmail(email);
        user.setSenha(senha);
        String pagina = "/error.jsp";
        
        try{
            DataSource ds = new DataSource();
            UsuarioDAO usuarioDao = new UsuarioDAO(ds);
            List<Object> res = usuarioDao.read(user);
            if(res != null && res.size() > 0){
                Usuario usuario = new Usuario();
                usuario = (Usuario)res.get(0);
                if(usuario.getContas() == null){
//                    DataSource datasource = new DataSource();
                    ContaDAO contaDao = new ContaDAO(ds);
                    List<Object> lista = contaDao.read(usuario.getId());
//                    datasource.getConnection().close();
                    
                    if(lista != null){
                        ArrayList<Conta> mContas = new ArrayList<Conta>();
                        for(Object o: lista){
                            Conta novaConta = (Conta)o;
                            novaConta.setUsuario(usuario);
                            mContas.add(novaConta);
                        }
                        usuario.setContas(mContas);   
                    }
                }
                pagina = "/myaccount.jsp";
                request.getSession().setAttribute("Usuario", res.get(0));
            }
            else{
                request.setAttribute("erroSTR", "Usuário/Senha inválidos.");
            }
            ds.getConnection().close();
        }
        catch(Exception ex){
            request.setAttribute("erroSTR", "Erro ao recuperar dados.");
        }
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
    }
}
