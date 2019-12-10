<%@page import="br.com.janusamaia.meusinvestimentos.model.Usuario"%>
<!DOCTYPE html>
<jsp:useBean id="Usuario" type="Usuario" scope="session"/>
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
                <br>Atualizar cadastro <hr><br>
                <form role="form" action="atualizaCadastro" method="POST">
                    <div class="form-group">
                        <label for="InputNome">
                                Nome
                        </label>
                        <input type="text" value="${Usuario.nome}" class="form-control" id="InputNome" name="inputNome" required="true"/>
                    </div>
                    <div class="form-group">
                        <label for="InputUsername">
                                Username
                        </label>
                        <input type="text" value="${Usuario.username}" class="form-control" id="InputUsername" name="inputUsername" required="true"/>
                    </div>
                    <div class="form-group">
                        <label for="InputEmail">
                                Email
                        </label>
                        <input type="email" value="${Usuario.email}" readonly="true" class="form-control" id="InputEmail" />
                    </div>
                    
                    <!--endereço-->
                    <hr>
                    Dados complementares - Endereço
                    <hr>    
                    <div class="form-group">
                        <label for="cep">
                            CEP
                        </label>
                        <input type="text" value="${Usuario.cep}" class="form-control" id="cep" name="inputCep" onchange="buscaEndereco();"/>                            
                    </div>

                    <div class="form-group">
                        <label for="tipo">
                            Tipo do Logradouro
                        </label>
                        <input type="text" value="${Usuario.tipo}" class="form-control" id="tipo" name="inputTipo" />
                    </div>
                    <div class="form-group">
                        <label for="logradouro">
                            Logradouro
                        </label>
                        <input type="text" value="${Usuario.rua}" class="form-control" id="logradouro" name="inputRua" />
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="numero">
                                    Numero
                                </label>
                                <input type="text" value="${Usuario.numero}" class="form-control" id="numero" name="inputNumero" />
                            </div>
                        </div> 
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="complemento">
                                    Complemento
                                </label>
                                <input type="text" value="${Usuario.complemento}" class="form-control" id="complemento" name="inputComplemento" />
                            </div>
                        </div>
                    </div>    
                    
                    
                    <div class="form-group">
                        <label for="bairro">
                            Bairro
                        </label>
                        <input type="text" value="${Usuario.bairro}" class="form-control" id="bairro" name="inputBairro" />
                    </div>
                    
                    <div class="form-group">
                        <label for="cidade">
                            Cidade
                        </label>
                        <input type="text" value="${Usuario.cidade}" class="form-control" id="cidade" name="inputCidade" />
                    </div>
                    <div class="form-group">
                        <label for="estado">
                            Estado
                        </label>
                        <input type="text" value="${Usuario.estado}" class="form-control" id="estado" name="inputEstado" />
                    </div>

                    <hr>
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
    <script type="text/javascript">
        function buscaEndereco() {
            var cep = document.getElementById("cep").value;
            var xmlhttp = new XMLHttpRequest();
            var url = "http://cep.republicavirtual.com.br/web_cep.php?cep="+  cep + "&formato=json";
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.status === 200) {
                    if (xmlhttp.readyState === 4) {
                        var endereco = JSON.parse(xmlhttp.responseText);
                        if (endereco.resultado == "1") {
                            document.getElementById("tipo").value = endereco.tipo_logradouro;
                            document.getElementById("logradouro").value = endereco.logradouro;
                            document.getElementById("bairro").value = endereco.bairro;
                            document.getElementById("cidade").value = endereco.cidade;
                            document.getElementById("estado").value = endereco.uf;
                        } else {
                            alert("Endereco nao encontrado pelo CEP informado");
                        }
                    }
                }
            };
            xmlhttp.open("GET", url, true);
            xmlhttp.send();
        }
    </script>

</body>
</html>
