/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TicketBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
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
@WebServlet(name = "getAvailableFlights", urlPatterns = {"/getAvailableFlights"})
public class getAvailableFlights extends HttpServlet {

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
        
        String destination = request.getParameter("destination");
        Date departDate = Date.valueOf(request.getParameter("departDate"));
        
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String availableDay = sdf.format(departDate);
        
        TicketBean tb = new TicketBean();
        
        tb.setDestination(destination);
        tb.setDepartDate(departDate);
        tb.setAvailableDay(availableDay);
        
        List availableFlightsList = tb.getAvailableFlights(destination, departDate, availableDay);
        
        //out.println(availableFlightsList.size());
        
//        if(availableFlightsList != null && !availableFlightsList.isEmpty()) {
//            request.setAttribute("listOfAvailableFlights", availableFlightsList);
//            RequestDispatcher rd = request.getRequestDispatcher("availableFlights.jsp");
//            response.setContentType("text/html; charset='UTF-8'");
//            rd.forward(request, response);
//        }
//        
//        if(availableFlightsList == null || availableFlightsList.isEmpty()) {
//            out.println("flights are not available");
//            RequestDispatcher rd = request.getRequestDispatcher("searchForAFlight.jsp");
//            response.setContentType("text/html; charset='UTF-8'");
//            rd.include(request, response); 
//        } 
//        
        if(!availableFlightsList.contains("Flights are available")) {
            out.println("flights are not available");
            out.println("Go back home to keep searching (link this back to home.html)");
        }
        
        if(availableFlightsList.contains("Flights are available")) {
            request.setAttribute("listOfAvailableFlights", availableFlightsList);
            RequestDispatcher rd = request.getRequestDispatcher("availableFlights.jsp");
            response.setContentType("text/html; charset='UTF-8'");
            rd.forward(request, response);
        }
        
        
//        else {
//            request.setAttribute("listOfAvailableFlights", availableFlightsList);
//            RequestDispatcher rd = request.getRequestDispatcher("availableFlights.jsp");
//            response.setContentType("text/html; charset='UTF-8'");
//            rd.forward(request, response);
//        }
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.kkk211
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
