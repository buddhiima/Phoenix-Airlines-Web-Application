<%-- 
    Document   : availableFlights
    Created on : Jun 25, 2021, 7:15:26 PM
    Author     : Buddhima
--%>

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
        %>
        
            <tr>
                    <td>Your destination <%=availableFlightsList.get(2)%></td>
            </tr>
            <tr>
                    <td>Date of Departure <%=availableFlightsList.get(3)%>, <%=availableFlightsList.get(4)%></td>
            </tr>
            <tr>
                <%
                    Iterator it = availableFlightsList.iterator(); 
                    while(it.hasNext()) {
                %>
                
                    <td>Flight <%=it.next()%></td>
                    <td>departs at <%=it.next()%></td>
                    
                    <td>
                        <form action="viewTicketDetails.jsp">
                                    <input type="hidden" name="destination" value="<%=it.next()%>" />
                                    <input type="hidden" name="availableDay" value="<%=it.next()%>" />
                                    <input type="hidden" name="departDate" value="<%=it.next()%>" />
                                    <input type="hidden" name="departTime" value="<%=it.next()%>" />
                                    <input type="hidden" name="flightID" value="<%=it.next()%>" />
                                    <input type="hidden" name="class" value="Business" />
                                    <input type="hidden" name="total" value="<%=it.next()%>" />
                            
                            <input type="submit" value="Book Business Class Rs. <%=it.next()%>">
                        </form>
                    </td>
                    <td>
                        <form action="viewTicketDetails.jsp">
                                    <input type="hidden" name="destination" value="<%=it.next()%>" />
                                    <input type="hidden" name="availableDay" value="<%=it.next()%>" />
                                    <input type="hidden" name="departDate" value="<%=it.next()%>" />
                                    <input type="hidden" name="departTime" value="<%=it.next()%>" />
                                    <input type="hidden" name="flightID" value="<%=it.next()%>" />
                                    <input type="hidden" name="class" value="Economy" />
                                    <input type="hidden" name="total" value="<%=it.next()%>" />
                            
                            <input type="submit" value="Book Economy Class Rs. <%=it.next()%>">
                        </form>
<!--                            <td><%=it.next()%></td>-->
            </tr>
                <%}%>
            
        </table>

    </body>
</html>


