/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AdminBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "registerAdmin", urlPatterns = {"/registerAdmin"})
@MultipartConfig
public class registerAdmin extends HttpServlet {

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
        
        String adminName = request.getParameter("adminName");
        String adminEmail = request.getParameter("adminEmail");
        String adminGender = request.getParameter("adminGender");
        String adminTel = request.getParameter("adminTel");
        String adminPassword = request.getParameter("adminPassword");
        Part profilePhoto  = request.getPart("profilePhoto");
        
        AdminBean ab = new AdminBean();
        
        ab.setAdminName(adminName);
        ab.setAdminEmail(adminEmail);
        ab.setAdminGender(adminGender);
        ab.setAdminTel(adminTel);
        ab.setAdminPassword(adminPassword);
        ab.setProfilePhoto(profilePhoto);
        
        if(ab.registerAdmin(adminName,adminEmail,adminGender,adminTel,adminPassword,profilePhoto)) {
            out.println("registered");
            
            RequestDispatcher rd = request.getRequestDispatcher("loginAdmin.jsp");
            response.setContentType("text/html; charset='UTF-8'");
            rd.include(request, response);
        }
        
        else {
            out.println("Could not register");
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
