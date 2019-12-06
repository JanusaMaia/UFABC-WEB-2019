<%-- 
    Document   : myaccount
    Created on : 31/10/2019, 15:11:21
    Author     : janusam
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.com.janusamaia.meusinvestimentos.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Usuario" type="Usuario" scope="session"/>
<jsp:useBean id="Totais" type="ArrayList<Double>" scope="session" />
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                    <c:if test="${empty Usuario.contas}">
                        Não há contas cadastradas.
                    </c:if>
                    <c:if test="${!empty Usuario.contas}">    
                        <c:forEach var="conta" items="${Usuario.contas}">
                            <div class="row">
                                <div class="col-md-12" style="font-style: oblique">
                                    ${conta.apelidoConta}
                                </div>                          
                            </div>
                            <c:if test="${empty conta.investimentos}">
                                Não há investimentos cadastrados.
                            </c:if>
                            <c:if test="${!empty conta.investimentos}">   
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Categoria</th>
                                            <th>Nome</th>
                                            <th>Data aplicação</th>
                                            <th>Data vencimento</th>
                                            <th>Valor aplicado</th>
                                            <th>Valor atual</th>
                                            <th>Atualizar</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="investimento" items="${conta.investimentos}">
                                            <tr>
                                                <td>
                                                    ${investimento.categoria}
                                                </td>
                                                <td>
                                                    ${investimento.nomeInvestimento}
                                                </td>
                                                <td>
                                                    <fmt:formatDate value="${investimento.dataDoInvestimento}"/>
                                                </td>
                                                <td>
                                                    <fmt:formatDate value="${investimento.dataDeVencimento}"/>
                                                </td>
                                                <td>
                                                    <fmt:formatNumber type="CURRENCY" value="${investimento.valorInicial}"/>
                                                </td>
                                                <td>
                                                    <fmt:formatNumber type="CURRENCY" value="${investimento.valorAtual}"/>
                                                </td>
                                                <td>
                                                    <a href="atualizarInvestimento?id=${investimento.id}">Editar</a>
                                                    
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </c:if>    
                        </c:forEach>
                    </c:if>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6"></div>
                <div class="col-md-3">
                    Total - Investido: <fmt:formatNumber type="CURRENCY" value="${Totais[0]}"/>
                </div>
                <div class="col-md-3">
                    Atualizado: <fmt:formatNumber type="CURRENCY" value="${Totais[1]}"/>
                </div>
            </div>
        </div>   
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    </body>
</html>
