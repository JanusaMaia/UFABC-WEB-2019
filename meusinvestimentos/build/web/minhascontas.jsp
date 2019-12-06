<%-- 
    Document   : myaccount
    Created on : 31/10/2019, 15:11:21
    Author     : janusam
--%>

<%@page import="br.com.janusamaia.meusinvestimentos.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Usuario" type="Usuario" scope="session"/>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Meus Investimentos</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/style.css" type="text/css">
        
    </head>
    <body>
        <div class="container-fluid">
            <jsp:include page="menulogado.jsp" />
            
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Nome da Conta</th>
                                <th>Banco</th>
                                <th>Agência/Conta</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${empty Usuario.contas}">
                                <h4> Não há contas cadastradas</h4>    
                            </c:if>
                            <c:forEach var="conta" items="${Usuario.contas}">
                                <tr>
                                    <td>
                                        ${conta.apelidoConta}
                                    </td>
                                    <td>
                                        ${conta.banco}
                                    </td>
                                    <td>
                                        ${conta.agencia}/${conta.numero}
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            
        </div>    
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>
