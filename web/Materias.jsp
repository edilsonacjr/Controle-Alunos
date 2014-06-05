<%@page import="entidades.MateriaNotaFalta"%>
<%@page import="java.util.List"%>
<%@page import="dao.AlunoDao"%>
<%@page import="entidades.Aluno"%>
<%@page import="entidades.Materia"%>
<%@page import="entidades.Nota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head></head>
<%
        HttpSession sessao = request.getSession(true);
        Aluno a = (Aluno) sessao.getAttribute("aluno");
        AlunoDao dao = new AlunoDao();
        List<MateriaNotaFalta> mnfs = dao.getMateriaNotaFalta(a);
        pageContext.setAttribute("mnfs", mnfs);
        
    %>
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
        <a class="navbar-brand" href="principalAlunos">SisAlunos
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
          <li>
            <a href="principalAlunos.jsp" >Página Principal</a>
          </li>
          <li class="active">
            <a href="Materias.jsp">Matérias</a>
          </li>
        </ul>


      </div>
      <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Histórico
                        <br>
                    </h1>

                    <h2 class="sub-header"></h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Materia</th>
                                    <th>Faltas</th>
                                    <th>Notas</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${mnfs}" var="mnf">
                                    <tr>
                                        <td>${mnf.materia.nome}</td>
                                        <td>${mnf.falta}</td>
                                        <td>${mnf.nota.n1}</td>                                        
                                    </tr>

                                </c:forEach>                                
                            </tbody>
                        </table>
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
