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
        AlunoDao dao = new AlunoDao();
        List<Aluno> alunos = dao.listar();
        pageContext.setAttribute("alunos", alunos);

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


                    <form class="form-horizontal" action="index.html" method="post">
                        <fieldset>
                            <!-- Select Basic -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="selectbasic">Curso</label>
                                <div class="col-md-5">
                                    <select id="selectbasic" name="selectbasic" class="form-control">
                                        <option value="0" selected>Escolha</option>
                                        <c:forEach items="${cursos}" var="curso">                                            
                                            <option value="${curso.id}" >${curso.nome}</option>                                                                                     
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <!-- Select Basic -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="selectbasic">Materia</label>
                                <div class="col-md-5">
                                    <select id="selectbasic" name="selectbasic" class="form-control">
                                        <option value="0" selected>Escolha</option>
                                        <<c:forEach items="${materias}" var="materia">                                            
                                            <option value="${materia.id}">${materia.nome}</option>                                                                                     
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <!-- Button -->
                            <div class="form-group">
                                <label class="col-md-4 control-label text-right" for="singlebutton"></label>
                                <div class="col-md-5 text-right">
                                    <button id="singlebutton" name="singlebutton" class="btn btn-primary btn-sm">Seguir</button>
                                </div>
                            </div>

                        </fieldset>
                    </form>
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