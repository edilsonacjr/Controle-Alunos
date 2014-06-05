<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entidades.Aluno" %>
<%@page import="entidades.Curso" %>
<%@page import="entidades.Periodo" %>
<%@page import="entidades.Materia" %>
<%@page import="java.util.*" %>
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

    <body>
        <%
            //List<Curso> cs = (List) request.getAttribute("cursos");
            //System.out.println(cs);
            %>
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
                            <a href="index.jsp">Página Principal</a>
                        </li>
                        <li>
                            <a href="Professores.jsp">Professores</a>
                        </li>
                        <li class="active">
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
                        <li>
                            <a href="AlunosMaterias.jsp">Matricula de Aluno</a>
                        </li>
                    </ul>


                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Editar Aluno &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        <br>
                    </h1>

                    <form class="form-horizontal">
                        <fieldset>



                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput" >Nome</label>
                                <div class="col-md-5">
                                    <input id="textinput" name="nome" placeholder="Nome" class="form-control input-md" type="text" value="${aluno.nome}">

                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">CPF</label>
                                <div class="col-md-5">
                                    <input id="textinput" name="cpf" placeholder="CPF" class="form-control input-md" type="text" value="${aluno.cpf}">

                                </div>
                            </div>
                             
                                    <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">Data de Admissão</label>
                                <div class="col-md-5">
                                    <input id="textinput" name="dataadmissao" placeholder="dataadmissao" class="form-control input-md" type="text" value="${aluno.dataAdmissao}">

                                </div>
                            </div>
                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">Data de Nascimento</label>
                                <div class="col-md-5">
                                    <input id="textinput" name="data" placeholder="data" class="form-control input-md" type="text" value="${aluno.dataNascimento}">

                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">E-mail</label>
                                <div class="col-md-5">
                                    <input id="textinput" name="email" placeholder="E-mail" class="form-control input-md" type="text" value="${aluno.email}">

                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">Login</label>
                                <div class="col-md-5">
                                    <input id="textinput" name="login" placeholder="Login" class="form-control input-md" type="text" value="${aluno.login}">

                                </div>
                            </div>

                            <!-- Password input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="passwordinput">Senha</label>
                                <div class="col-md-5">
                                    <input id="passwordinput" name="senha" placeholder="Senha" class="form-control input-md" type="password" value="${aluno.senha}">

                                </div>
                            </div>

                            <!-- Select Basic -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="selectbasic">Curso</label>
                                <div class="col-md-5">
                                    <select id="selectbasic" name="curso" class="form-control">
                                        <c:forEach items="${cursos}" var="curso">
                                            <c:if test="${curso.id == aluno.curso.id}">
                                                <option value="${curso.id}" selected>${curso.nome}</option>
                                            </c:if>
                                            <c:if test="${curso.id != aluno.curso.id}">
                                                <option value="${curso.id}">${curso.nome}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <!-- Button (Double) -->
                            <div class="form-group">
                                <label class="col-md-4 control-label text-left" for="button1id"></label>
                                <div class="col-md-5 text-right">
                                    <button id="button1id" name="button1id" class="btn btn-success" onclick="form.action = 'ServAtualizarAluno'; form.method='post'" value="${aluno.id}" >Salvar</button>
                                    <button id="button2id" name="button2id" class="btn btn-danger" onclick="form.action = 'Alunos.jsp'; form.method='post';">Cancelar</button>
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