/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StaffBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "filterStaff", urlPatterns = {"/filterStaff"})
public class filterStaff extends HttpServlet {

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
        //processRequest(request, response);
        
        String role = request.getParameter("role");
        String staffGender = request.getParameter("staffGender");
        String staffJoinedDate = request.getParameter("staffJoinedDate");
        
        StaffBean sb = new StaffBean();
        
        sb.setRole(role);
        sb.setStaffGender(staffGender);
        sb.setStaffJoinedDate(staffJoinedDate);
        
        if(!"".equals(sb.getRole())) {
            List staffList = sb.filterStaffByRole(role);
            request.setAttribute("listOfStaff", staffList);
            RequestDispatcher rd = request.getRequestDispatcher("viewStaff.jsp");
            response.setContentType("text/html; charset='UTF-8'");
            rd.forward(request, response);
        }
        
        else if(!"".equals(sb.getStaffGender())){
            List staffList = sb.filterStaffByGender(staffGender);
            request.setAttribute("listOfStaff", staffList);
            RequestDispatcher rd = request.getRequestDispatcher("viewStaff.jsp");
            response.setContentType("text/html; charset='UTF-8'");
            rd.forward(request, response);
        }
        
        else if(!"".equals(sb.getStaffJoinedDate())){
            List staffList = sb.filterStaffByJoinedDate(staffJoinedDate);
            request.setAttribute("listOfStaff", staffList);
            RequestDispatcher rd = request.getRequestDispatcher("viewStaff.jsp");
            response.setContentType("text/html; charset='UTF-8'");
            rd.forward(request, response);
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
