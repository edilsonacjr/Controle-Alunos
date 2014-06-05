<%@page import="entidades.Curso"%>
<%@page import="entidades.Materia"%>
<%@page import="entidades.Professor"%>
<%@page import="dao.MateriaDao"%>
<%@page import="entidades.Periodo"%>
<%@page import="dao.PeriodoDao"%>
<%@page import="dao.CursoDao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        MateriaDao dao = new MateriaDao();
        List<Materia> materias = dao.listar();
        pageContext.setAttribute("materias", materias);

        CursoDao daoC = new CursoDao();
        List<Curso> cursos = daoC.listar();
        pageContext.setAttribute("cursos", cursos);
        
        PeriodoDao daoP = new PeriodoDao();
        List<Periodo> periodos = daoP.listar();
        pageContext.setAttribute("periodos", periodos);
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
                    <a class="navbar-brand" href="principalAdmin.jsp">SisAlunos
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
                        <li >
                            <a href="principalAdmin.jsp">Página Principal</a>
                        </li>
                        <li>
                            <a href="Professores.jsp">Professores</a>
                        </li>
                        <li >
                            <a href="Alunos.jsp">Alunos</a>
                        </li>
                        <li>
                            <a href="Cursos.jsp">Cursos</a>
                        </li>
                        <li>
                            <a href="Usuarios.jsp">Usuários</a>
                        </li>
                        <li>
                            <a href="Periodos.jsp">Períodos</a>
                        </li>
                        <li class="active">
                            <a href="MateriasAdmin.jsp">Matérias</a>
                        </li>
                        <li>
                            <a href="AlunosMaterias.jsp">Matrícula de Alunos</a>
                        </li>
                    </ul>


                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Matérias
                        <br>
                    </h1>

                    <a class="btn btn-primary" href="novoMateria.jsp">Novo Matéria</a>


                    <form class="form-horizontal" action="index.html" method="post">
                        <fieldset>

                            <!-- Form Name -->
                            <legend>Consulta</legend>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">Termo de consulta:</label>
                                <div class="col-md-5">
                                    <input id="textinput" name="textinput" placeholder="Termos" class="form-control input-md" type="text">

                                </div>
                            </div>

                            <!-- Button -->
                            <div class="form-group">
                                <label class="col-md-4 control-label text-right" for="singlebutton"></label>
                                <div class="col-md-5 text-right">
                                    <button id="singlebutton" name="singlebutton" class="btn btn-primary btn-sm">Buscar</button>
                                </div>
                            </div>

                        </fieldset>
                    </form>





                    <h2 class="sub-header">Lista de Matérias</h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Período</th>
                                    <th>Professor</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${materias}" var="materia">
                                    <tr>
                                        <td>${materia.id}</td>
                                        <td>${materia.nome}</td>
                                        <td>${materia.periodo.nome}</td>
                                        <td>${materia.professor.nome}</td>
                                        <td>
                                            <form method="post">
                                                <div class="form-group">
                                                    <label class="col-md-0 control-label" for="button1id"></label>
                                                    <div class="col-md-6 text-right">
                                                        <button id="button1id" name="edita" class="btn btn-success" onclick="form.action = 'ServEditarMateria';" value="${materia.id}">Editar</button>
                                                        <button id="button2id" name="exclui" class="btn btn-danger" onclick="form.action = 'ServExcluirMateria';" value="${materia.id}">Excluir</button>
                                                    </div>
                                                </div>
                                            </form>
                                        </td>
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