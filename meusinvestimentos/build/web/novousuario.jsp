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
        <div class="row">
            <div class="col-md-12">
                <h3 class="text-center text-muted bg-dark font-weight-normal" style="margin-bottom: 0">
                    Meus Investimentos
                </h3>
            </div>
        </div>
        <div class="row">
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
            <div class="col-md-3">
            </div>
            <div class="col-md-6">
                <br><br>
                <form role="form" action="efetivaCadastro" method="POST">
                    <div class="form-group">
                        <label for="InputNome">
                                Nome
                        </label>
                        <input type="text" class="form-control" id="InputNome" name="inputNome" required="true"/>
                    </div>
                    <div class="form-group">
                        <label for="InputUsername">
                                Username
                        </label>
                        <input type="text" class="form-control" id="InputUsername" name="inputUsername" required="true"/>
                    </div>
                    <div class="form-group">
                        <label for="InputEmail">
                                Email
                        </label>
                        <input type="email" class="form-control" id="InputEmail" name="inputEmail" required="true" />
                    </div>
                    <div class="form-group">
                        <label for="InputSenha">
                                Senha
                        </label>
                        <input type="password" class="form-control" id="InputSenha" name="inputSenha" required="true"/>
                    </div>
                    
                    <!--endereço-->
                    <hr>
                    Dados complementares - Endereço
                    <hr>    
                    <div class="form-group">
                        <label for="cep">
                            Digite o CEP
                        </label>
                        <input type="text" class="form-control" id="cep" name="inputCep" onblur="buscaEndereco();"/>                            
                    </div>

                    <div class="form-group">
                        <label for="tipo">
                            Tipo do Logradouro
                        </label>
                        <input type="text" readonly="true" class="form-control" id="tipo" name="inputTipo" />
                    </div>
                    <div class="form-group">
                        <label for="logradouro">
                            Logradouro
                        </label>
                        <input type="text" readonly="true" class="form-control" id="logradouro" name="inputRua" />
                    </div>
                    <div class="form-group">
                        <label for="numero">
                            Numero
                        </label>
                        <input type="text" class="form-control" id="numero" name="inputNumero" />
                    </div>
                    <div class="form-group">
                        <label for="complemento">
                            Complemento
                        </label>
                        <input type="text" class="form-control" id="complemento" name="inputComplemento" />
                    </div>
                    <div class="form-group">
                        <label for="bairro">
                            Bairro
                        </label>
                        <input type="text" readonly="true" class="form-control" id="bairro" name="inputBairro" />
                    </div>
                    <div class="form-group">
                        <label for="cidade">
                            Cidade
                        </label>
                        <input type="text" readonly="true"  class="form-control" id="cidade" name="inputCidade" />
                    </div>
                    <div class="form-group">
                        <label for="estado">
                            Estado
                        </label>
                        <input type="text" readonly="true" class="form-control" id="estado" name="inputEstado" />
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
