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
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalTime;
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
@WebServlet(name = "addTicket", urlPatterns = {"/addTicket"})
public class addTicket extends HttpServlet {

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
        
        String destination = request.getParameter("destination");
        String availableDay = request.getParameter("availableDay");
        Date departDate = Date.valueOf(request.getParameter("departDate"));
        Time departTime = Time.valueOf(request.getParameter("departTime"));
        String flightID = request.getParameter("flightID");
        String flightClass = request.getParameter("class");
        Float total = Float.parseFloat(request.getParameter("total"));
        String clientEmail = request.getParameter("clientEmail");
        
        Timestamp ticketPlacedTime = Timestamp.from(Instant.now());
        
        //out.println(destination+" "+availableDay+" "+departDate+" "+departTime+" "+flightID+" "+flightClass+" "+total+" "+clientEmail+" "+ticketPlacedTime);
        
        TicketBean tb = new TicketBean();
        
        tb.setDestination(destination);
        tb.setAvailableDay(availableDay);
        tb.setDepartDate(departDate);
        tb.setDepartTime(departTime);
        tb.setFlightID(flightID);
        tb.setFlightClass(flightClass);
        tb.setTotal(total);
        tb.setClientEmail(clientEmail);
        tb.setTicketPlacedTime(ticketPlacedTime);
        
        if(tb.addTicket(destination, availableDay, departDate, departTime, flightID, flightClass, total, clientEmail ,ticketPlacedTime)) {
            request.setAttribute("clientEmail", clientEmail);
            request.setAttribute("ticketPlacedTime", ticketPlacedTime);
            
            RequestDispatcher rd = request.getRequestDispatcher("downloadTicket.jsp");
            response.setContentType("text/html; charset='UTF-8'");
            rd.include(request, response);
        }
        
        else {
            out.println("ticket not added");
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
