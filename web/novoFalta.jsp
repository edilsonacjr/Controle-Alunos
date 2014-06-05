<%-- 
    Document   : novoFalta
    Created on : 03/06/2014, 23:46:17
    Author     : Dênis
--%>

<%@page import="entidades.AlunoMateria"%>
<%@page import="dao.AlunoMateriaDao"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProfessorDao"%>
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
        AlunoMateriaDao alunomateriadao = new AlunoMateriaDao();
        List<AlunoMateria> alunosmaterias = alunomateriadao.listar();
        pageContext.setAttribute("alunosmaterias", alunosmaterias);

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
                            <a href="Faltas.jsp">Faltas</a>
                        </li>
                        <li>
                            <a href="Notas.jsp">Notas</a>
                        </li>
                    </ul>


                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Nova Falta &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        <br>
                    </h1>

                    <form class="form-horizontal">
                        <fieldset>

                            <!-- Select Basic -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="selectbasic">Matricula do Aluno</label>
                                <div class="col-md-5">
                                    <select id="selectbasic" name="alunomateria" class="form-control">
                                        <c:forEach items="${alunosmaterias}" var="alunosmateria">                                            
                                            <option value="${alunosmateria.id}">${alunosmateria.id} - ${alunosmateria.materia.nome} - ${alunosmateria.aluno.nome}</option>                                                                                     
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">Data</label>
                                <div class="col-md-5">
                                    <input id="textinput" name="data" placeholder="Data" class="form-control input-md" type="text">

                                </div>
                            </div>

                            <!-- Button (Double) -->
                            <div class="form-group">
                                <label class="col-md-4 control-label text-left" for="button1id"></label>
                                <div class="col-md-5 text-right">
                                    <button id="button1id" name="button1id" class="btn btn-success" onclick="form.action = 'ServInserirFalta'; form.method='post';">Cadastrar</button>
                                    <button id="button2id" name="button2id" class="btn btn-danger" onclick="form.action = 'Faltas.jsp'; form.method='post';">Cancelar</button>
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

