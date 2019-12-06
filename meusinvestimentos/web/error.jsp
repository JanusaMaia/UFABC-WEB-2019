<%-- 
    Document   : error
    Created on : 31/10/2019, 15:14:37
    Author     : janusam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="erroSTR" type="java.lang.String" scope="request"/>
            
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
            <div class="row">
                <div class="col-md-12">
                    <h3 class="text-center text-muted bg-dark font-weight-normal" style="margin-bottom: 0">
                        Meus Investimentos
                    </h3>
                </div>
            </div>
            <div class="row" style="margin-top: 0">
                <div class="col-md-12">
                    <nav class="navbar align-content-end bg-dark">
                        <ul class="nav">
                            <li class="nav-item active">
                                <a class="nav-link" href="./">Voltar</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <h3 style="alignment-adjust: central">ERRO: ${erroSTR}</h3>
                </div>    
            </div>
            
        </div>    
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>
