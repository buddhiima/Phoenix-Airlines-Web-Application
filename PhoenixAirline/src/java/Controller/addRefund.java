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
@WebServlet(name = "addRefund", urlPatterns = {"/addRefund"})
public class addRefund extends HttpServlet {

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
        
        //PrintWriter out = response.getWriter();
        
        String ticketNo = request.getParameter("ticketNo");
        String cashier = request.getParameter("cashier");
        
        Timestamp refundedTime = Timestamp.from(Instant.now());
        
        TicketBean tb = new TicketBean();
        tb.setTicketNo(ticketNo);
        tb.setCashier(cashier);
        tb.setRefundedTime(refundedTime);
        
        if(tb.addRefund(ticketNo, refundedTime, cashier)) {
            
            List refundList = tb.viewRefund(ticketNo);
            
            tb.deleteTicket(ticketNo);                             // UN COMMENT THISSS
            
            //String ticketNo = (String) refundList.get(0);
            String platform = (String) refundList.get(1);
            //String ticketStatus = (String) refundList.get(2);
            String clientEmail = (String) refundList.get(3);
            String flightID = (String) refundList.get(4);
            String destination = (String) refundList.get(5);
            String availableDay = (String) refundList.get(6);
            Time departTime = (Time) refundList.get(7);
            Date departDate = (Date) refundList.get(8);
            String flightClass = (String) refundList.get(9);
            String ticketPlacedTime = refundList.get(10).toString();
            Float total = (Float) refundList.get(11);
            String receiptNo = (String) refundList.get(12);
            //Timestamp paymentTime = (Timestamp) refundList.get(13);
            String refundVoucherNo = (String) refundList.get(14);
            //Timestamp refundedTime = (Timestamp) refundList.get(15);
            
            
//            out.println(platform);
//            out.println(clientEmail);
//            out.println(flightID);
//            out.println(destination);
//            out.println(availableDay);
//            out.println(departTime);
//            out.println(departDate);
//            out.println(flightClass);
//            out.println(ticketPlacedTime);
//            out.println(total);
//            out.println(receiptNo);
//            out.println(refundVoucherNo);
//            out.println(ticketNo);
//            out.println(cashier);
//            out.println(refundedTime);
            
            // generating the receipt
            
            try {
                
                Document document = new Document();
                
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                
                PdfWriter.getInstance(document, baos);
                
                document.open();
                
                document.add(new Phrase("Phoenix Airlines Refund Payment Voucher."));
                
                document.add(new Paragraph((ticketPlacedTime+" "+cashier+" "+clientEmail+" "+ticketNo+" "+platform+" "+flightID+" "+destination+" "+availableDay+" "+departTime+" "+departDate+" "+flightClass+" "+receiptNo+" "+total+" "+refundVoucherNo+" "+refundedTime)));
                
                document.close();
                
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "inline;filename="+refundVoucherNo+".pdf");
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
