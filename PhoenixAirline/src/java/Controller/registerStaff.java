/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StaffBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "registerStaff", urlPatterns = {"/registerStaff"})
@MultipartConfig
public class registerStaff extends HttpServlet {

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
        
        String role = request.getParameter("role");
        String staffName = request.getParameter("staffName");
        String staffEmail = request.getParameter("staffEmail");
        String staffGender = request.getParameter("staffGender");
        String staffTel = request.getParameter("staffTel");
        String staffPassword = request.getParameter("staffPassword");
        Part profilePhoto  = request.getPart("profilePhoto");
        
        StaffBean sb = new StaffBean();
        
        sb.setRole(role);
        sb.setStaffName(staffName);
        sb.setStaffEmail(staffEmail);
        sb.setStaffGender(staffGender);
        sb.setStaffTel(staffTel);
        sb.setStaffPassword(staffPassword);
        sb.setProfilePhoto(profilePhoto);
        
        if(sb.registerStaff(role,staffName,staffEmail,staffGender,staffTel,staffPassword,profilePhoto)) {
            out.println("registered. Employee can log in once they are approved.");
        }
        
        else {
            out.println("Could not register staff");
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
