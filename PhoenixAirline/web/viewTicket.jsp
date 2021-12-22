<%-- 
    Document   : viewTicket
    Created on : Jun 30, 2021, 4:38:27 PM
    Author     : Buddhima
--%>

<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Time"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="staffSession.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show ticket</title>
    </head>
    <body>
        
        <%
            List ticketList = (List) request.getAttribute("listOfTicket");

            String ticketNo = (String) ticketList.get(0);
            String platform = (String) ticketList.get(1);
            String ticketStatus = (String) ticketList.get(2);
            String clientEmail = (String) ticketList.get(3);
            String flightID = (String) ticketList.get(4);
            String destination = (String) ticketList.get(5);
            String availableDay = (String) ticketList.get(6);
            Time departTime = (Time) ticketList.get(7);
            Date departDate = (Date) ticketList.get(8);
            String flightClass = (String) ticketList.get(9);
            Timestamp ticketPlacedTime = (Timestamp) ticketList.get(10);
            Float total = (Float) ticketList.get(11);
            String refundStatus = (String) ticketList.get(12);
        %>
        
        <h4>Showing ticket <%=ticketNo%></h4>
        
        <%
            if(refundStatus.equals("Eligible to cancel. Payment not required") || refundStatus.equals("Not eligible for refund")) { %>
                <form action="./deleteTicket">
                    <input type="hidden" name="ticketNo" value="<%=ticketNo%>">
                    <input type="submit" value="Cancel Ticket">
                </form>
            <%}
        %>
        
        <%
            if(refundStatus.equals("Eligible for refund")) { %>
                <form action="./addRefund">
                    <input type="hidden" name="ticketNo" value="<%=ticketNo%>">
                    <input type="hidden" name="cashier" value="<%=request.getAttribute("staffEmail")%>">
                    <input type="submit" value="Refund and Cancel Ticket">
                 </form>
            <%}
        %>
        
        <table border="0">
            <tbody>
                <tr>
                    <td>Platform</td>
                    <td><%=platform%></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td><%=ticketStatus%></td>
                </tr>
                <tr>
                    <td>Refund Status</td>
                    <td><%=refundStatus%></td>
                </tr>
                <tr>
                    <td>Passenger Email</td>
                    <td><%=clientEmail%></td>
                </tr>
                <tr>
                    <td>Destination</td>
                    <td><%=destination%></td>
                </tr>
                <tr>
                    <td>Departure</td>
                    <td><%=availableDay%>, <%=departDate%> <%=departTime%></td>
                </tr>
                <tr>
                    <td>Flight</td>
                    <td><%=flightID%></td>
                </tr>
                <tr>
                    <td>Class</td>
                    <td><%=flightClass%></td>
                </tr>
                <tr>
                    <td>Total</td>
                    <td><%=total%></td>
                </tr>
                <tr>
                    <td>Ticket placed on</td>
                    <td><%=ticketPlacedTime%></td>
                </tr>
            </tbody>
        </table>
                
        <%
            if(refundStatus.equals("Not applicable for expired tickets")) { %>
                <form action="./getClientContact" method="POST">
                    <input type="hidden" name="ticketNo" value="<%=ticketNo%>">
                    <input type="submit" value="Contact Passenger">
                 </form>
        <%}
        %>
                
        
        <%
            if(ticketStatus.equals("Payment pending") || ticketStatus.equals("Expired without payment")) { %>
                <form action="./addReceipt" method="POST">
                    Payment Method <select name="paymentMethod">
                        <option>Cash</option>
                        <option>Visa card</option>
                        <option>Mastercard</option>
                        <option>American Express Card</option>
                    </select>
                    <input type="hidden" name="ticketNo" value="<%=ticketNo%>">
                    <input type="hidden" name="cashier" value="<%=request.getAttribute("staffEmail")%>">
                    <input type="submit" value="Confirm payment and Generate Receipt">
                 </form>
            <%}
        %>
        
    </body>
</html>
