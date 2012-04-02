/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.servlet;

import br.com.fiap.bean.Usuarios;
import br.com.fiap.dao.DaoUsuarios;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fernando Santiago
 */
public class CallReport extends HttpServlet {
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        Usuarios user = new Usuarios(usuario,senha);
        
        DaoUsuarios dao = new DaoUsuarios(user);
        if(dao.validaUsuario()){
            HttpSession session = request.getSession();
            session.setAttribute("j_usuario", user);
            response.sendRedirect("menu.jsp");
        }
        else {
            response.sendRedirect("login.jsp");
        }            
    }
    
}
