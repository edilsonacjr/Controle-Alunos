/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.AlunoDao;
import dao.ProfessorDao;
import dao.UsuarioDao;
import entidades.Aluno;
import entidades.Professor;
import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author edilson
 */
@WebServlet(name = "ServLogin", urlPatterns = {"/ServLogin"})
public class ServLogin extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Aluno a = new Aluno();
        AlunoDao daoa = new AlunoDao();
        a.setLogin(login);
        a.setSenha(senha);
        a = daoa.validaAluno(a);
        if (a != null) {
            HttpSession sessao = request.getSession(true);
            sessao.setMaxInactiveInterval(30 * 60);
            sessao.setAttribute("usr", "Alun-" + login);
            response.sendRedirect("principalAlunos.jsp");
            System.out.println("TESTE");
            return;
        }

        Professor p = new Professor();
        ProfessorDao daop = new ProfessorDao();
        p.setLogin(login);
        p.setSenha(senha);
        p = daop.validaProfessor(p);
        if (p != null) {
            HttpSession sessao = request.getSession(true);
            sessao.setMaxInactiveInterval(30 * 60);
            sessao.setAttribute("usr", "Prof-" + login);
            response.sendRedirect("principalProf.jsp");
            return;
        }

        Usuario u = new Usuario();
        UsuarioDao daou = new UsuarioDao();
        u.setLogin(login);
        u.setSenha(senha);
        u = daou.validaUsuario(u);
        if (u != null) {
            HttpSession sessao = request.getSession(true);
            sessao.setMaxInactiveInterval(30 * 60);
            sessao.setAttribute("usr", "Admin-" + login);
            response.sendRedirect("principalAdmin.jsp");
            return;
        }
        String erro = "<div class=\"alert alert-danger\" >\n"
                + "                            Usuário ou senha Inválida\n"
                + "                      </div>";
        request.setAttribute("erro", erro);
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);

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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
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
