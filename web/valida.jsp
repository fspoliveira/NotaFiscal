<%-- 
    Document   : nfBoleto
    Created on : 01/04/2012, 15:31:32
    Author     : Fernando Santiago
--%>

<%@page import="br.com.fiap.bean.Usuarios"%>
<%
            Usuarios us = (Usuarios) session.getAttribute("j_usuario");

            if (us == null) {
                response.sendRedirect("login.jsp");
            } else {
                out.print("Seja benvindo, " + us.getUsuario());
            }

%>