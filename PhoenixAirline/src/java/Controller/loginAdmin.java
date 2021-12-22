/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AdminBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "loginAdmin", urlPatterns = {"/loginAdmin"})
public class loginAdmin extends HttpServlet {

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
        
        String adminEmail = request.getParameter("adminEmail");
        String adminPassword = request.getParameter("adminPassword");
        
        AdminBean ab = new AdminBean();
        
        ab.setAdminEmail(adminEmail);
        ab.setAdminPassword(adminPassword);
        
        List adminData = ab.loginAdmin(adminEmail,adminPassword);
        
        if(!adminData.isEmpty()) {
            
            Cookie c1 = new Cookie("adminEmail",adminEmail);
            response.addCookie(c1);
            
            Cookie[] cookieArr = request.getCookies();
            
            for(Cookie cookieVar : cookieArr) {
                
                if(cookieVar.getName().equals("adminEmail")) {
                    
                    HttpSession session1 = request.getSession(true);
                    session1.setAttribute("adminEmail", cookieVar.getValue());
                    session1.setMaxInactiveInterval(1200);   // 1200 sec. 20 mts.
                }
            }
            
            request.setAttribute("listOfAdminData", adminData);
            RequestDispatcher rd = request.getRequestDispatcher("./adminDashboard.jsp");
            rd.forward(request, response);
        }
        
        else {
            out.println("Email or password is incorrect. Try again");
            RequestDispatcher rd = request.getRequestDispatcher("loginAdmin.jsp");
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
