<%-- 
    Document   : nfBoleto
    Created on : 01/04/2012, 15:31:32
    Author     : Fernando Santiago
--%>

<%@page import="br.com.fiap.jasper.PrintNotaFiscalBoleto"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nota Fiscal e Boleto</title>
    </head>
    <body>
        <h1>Impressão Nota Fiscal e Boleto</h1>
        <p>
            
            <%
                        PrintNotaFiscalBoleto report = new PrintNotaFiscalBoleto();
                        report.main(null);
            %>
            
        </p>
    </body>
</html>
