<%-- 
    Document   : nfBoleto
    Created on : 01/04/2012, 15:31:32
    Author     : Fernando Santiago
--%>

<%@include file="valida.jsp" %>

<%
    if (request.getMethod().equals("POST")) {

        String acao = request.getParameter("Submit");
        
        if (acao != null && acao.length() > 0) {
            response.sendRedirect("notaFiscalBoleto.jsp");
        } else {
            response.sendRedirect("boleto.jsp");
        }
    }
%>


<html>
    <head>
        <title>Trabalho Jasper</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    </head>

    <body>
        <form action="" method="post">
            <p>Consulta de NFs</p>
            <p> 
                <input type="submit" name="Submit" value="Vizualizar NFs com Boleto">
            </p>
            <p> 
                <input type="submit" name="Submit2" value="Visualizar Boleto">
            </p>
        </form>
    </body>
</html>
