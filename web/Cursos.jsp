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
       
        CursoDao dao = new CursoDao();
        List<Curso> cursos = dao.listar();
        pageContext.setAttribute("cursos", cursos); 

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
                            <a href="MateriasAdmin.jsp">Cursos</a>
                        </li>
                    </ul>


                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Cursos
                        <br>
                    </h1>

                    <a class="btn btn-primary" href="novoCurso.jsp">Novo Curso</a>






                    <h2 class="sub-header">Lista de Cursos</h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Categoria</th>
                                    <th>Coordenador</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${cursos}" var="curso">
                                    <tr>
                                        <td>${curso.id}</td>
                                        <td>${curso.nome}</td>
                                        <td>${curso.categoria}</td>
                                        <td>${curso.cordenador.nome}</td>
                                        <td>
                                            <form method="post">
                                                <div class="form-group">
                                                    <label class="col-md-0 control-label" for="button1id"></label>
                                                    <div class="col-md-6 text-right">
                                                        <button id="button1id" name="edita" class="btn btn-success" onclick="form.action = 'ServEditarMateria';" value="${curso.id}">Editar</button>
                                                        <button id="button2id" name="exclui" class="btn btn-danger" onclick="form.action = 'index.html';" value="${curso.id}">Excluir</button>
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