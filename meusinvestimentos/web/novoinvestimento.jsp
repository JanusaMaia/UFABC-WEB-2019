<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@page import="br.com.janusamaia.meusinvestimentos.model.Usuario"%>
<jsp:useBean id="Usuario" type="Usuario" scope="session" />
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
            <div class="col-md-3">
            </div>
            <div class="col-md-6">
                <br><br>
                <form role="form" action="efetivaInvestimento" method="POST">
                    <div class="form-group">
                        <label for="selectNomeConta">Nome da Conta:</label>
                        <select class="form-control" id="selectNomeConta" name="selectNomeConta">
                            <option></option>
                            <c:forEach var="conta" items="${Usuario.contas}">
                                <option value="${conta.id}" >${conta.apelidoConta}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="InputNome">
                                Nome do investimento
                        </label>
                        <input type="text" class="form-control" id="InputBanco" name="inputNome" required="true"/>
                    </div>
                    <div class="form-group">
                        <label for="SelectCategoria">Categoria:</label>
                        <select class="form-control" id="SelectCategoria" name="selectCategoria">
                            <option></option>
                            <option>Renda Fixa</option>
                            <option>Renda Variável</option>
                            <option>Fundos de Investimento</option>
                            <option>Ações</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="InputDataI">
                                Data de investimento
                        </label>
                        <input type="date" class="form-control" id="InputDataI" name="inputDataI" required="true" />
                    </div>
                    <div class="form-group">
                        <label for="InputDataF">
                                Data de vencimento
                        </label>
                        <input type="date" class="form-control" id="InputDataF" name="inputDataF" required="true" />
                    </div>
<!--                    <div class="form-group">
                        <label for="InputValorInicial">
                                Valor investido
                        </label>
                        <input type="text" class="form-control"  id="InputValorInicial" name="inputValorInicial" required="true"/>
                    </div>-->
                    <div class="form-row">
                        <label for="InputValorInicial">
                            Valor investido
                        </label>
                        <div class="input-group"> 
                            <span class="input-group-addon">R$</span>
                            <input type="number" value="1.00" min="1.00" step="0.01" data-number-to-fixed="2" data-number-stepfactor="100" class="form-control currency" id="InputValorInicial" name="inputValorInicial" />
                        </div>
                    </div>    

                    <button type="submit" class="btn btn-primary">
                            Salvar
                    </button>
                </form>
            </div>
            <div class="col-md-3">
            </div>
        </div>
        
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
</body>
</html>
