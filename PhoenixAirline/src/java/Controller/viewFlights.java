/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FlightBean;
import Model.StaffBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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
@WebServlet(name = "viewFlights", urlPatterns = {"/viewFlights"})
public class viewFlights extends HttpServlet {

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
        
        PrintWriter out = response.getWriter();
       
        String role = request.getParameter("role");

        StaffBean sb = new StaffBean();
        FlightBean fb = new FlightBean();
        
        sb.setRole(role);

        List flightList = fb.viewFlights();
        
        if(sb.getRole().equals("Grade 1 Staff")) {
            request.setAttribute("listOfFlights", flightList);
            RequestDispatcher rd = request.getRequestDispatcher("viewFlightsG1.jsp");
            response.setContentType("text/html; charset='UTF-8'");
            rd.forward(request, response);
        }

        else if(sb.getRole().equals("Grade 2 Staff")) {
            request.setAttribute("listOfFlights", flightList);
            request.setAttribute("role", sb.getRole());
            RequestDispatcher rd = request.getRequestDispatcher("viewFlightsG2.jsp");
            response.setContentType("text/html; charset='UTF-8'");
            rd.forward(request, response);
        }
        
        else {
            out.println("Flight list is empty.");
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
        //processRequest(request, response);
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
