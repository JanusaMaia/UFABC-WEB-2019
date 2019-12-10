<%-- 
    Document   : myaccount
    Created on : 31/10/2019, 15:11:21
    Author     : janusam
--%>

<%@page import="br.com.janusamaia.meusinvestimentos.model.Investimento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.janusamaia.meusinvestimentos.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Usuario" type="Usuario" scope="session"/>
<jsp:useBean id="Totais" type="ArrayList<Double>" scope="session" />
<jsp:useBean id="Investimentos" type="ArrayList<Investimento>" scope="session" />
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
                    <a href="./gerarPdf">
                        GerarPDF
                    </a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <c:if test="${empty Investimentos}">
                        Não há investimentos cadastradas.
                    </c:if>
                    <c:if test="${!empty Investimentos}">    
                        
                               
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Categoria</th>
                                            <th>Nome</th>
                                            <th>Data aplicação</th>
                                            <th>Data vencimento</th>
                                            <th>Valor aplicado</th>
                                            <th>Valor atual</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="investimento" items="${Investimentos}">
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
                                                
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
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
        <script src="https://kit.fontawesome.com/yourcode.js"></script>
       
    </body>
</html>
