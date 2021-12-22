/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StaffBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Buddhima
 */
@WebServlet(name = "loginStaff", urlPatterns = {"/loginStaff"})
public class loginStaff extends HttpServlet {

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
        String staffPassword = request.getParameter("staffPassword");
        
        StaffBean sb = new StaffBean();
        
        sb.setStaffEmail(staffEmail);
        sb.setStaffPassword(staffPassword);
        
        if(sb.getApprovalStatus(staffEmail).equals("approved")) {
            
            List staffData = sb.loginStaff(staffEmail, staffPassword);
            request.setAttribute("listOfStaffData", staffData);
            
            if(!staffData.isEmpty()) {
            
                Cookie c1 = new Cookie("staffEmail",staffEmail);
                response.addCookie(c1);

                Cookie[] cookieArr = request.getCookies();

                for(Cookie cookieVar : cookieArr) {

                    if(cookieVar.getName().equals("staffEmail")) {

                        HttpSession session1 = request.getSession(true);
                        session1.setAttribute("staffEmail", cookieVar.getValue());
                        session1.setMaxInactiveInterval(1200);   // 1200 sec. 20 mts.
                        
                        Timestamp staffLastLogin  = new Timestamp(session1.getLastAccessedTime());
                        sb.setStaffLastLogin(staffLastLogin);
                        
                        String staffIP = request.getRemoteAddr();
                        sb.setStaffIP(staffIP);
                        
                        sb.getStaffIPAndLastLogin(staffEmail);
                    }
                }
                
                if(sb.getRole(staffEmail).equals("Grade 1 Staff")) {
                    RequestDispatcher rd = request.getRequestDispatcher("staffGrade1Dashboard.jsp");
                    response.setContentType("text/html; charset='UTF-8'");
                    rd.forward(request, response);
                }

                else if(sb.getRole(staffEmail).equals("Grade 2 Staff")) {
                    RequestDispatcher rd = request.getRequestDispatcher("staffGrade2Dashboard.jsp");
                    response.setContentType("text/html; charset='UTF-8'");
                    rd.forward(request, response);
                }
            }
            
            else {
                out.println("Email or password is incorrect");
            
                request.setAttribute("listOfClientData", staffData);
                RequestDispatcher rd = request.getRequestDispatcher("./loginStaff.jsp");
                response.setContentType("text/html; charset='UTF-8'");
                rd.include(request, response);
            }
            
        }
        else if(sb.getApprovalStatus(staffEmail).equals("pending")) {
            out.println("Account is not approved yet.");
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
