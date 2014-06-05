<%@page import="java.util.List"%>
<%@page import="dao.CursoDao"%>
<%@page import="entidades.Aluno"%>
<%@page import="entidades.Curso"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head></head>
    <%
        HttpSession sessao = request.getSession(true);
        Aluno a = (Aluno) sessao.getAttribute("aluno");
        //AlunoDao dao = new AlunoDao();
        //List<MateriaNotaFalta> mnfs = dao.getMateriaNotaFalta(a);
        CursoDao dao = new CursoDao();
        List<Curso> cursos = dao.listar();
        
        pageContext.setAttribute("cursos", cursos);
        pageContext.setAttribute("aluno", a);
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
                    <a class="navbar-brand" href="principalAlunos.jsp">SisAlunos
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
                            <a href="principalAlunos.jsp" >Página Principal</a>
                        </li>
                        <li>
                            <a href="Materias.jsp">Matérias</a>
                        </li>
                    </ul>



                </div>   
            </div>
        </div>
        <div>


        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Informações Pessoais &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                <br>
            </h1>

            <div class="table-responsive">
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Nome</label>
                    <div class="col-md-5">
                        <input disabled="true" value="${aluno.nome}" id="textinput" name="nome" placeholder=" " class="form-control input-md" type="text">
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">CPF</label>
                    <div class="col-md-5">
                        <input disabled="true" value="${aluno.cpf}" id="textinput" name="cpf" placeholder="CPF" class="form-control input-md" type="text">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Data de Nascimento</label>
                    <div class="col-md-5">
                        <input disabled="true" value="${aluno.nome}" id="textinput" name="data" placeholder="Data de Nascimento" class="form-control input-md" type="text">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">E-mail</label>
                    <div class="col-md-5">
                        <input disabled="true" value="${aluno.email}" id="textinput" name="email" placeholder="E-mail" class="form-control input-md" type="text">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Login</label>
                    <div class="col-md-5">
                        <input disabled="true" value="${aluno.login}" id="textinput" name="login" placeholder="Login" class="form-control input-md" type="text">

                    </div>
                </div>
                        
                        <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Curso</label>
                    <div class="col-md-5">
                        <c:forEach items="${cursos}" var="curso" >
                            <c:if test="${curso.id == aluno.curso.id}">
                                <input disabled="true" value="${curso.nome}" id="curso" name="curso" placeholder="Curso" class="form-control input-md" type="text">
                            </c:if>
                        </c:forEach>

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
