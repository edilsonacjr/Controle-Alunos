<%-- 
    Document   : novoAlunoMateria
    Created on : 03/06/2014, 23:29:30
    Author     : Dênis
--%>

<%@page import="entidades.Materia"%>
<%@page import="dao.MateriaDao"%>
<%@page import="java.util.List"%>
<%@page import="entidades.Aluno"%>
<%@page import="dao.AlunoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
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
        AlunoDao alunodao = new AlunoDao();
        List<Aluno> alunos = alunodao.listar();
        pageContext.setAttribute("alunos", alunos);
        
        
        MateriaDao materiadao = new MateriaDao();
        List<Materia> materias = materiadao.listar();
        pageContext.setAttribute("materias", materias);

    %>

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
                    <a class="navbar-brand" href="index.jsp">SisAlunos
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
                            <a href="principalAdmin.jsp" >Página Principal</a>
                        </li>
                        <li>
                            <a href="Professores.jsp">Professores</a>
                        </li>
                        <li>
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
                        <li>
                            <a href="MateriasAdmin.jsp">Matérias</a>
                        </li>
                        <li class="active">
                            <a href="AlunosMaterias.jsp">Matrícula de Alunos</a>
                        </li>
                    </ul>


                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Nova Matricula de Aluno &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        <br>
                    </h1>

                    <form class="form-horizontal">
                        <fieldset>

                            <!-- Select Basic -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="selectbasic">Aluno</label>
                                <div class="col-md-5">
                                    <select id="selectbasic" name="aluno" class="form-control">
                                        <c:forEach items="${alunos}" var="aluno">                                            
                                            <option value="${aluno.id}">${aluno.nome}</option>                                                                                     
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <!-- Select Basic -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="selectbasic">Matéria</label>
                                <div class="col-md-5">
                                    <select id="selectbasic" name="materia" class="form-control">
                                        <c:forEach items="${materias}" var="materia">                                            
                                            <option value="${materia.id}">${materia.nome}</option>                                                                                     
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>                                                    

                            <!-- Button (Double) -->
                            <div class="form-group">
                                <label class="col-md-4 control-label text-left" for="button1id"></label>
                                <div class="col-md-5 text-right">
                                    <button id="button1id" name="button1id" class="btn btn-success" onclick="form.action = 'ServAlunoMateria'; form.method='post';">Cadastrar</button>
                                    <button id="button2id" name="button2id" class="btn btn-danger" onclick="form.action = 'AlunosMaterias.jsp'; form.method='post';">Cancelar</button>
                                </div>
                            </div>

                        </fieldset>
                    </form>
                    <div class="table-responsive">

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
