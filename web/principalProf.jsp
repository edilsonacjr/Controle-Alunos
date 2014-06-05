<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head></head>

<body>

  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" href="assets/img/faviconsss.ico">
  <title>SisAlunos</title>
  <link href="dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="dashboard.css" rel="stylesheet">



  <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="paginaInicial.jsp">SisAlunos
          <br>
        </a>
      </div>
      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
          <li>
            <a href="ServLogoff">Sair
              <br>
            </a>
          </li>
        </ul>

      </div>
    </div>
  </div>

  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-3 col-md-2 sidebar">
        <ul class="nav nav-sidebar">
          <li class="active">
            <a href="principalProf.jsp" >Página Principal</a>
          </li>
          <li>
            <a href="preLancarNotas.jsp">Lançar notas</a>
          </li>
          <li>
            <a href="preLancarFaltas.jsp">Lançar Faltas</a>
          </li>
        </ul>


      </div>
      <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

        <div class="table-responsive">
          <c:foreach items="${alunos}" var="aluno">
          </c:foreach>

        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript
          ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  <script src="dist/js/bootstrap.min.js"></script>
  <script src="assets/js/docs.min.js"></script>














































































</body>

</html>