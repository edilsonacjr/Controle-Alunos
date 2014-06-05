/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.UsuarioDao;
import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dênis
 */
public class ServInserirUsuario extends HttpServlet {

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
        RequestDispatcher view = request.getRequestDispatcher("novoUsuario.jsp");
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
        Usuario u = new Usuario();
        u.setNome(request.getParameter("nome"));
        u.setCpf(request.getParameter("cpf"));
        u.setLogin(request.getParameter("login"));
        u.setSenha(request.getParameter("senha"));
        u.setEmail(request.getParameter("email"));
        String date = request.getParameter("datanasc");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(ServInserirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        u.setDataNascimento(parsedDate);
        UsuarioDao usuariodao = null;
        String erro = "<div class=\"alert alert-success\" >\n"
                + "                            Usuario: Salvo com sucesso!!!\n"
                + "                      </div>";
        try {
            usuariodao = new UsuarioDao();
            usuariodao.insere(u);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServInserirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            erro = "<div class=\"alert alert-danger\" >\n"
                    + "                            Usuário: Login invalido!!!!\n"
                    + "                      </div>";
            request.setAttribute("erro", erro);
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
