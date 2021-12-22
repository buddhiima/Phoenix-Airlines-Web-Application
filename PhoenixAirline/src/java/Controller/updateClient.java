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
@WebServlet(name = "updateClient", urlPatterns = {"/updateClient"})
@MultipartConfig
public class updateClient extends HttpServlet {

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
        String updateField = request.getParameter("updateField");
        
        ClientBean cb = new ClientBean();
        cb.setClientEmail(clientEmail);
        
        if(updateField.equals("clientName")) {
            
            String clientName = request.getParameter("clientName");
            cb.setClientName(clientName);
            
            if(cb.updateClientName(clientEmail, clientName)) {
                out.println("Your name was updated successfully. Log in to continue");
                RequestDispatcher rd = request.getRequestDispatcher("./loginClient.jsp");
                response.setContentType("text/html; charset='UTF-8'");
                rd.include(request, response);
            }
            else {
                out.println("not updated");
            }
        }
            
        if(updateField.equals("clientGender")) {

            String clientGender = request.getParameter("clientGender");
            cb.setClientGender(clientGender);

            if(cb.updateClientGender(clientEmail, clientGender)) {
                out.println("Your gender was updated successfully. Log in to continue");
                RequestDispatcher rd = request.getRequestDispatcher("./loginClient.jsp");
                response.setContentType("text/html; charset='UTF-8'");
                rd.include(request, response);
            }
            else {
                out.println("not updated");
            }
        }
        
        if(updateField.equals("clientTel")) {

            String clientTel = request.getParameter("clientTel");
            cb.setClientTel(clientTel);

            if(cb.updateClientTel(clientEmail, clientTel)) {
                out.println("Your contact number was updated successfully. Log in to continue");
                RequestDispatcher rd = request.getRequestDispatcher("./loginClient.jsp");
                response.setContentType("text/html; charset='UTF-8'");
                rd.include(request, response);
            }
            else {
                out.println("not updated");
            }
            
        }
        
        if(updateField.equals("clientAddress")) {

            String clientHouseNo = request.getParameter("clientHouseNo");
            String clientStreetName = request.getParameter("clientStreetName");
            String clientCity = request.getParameter("clientCity");
            String clientProvince = request.getParameter("clientProvince");
            cb.setClientHouseNo(clientHouseNo);
            cb.setClientStreetName(clientStreetName);
            cb.setClientCity(clientCity);
            cb.setClientProvince(clientProvince);

            if(cb.updateClientAddress(clientEmail, clientHouseNo, clientStreetName, clientCity, clientProvince)) {
                out.println("Your address was updated successfully. Log in to continue");
                RequestDispatcher rd = request.getRequestDispatcher("./loginClient.jsp");
                response.setContentType("text/html; charset='UTF-8'");
                rd.include(request, response);
            }
            else {
                out.println("not updated");
            }
            
        }
        
        if(updateField.equals("profilePhoto")) {
            
            Part profilePhoto = request.getPart("profilePhoto");
            cb.setProfilePhoto(profilePhoto);
            
            if(cb.updateProfilePhoto(clientEmail, profilePhoto)) {
                out.println("Your profile photo was successfully updated. Log in to continue");
                RequestDispatcher rd = request.getRequestDispatcher("./loginClient.jsp");
                response.setContentType("text/html; charset='UTF-8'");
                rd.include(request, response);
            }
            else {
                out.println("not updated");
            }
        }
        
        if(updateField.equals("clientPassword")) {
            
            String clientPassword = request.getParameter("clientPassword");
            cb.setClientPassword(clientPassword);
            
            if(cb.updateClientPassword(clientEmail, clientPassword)) {
                out.println("You password was successfully updated. Log in to continue");
                RequestDispatcher rd = request.getRequestDispatcher("./loginClient.jsp");
                response.setContentType("text/html; charset='UTF-8'");
                rd.include(request, response);
            }
            else {
                out.println("not updated");
            }
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
