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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josepedro
 */
@WebServlet(name = "ServAtualizarUsuario", urlPatterns = {"/ServAtualizarUsuario"})
public class ServAtualizarUsuario extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        Usuario u = new Usuario();
        u.setId(Integer.parseInt(request.getParameter("button1id")));
        u.setNome(request.getParameter("nome"));
        u.setCpf(request.getParameter("cpf"));
        String date = request.getParameter("data");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(ServInserirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        u.setDataNascimento(parsedDate);
        u.setEmail(request.getParameter("email"));
        u.setLogin(request.getParameter("login"));
        u.setSenha(request.getParameter("senha"));
        try {
            UsuarioDao usuariodao = new UsuarioDao();
            usuariodao.atualiza(u);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServInserirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher view = request.getRequestDispatcher("Usuarios.jsp");
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
