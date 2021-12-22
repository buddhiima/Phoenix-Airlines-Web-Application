/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TicketBean;
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
@WebServlet(name = "viewTicket", urlPatterns = {"/viewTicket"})
public class viewTicket extends HttpServlet {

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
        
        String ticketNo = request.getParameter("ticketNo");
        
        try {
            TicketBean tb = new TicketBean();

            tb.setTicketNo(ticketNo);

            List ticketList = tb.viewTicket(ticketNo);
            
            request.setAttribute("listOfTicket", ticketList);
            RequestDispatcher rd = request.getRequestDispatcher("viewTicket.jsp");
            rd.forward(request, response);
            
        }catch(BaseException e) {
            out.println(e.getMessage());
//            RequestDispatcher rd = request.getRequestDispatcher("viewTicketError.jsp");
//            rd.include(request, response);
        }

//            request.setAttribute("listOfTicket", ticketList);
//            RequestDispatcher rd = request.getRequestDispatcher("viewTicket.jsp");
//            rd.forward(request, response);
        

//        String ticketNo = request.getParameter("ticketNo");
//        
//        TicketBean tb = new TicketBean();
//        
//        tb.setTicketNo(ticketNo);
//        
//        String ticketSearchAvailability = tb.getTicketSearchAvailability(ticketNo);
//        
////        if(ticketSearchAvailability) {
////            List ticketList = tb.viewTicket(ticketNo);
////            request.setAttribute("listOfTicket", ticketList);
////            RequestDispatcher rd = request.getRequestDispatcher("viewTicket.jsp");
////            rd.forward(request, response);
////        }
////        
////        else {
////            out.print("No ticket");
////        }
//        out.print(ticketSearchAvailability);
        
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
