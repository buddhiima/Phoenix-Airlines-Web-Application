/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ClientBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Buddhima
 */
@WebServlet(name = "registerClient", urlPatterns = {"/registerClient"})
@MultipartConfig
public class registerClient extends HttpServlet {

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
        
            String clientName = request.getParameter("clientName");
            Date clientDOB = Date.valueOf(request.getParameter("clientDOB"));
            String clientGender = request.getParameter("clientGender");
            String clientEmail = request.getParameter("clientEmail");
            String clientTel = request.getParameter("clientTel");
            String clientHouseNo = request.getParameter("clientHouseNo");
            String clientStreetName = request.getParameter("clientStreetName");
            String clientCity = request.getParameter("clientCity");
            String clientProvince = request.getParameter("clientProvince");
            String clientPassword = request.getParameter("clientPassword");
            Part profilePhoto = request.getPart("profilePhoto");
            String clientSecurityQuestion = request.getParameter("clientSecurityQuestion");
            String clientAnswer = request.getParameter("clientAnswer");
            
        try {

            ClientBean cb = new ClientBean();
            cb.setClientName(clientName);
            cb.setClientDOB(clientDOB);
            cb.setClientGender(clientGender);
            cb.setClientEmail(clientEmail);
            cb.setClientTel(clientTel);
            cb.setClientHouseNo(clientHouseNo);
            cb.setClientStreetName(clientStreetName);
            cb.setClientCity(clientCity);
            cb.setClientProvince(clientProvince);
            cb.setClientPassword(clientPassword);
            cb.setProfilePhoto(profilePhoto);
            cb.setClientSecurityQuestion(clientSecurityQuestion);
            cb.setClientAnswer(clientAnswer);
        
            cb.registerClient(clientName,clientDOB,clientGender,clientEmail,clientTel,clientHouseNo,clientStreetName,clientCity,clientProvince,clientPassword,profilePhoto,clientSecurityQuestion,clientAnswer);
            out.println("registered");
            RequestDispatcher rd = request.getRequestDispatcher("loginClient.jsp");
            response.setContentType("text/html; charset='UTF-8'");
            rd.include(request, response);
            
        }catch(BaseException e) {
            out.println("<html><head></head><body><h3>"+e.getMessage()+"</h3></body></html>");
            RequestDispatcher rd = request.getRequestDispatcher("registerClient.jsp");
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
