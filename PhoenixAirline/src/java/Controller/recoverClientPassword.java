/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ClientBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Buddhima
 */
@WebServlet(name = "recoverClientPassword", urlPatterns = {"/recoverClientPassword"})
public class recoverClientPassword extends HttpServlet {

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
        //processRequest(request, response);
        
        PrintWriter out = response.getWriter();
        
        String clientEmail = request.getParameter("clientEmail"); 
        String clientSecurityQuestion = request.getParameter("clientSecurityQuestion"); 
        String clientAnswer = request.getParameter("clientAnswer"); 
        
        ClientBean cb = new ClientBean();
        
        cb.setClientEmail(clientEmail);
        cb.setClientSecurityQuestion(clientSecurityQuestion);
        cb.setClientAnswer(clientAnswer);
        
        if(clientEmail.equals(cb.recoverClientPassword(clientEmail, clientSecurityQuestion, clientAnswer))) {
            out.println("<html><head><title>Forgot Password</title></head><body>"
                    + "<h3>Are you sure you want to change your password?"
                    + "<form action='updateClient.jsp' method='POST'>"
                    + "<input type='hidden' name='updateField' value='clientPassword'>"
                    + "<input type='submit' value='Yes'>"
                    + "<input type='reset' value='No'>"
                    + "<input type='hidden' name='clientEmail' value='"+clientEmail+"'>"
                    + "</form>"
                    + "</body></html>");
        }
        
        else {
            out.println("Your email does not match the security question and answer.");
            RequestDispatcher rd = request.getRequestDispatcher("./recoverClientPassword.jsp");
            response.setContentType("text/html; charset='UTF-8'");
            rd.include(request, response);
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
