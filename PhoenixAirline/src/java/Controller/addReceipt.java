/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TicketBean;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Iterator;
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
@WebServlet(name = "addReceipt", urlPatterns = {"/addReceipt"})
public class addReceipt extends HttpServlet {

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
        
        String ticketNo = request.getParameter("ticketNo");
        String paymentMethod = request.getParameter("paymentMethod");
        String cashier = request.getParameter("cashier");
        
        Timestamp paymentTime = Timestamp.from(Instant.now());
        
        TicketBean tb = new TicketBean();
        
        tb.setTicketNo(ticketNo);
        tb.setPaymentMethod(paymentMethod);
        tb.setPaymentTime(paymentTime);
        tb.setCashier(cashier);
        
        if(tb.addTicketPayement(ticketNo, paymentMethod, paymentTime, cashier)) {
            
            //out.println("payment successful");
            
            List ticketList = tb.viewReceipt(ticketNo);
            
            //String ticketNo = (String) ticketList.get(0);
            String platform = (String) ticketList.get(1);
            //String ticketStatus = (String) ticketList.get(2);
            String clientEmail = (String) ticketList.get(3);
            String flightID = (String) ticketList.get(4);
            String destination = (String) ticketList.get(5);
            String availableDay = (String) ticketList.get(6);
            Time departTime = (Time) ticketList.get(7);
            Date departDate = (Date) ticketList.get(8);
            String flightClass = (String) ticketList.get(9);
            Timestamp ticketPlacedTime = (Timestamp) ticketList.get(10);
            Float total = (Float) ticketList.get(11);
            String receiptNo = (String) ticketList.get(12);
            //String paymentMethod = (String) ticketList.get(13);
            //String paymentTime = (String) ticketList.get(14);
            //String cashier = (String) ticketList.get(15);
            
            // generating the receipt
            
            try {
                
                Document document = new Document();
                
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                
                PdfWriter.getInstance(document, baos);
                
                document.open();
                
                document.add(new Phrase("Phoenix Airlines Payment Receipt."));
                
                document.add(new Paragraph((receiptNo+" "+cashier+" "+clientEmail+" "+ticketPlacedTime+" "+ticketNo+" "+platform+" "+flightID+" "+destination+" "+availableDay+" "+departTime+" "+departDate+" "+flightClass+" "+paymentMethod+" "+total+" "+paymentTime)));
                
                document.close();
                
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "inline;filename="+receiptNo+".pdf");
                response.setContentLength(baos.size());

                OutputStream os = response.getOutputStream();
                baos.writeTo(os); 
                os.flush();
                os.close();
                
            } catch (DocumentException ex) {
                Logger.getLogger(addReceipt.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else {
            //out.println("Payment details were not added.");  // cannot use printwriter twice. Use a jsp page for this.
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
