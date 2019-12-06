
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
                <form role="form" action="efetivaConta" method="POST">
                    <div class="form-group">
                        <label for="InputNomeConta">
                                Nome da conta
                        </label>
                        <input type="text" class="form-control" id="InputNomeConta" name="inputNomeConta" required="true"/>
                    </div>
                    <div class="form-group">
                        <label for="InputBanco">
                                Banco
                        </label>
                        <input type="text" class="form-control" id="InputBanco" name="inputBanco" required="true"/>
                    </div>
                    <div class="form-group">
                        <label for="InputAgencia">
                                Agência
                        </label>
                        <input type="text" class="form-control" id="InputAgencia" name="inputAgencia" required="true"/>
                    </div>
                    <div class="form-group">
                        <label for="InputNumero">
                                Número
                        </label>
                        <input type="text" class="form-control" id="InputNumero" name="inputNumero" required="true" />
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
</body>
</html>
