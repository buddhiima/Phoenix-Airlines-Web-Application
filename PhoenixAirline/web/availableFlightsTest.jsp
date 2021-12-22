<%-- 
    Document   : availableFlightsTest
    Created on : Jul 8, 2021, 12:08:38 PM
    Author     : Buddhima
--%>

<%@page import="java.sql.Date"%>
<%@page import="java.sql.Time"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="clientSession.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Available Flights</title>
    </head>
    <body>
        
        <table>
        
        <%
                List availableFlightsList = (List) request.getAttribute("listOfAvailableFlights");
                
                String flightID = (String) availableFlightsList.get(0);
                Time departTime = (Time) availableFlightsList.get(1);
                String destination = (String) availableFlightsList.get(2);
                String availableDay = (String) availableFlightsList.get(3);
                Date departDate = (Date) availableFlightsList.get(4);
                Float Business_pricePerTicket = (Float) availableFlightsList.get(5);
                Float Economy_pricePerTicket = (Float) availableFlightsList.get(6);
                
                Iterator it = availableFlightsList.iterator();
        %>
        
            <tr>
                    <td>Your destination <%=destination%></td>
            </tr>
            <tr>
                    <td>Date of Departure <%=availableDay%>, <%=departDate%></td>
            </tr>
            <tr>
                
                <%while(it.hasNext()) { %>
                    <td>Flight <%=flightID%></td>
                    <td>departs at <%=departTime%></td>
                    
                    <td>
                        <form action="viewTicketDetails.jsp">
                                    <input type="hidden" name="destination" value="<%=destination%>" />
                                    <input type="hidden" name="availableDay" value="<%=availableDay%>" />
                                    <input type="hidden" name="departDate" value="<%=departDate%>" />
                                    <input type="hidden" name="departTime" value="<%=departTime%>" />
                                    <input type="hidden" name="flightID" value="<%=flightID%>" />
                                    <input type="hidden" name="class" value="Business" />
                                    <input type="hidden" name="total" value="<%=Business_pricePerTicket%>" />
                            
                            <input type="submit" value="Book Business Class Rs. <%=Business_pricePerTicket%>">
                        </form>
                    </td>
                    <td>
                        <form action="viewTicketDetails.jsp">
                                    <input type="hidden" name="destination" value="<%=destination%>" />
                                    <input type="hidden" name="availableDay" value="<%=availableDay%>" />
                                    <input type="hidden" name="departDate" value="<%=departDate%>" />
                                    <input type="hidden" name="departTime" value="<%=departTime%>" />
                                    <input type="hidden" name="flightID" value="<%=flightID%>" />
                                    <input type="hidden" name="class" value="Economy" />
                                    <input type="hidden" name="total" value="<%=Economy_pricePerTicket%>" />
                            
                            <input type="submit" value="Book Economy Class Rs. <%=Economy_pricePerTicket%>">
                        </form>
                    </td>
                    <%}%>
            </tr>
                <%}%>
            
        </table>

    </body>
</html>
