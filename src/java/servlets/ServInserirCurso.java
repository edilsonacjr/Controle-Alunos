/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.CursoDAO;
import entidades.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dênis
 */
public class ServInserirCurso extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">\n"
                    + "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "  <meta name=\"description\" content=\"\">\n"
                    + "  <meta name=\"author\" content=\"\">\n"
                    + "  <link rel=\"shortcut icon\" href=\"assets/img/faviconsss.ico\">\n"
                    + "  <title>SisAlunos</title>\n"
                    + "  <link href=\"dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                    + "  <link href=\"dashboard.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n"
                    + "    <div class=\"container-fluid\">\n"
                    + "      <div class=\"navbar-header\">\n"
                    + "        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n"
                    + "          <span class=\"sr-only\">Toggle navigation</span>\n"
                    + "          <span class=\"icon-bar\"></span>\n"
                    + "          <span class=\"icon-bar\"></span>\n"
                    + "          <span class=\"icon-bar\"></span>\n"
                    + "        </button>\n"
                    + "        <a class=\"navbar-brand\" href=\"paginaInicial.jsp\">SisAlunos\n"
                    + "          <br>\n"
                    + "        </a>\n"
                    + "      </div>\n"
                    + "      <div class=\"navbar-collapse collapse\">\n"
                    + "        <ul class=\"nav navbar-nav navbar-right\">\n"
                    + "          <li>\n"
                    + "            <a href=\"logoff.jsp\">Sair\n"
                    + "              <br>\n"
                    + "            </a>\n"
                    + "          </li>\n"
                    + "        </ul>\n"
                    + "\n"
                    + "      </div>\n"
                    + "    </div>\n"
                    + "  </div>");
            out.println("<div class=\"container-fluid\">\n"
                    + "    <div class=\"row\">\n"
                    + "      <div class=\"col-sm-3 col-md-2 sidebar\">\n"
                    + "        <ul class=\"nav nav-sidebar\">\n"
                    + "          <li>\n"
                    + "            <a href=\"#\">Página Principal</a>\n"
                    + "          </li>\n"
                    + "          <li>\n"
                    + "            <a href=\"#\">Professores</a>\n"
                    + "          </li>\n"
                    + "          <li>\n"
                    + "            <a href=\"#\">Alunos</a>\n"
                    + "          </li>\n"
                    + "          <li>\n"
                    + "          <li class=\"active\">\n"
                    + "            <a href=\"#\">Cursos</a>\n"
                    + "          </li>\n"
                    + "          <li>\n"
                    + "            <a href=\"#\">Usuários</a>\n"
                    + "          </li>\n"
                    + "        </ul>\n"
                    + "\n"
                    + "\n"
                    + "      </div>");
            out.println("</div>"
                    + "<div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\n"
                    + "        <h1 class=\"page-header\">Curso Cadastrado com Sucesso!!!! &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\n"
                    + "          <br>\n"
                    + "        </h1>"
                    + "<fieldset>"
                    + "<table class=\"table table-striped\">\n"
                    + " <thead>\n"
                    + "        <tr>\n"
                    + "            <th>Nome</th>\n"
                    + "            <th>Categoria</th>\n"
                    + "            <th>Codigo Professor</th>\n"
                    + "        </tr>\n"
                    + "    </thead>\n"
                    + "    <tbody>\n"
                    + "        <tr>\n"
                    + "            <td>"+request.getParameter("nome")+"</td>\n"
                    + "            <td>"+request.getParameter("categoria")+"</td>\n"
                    + "            <td>"+request.getParameter("professor")+"</td>\n"
                    + "        </tr>\n"
                    + "    </tbody>"
                    + "</table>"
                    + " <form class=\"form-horizontal\">\n"
                    + "  <div class=\"form-group\">\n"
                    + "              <label class=\"col-md-4 control-label text-left\" for=\"button1id\"></label>\n"
                    + "              <div class=\"col-md-5 text-right\">\n"
                    + "                <button id=\"button1id\" name=\"button1id\" class=\"btn btn-success\" onclick=\"document.forms[0].action = 'novoCurso.jsp'; return true;\">Voltar</button>\n"
                    + "              </div>\n"                   
                    + "</fieldset>"
                    + "</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Curso c = new Curso();
        c.setNome(request.getParameter("nomecurso"));
        c.getCordenador().setId(Integer.parseInt(request.getParameter("coordenador")));
        c.setCategoria(request.getParameter("categoria"));
        try {
            CursoDAO cursodao = new CursoDAO();
            cursodao.insere(c);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServInserirCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
