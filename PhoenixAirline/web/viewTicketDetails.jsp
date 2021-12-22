<%-- 
    Document   : viewTicketDetails
    Created on : Jun 27, 2021, 6:58:36 PM
    Author     : Buddhima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="clientSession.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Booking</title>
    </head>
    <body>
        
        <h3>You are about to book the following flight</h3>
        
        
            <%
                String destination = request.getParameter("destination");
                String availableDay = request.getParameter("availableDay");
                String departDate = request.getParameter("departDate");
                String departTime = request.getParameter("departTime");
                String flightID = request.getParameter("flightID");
                String flightClass = request.getParameter("class");
                float total = Float.parseFloat(request.getParameter("total"));
                String clientEmail = (String) request.getAttribute("clientEmail");
            %>

        
        <form action="./addTicket" method="POST">
        
            <table border="0">
                <tbody>
                    <tr>
                        <td>Your destination</td>
                        <td><%=destination%></td>
                        <td><input type="hidden" name="destination" value="<%=destination%>" /></td>
                    </tr>
                    <tr>
                        <td>Date of Departure</td>
                        <td><%=availableDay%>, <%=departDate%></td>
                        <td><input type="hidden" name="availableDay" value="<%=availableDay%>" /></td>
                        <td><input type="hidden" name="departDate" value="<%=departDate%>" /></td>
                    </tr>
                    <tr>
                        <td>Time of Departure</td>
                        <td><%=departTime%></td>
                        <td><input type="hidden" name="departTime" value="<%=departTime%>" /></td>
                    </tr>
                    <tr>
                        <td>Your flight</td>
                        <td><%=flightID%></td>
                        <td><input type="hidden" name="flightID" value="<%=flightID%>" /></td>
                    </tr>
                    <tr>
                        <td>Class</td>
                        <td><%=flightClass%></td>
                        <td><input type="hidden" name="class" value="<%=flightClass%>" /></td>
                    </tr>
                    <tr>
                        <td>Total</td>
                        <td>Rs. <%=total%></td>
                        <td><input type="hidden" name="total" value="<%=total%>" /></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="clientEmail" value="<%=clientEmail%>" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Confirm my booking" /></td>
                    </tr>
                </tbody>
            </table>
               
        </form>

                <p>Payment, Cancellation, refund, contact us page</p>
        
    </body>
</html>
