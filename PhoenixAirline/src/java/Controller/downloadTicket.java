/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TicketBean;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Buddhima
 */
@WebServlet(name = "downloadTicket", urlPatterns = {"/downloadTicket"})
public class downloadTicket extends HttpServlet {

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
        
        //PrintWriter out = response.getWriter();
        
        String clientEmail = request.getParameter("clientEmail");
        Timestamp ticketPlacedTime = Timestamp.valueOf(request.getParameter("ticketPlacedTime"));
        
        TicketBean tb = new TicketBean();
        
        tb.setClientEmail(clientEmail);
        tb.setTicketPlacedTime(ticketPlacedTime);
        
        String clientName = tb.getClientName(clientEmail);
        String ticketNo = tb.getTicketNo(clientEmail, ticketPlacedTime);
        
        //out.println(clientEmail+" "+ticketPlacedTime+" "+clientName+" "+ticketNo);
        
        List ticketDetailsList = tb.getTicketDetails(ticketNo);
        
        String platform = (String) ticketDetailsList.get(0);
        String flightID = (String) ticketDetailsList.get(1);
        String destination = (String) ticketDetailsList.get(2);
        String availableDay = (String) ticketDetailsList.get(3);
        Time departTime = (Time) ticketDetailsList.get(4);
        Date departDate = (Date) ticketDetailsList.get(5);
        String flightClass = (String) ticketDetailsList.get(6);
        
        //out.println(platform+" "+flightID+" "+destination+" "+availableDay+" "+departTime+" "+departDate+" "+flightClass);
        
        try {
            Document document= new Document();
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            PdfWriter.getInstance(document, baos);

            document.open();
            
            // add ticket details
            document.add(new Paragraph(clientEmail+" "+ticketPlacedTime+" "+clientName+" "+ticketNo+" "+platform+" "+flightID+" "+destination+" "+availableDay+" "+departTime+" "+departDate+" "+flightClass));
            
            // add image
            String fileName = "C:\\Users\\Buddhima\\Downloads\\picf1.jpg";
            
            Image image = Image.getInstance(fileName);
            document.add(image);
            
            document.close();

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment;filename="+ticketNo+".pdf");
            response.setContentLength(baos.size());

            OutputStream os = response.getOutputStream();
            baos.writeTo(os); 
            os.flush();
            os.close();

        } catch (DocumentException ex) {
            Logger.getLogger(downloadTicket.class.getName()).log(Level.SEVERE, null, ex);
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
