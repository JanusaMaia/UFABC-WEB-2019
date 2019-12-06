<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@page import="br.com.janusamaia.meusinvestimentos.model.Usuario"%>
<jsp:useBean id="Usuario" type="Usuario" scope="session" />
<jsp:useBean id="IdInvest" type="Integer" scope="session" />
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
                <form role="form" action="efetivaAtualizarInvestimento" method="POST">
                    
                    <div class="form-group">
                        <label for="InputId">
                                ID investimento
                        </label>
                        <input type="text" class="form-control" id="InputId" name="inputId" value="${IdInvest}" readonly="true" required="true"/>
                    </div>
                    
                    <div class="form-group">
                        <label for="InputData">
                                Data
                        </label>
                        <input type="date" class="form-control" id="InputData" name="inputData" required="true" />
                    </div>
                    
                    <div class="form-group">
                        <label for="InputValor">
                                Valor Atual
                        </label>
                        <input type="text" class="form-control" id="InputValor" name="inputValor" required="true"/>
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
