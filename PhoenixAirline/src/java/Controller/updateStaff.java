/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StaffBean;
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
@WebServlet(name = "updateStaff", urlPatterns = {"/updateStaff"})
@MultipartConfig
public class updateStaff extends HttpServlet {

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
        
        String staffEmail = request.getParameter("staffEmail");
        String updateField = request.getParameter("updateField");
        
        StaffBean sb = new StaffBean();
        sb.setStaffEmail(staffEmail);
        
        if(updateField.equals("role")) {
            
            String role = request.getParameter("role");
            sb.setRole(role);
            
            if(sb.updateStaffRole(staffEmail, role)) {
                out.println("Employee role was successfully updated.");
                RequestDispatcher rd = request.getRequestDispatcher("viewStaff");
                response.setContentType("text/html; charset='UTF-8'");
                rd.include(request, response);
            }
            else {
                out.println("not updated");
            }
        }
        
        if(updateField.equals("staffGender")) {
            
            String staffGender = request.getParameter("staffGender");
            sb.setStaffGender(staffGender);
            
            if(sb.updateStaffGender(staffEmail, staffGender)) {
                out.println("Employee gender was successfully updated.");
                RequestDispatcher rd = request.getRequestDispatcher("viewStaff");
                response.setContentType("text/html; charset='UTF-8'");
                rd.include(request, response);
            }
            else {
                out.println("not updated");
            }
        }
        
        if(updateField.equals("staffName")) {
            
            String staffName = request.getParameter("staffName");
            sb.setStaffName(staffName);
            
            if(sb.updateAdminName(staffEmail, staffName)) {
                out.println("Employee name was successfully updated.");
                RequestDispatcher rd = request.getRequestDispatcher("viewStaff");
                response.setContentType("text/html; charset='UTF-8'");
                rd.include(request, response);
            }
            else {
                out.println("not updated");
            }
        }
        
        if(updateField.equals("staffTel")) {
            
            String staffTel = request.getParameter("staffTel");
            sb.setStaffTel(staffTel);
            
            if(sb.updateStaffTel(staffEmail, staffTel)) {
                out.println("Employee contact number was successfully updated.");
                RequestDispatcher rd = request.getRequestDispatcher("viewStaff");
                response.setContentType("text/html; charset='UTF-8'");
                rd.include(request, response);
            }
            else {
                out.println("not updated");
            }
        }
        
        if(updateField.equals("profilePhoto")) {
            
            Part profilePhoto = request.getPart("profilePhoto");
            sb.setProfilePhoto(profilePhoto);
            
            if(sb.updateProfilePhoto(staffEmail, profilePhoto)) {
                out.println("Employee profile photo was successfully updated.");
                RequestDispatcher rd = request.getRequestDispatcher("viewStaff");
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
