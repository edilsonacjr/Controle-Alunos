<%@page import="entidades.Materia"%>
<%@page import="dao.MateriaDao"%>
<%@page import="entidades.Periodo"%>
<%@page import="dao.PeriodoDao"%>
<%@page import="dao.CursoDao"%>
<%@page import="entidades.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="dao.AlunoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entidades.Curso" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="assets/img/faviconsss.ico">
        <title>SisAlunos</title>
        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="dashboard.css" rel="stylesheet">
    </head>
    <%
        
        CursoDao daoC = new CursoDao();
        List<Curso> cursos = daoC.listar();
        pageContext.setAttribute("cursos", cursos);

        PeriodoDao daop = new PeriodoDao();
        List<Periodo> periodos = daop.listar();
        pageContext.setAttribute("periodos", periodos);

        MateriaDao daom = new MateriaDao();
        List<Materia> materias = daom.listar();
        pageContext.setAttribute("materias", materias);


    %>
    <body>

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
                            <a href="logoff.jsp">Sair
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
                            <a href="principalProf.jsp" >Página Principal</a>
                        </li>
                        <li  class="active">
                            <a href="preLancarNotas.jsp">Lançar notas</a>
                        </li>
                        <li>
                            <a href="preLancarFaltas.jsp">Lançar Faltas</a>
                        </li>
                    </ul>


                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Lançar Notas
                        <br>
                    </h1>

                    <h2 class="sub-header"></h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>                                    
                                    <th>Notas</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${alunos}" var="aluno">
                                    <tr>
                                <form method="post">
                                    <td>${aluno.id}</td>
                                    <td>${aluno.nome}</td>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-md-0 control-label" for="button1id"></label>
                                            <div class="col-md-6 text-right">                                                
                                                 <input id="textinput" name="n1" placeholder="Nota 1" class="form-control input-sm" type="text">
                                                 <input id="textinput" name="n2" placeholder="Nota 2" class="form-control input-sm" type="text">
                                                 <input id="textinput" name="n3" placeholder="Nota 3" class="form-control input-sm" type="text">
                                            </div>
                                        </div>

                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-md-0 control-label" for="button1id"></label>
                                            <div class="col-md-6 text-right">
                                                <button id="button1id" name="alunomateria" class="btn btn-success" onclick="form.action = 'ServInserirNota';" value="${aluno.id}">Salvar</button>
                                                
                                            </div>
                                        </div>
                                    </td>
                                </form>
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