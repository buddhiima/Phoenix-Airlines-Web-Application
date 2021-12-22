<%-- 
    Document   : viewFlightsG1
    Created on : Jun 15, 2021, 1:17:13 PM
    Author     : Buddhima
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="staffSession.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flights</title>
    </head>
    <body>
        
        <%
            List flightList = (List) request.getAttribute("listOfFlights");
        %>
        
        <form action="./logoutStaff">
            <input type="submit" value="Logout" />
        </form>
        
        <table>
            
            <tr>
                <th>Flight ID</th>
                <th>Destination</th>
                <th>Available Day</th>
                <th>Time of Departure</th>
                <th>Number of Seats</th>
            </tr>
            
            <%
                Iterator it = flightList.iterator();
                while(it.hasNext()) { %>
                    <tr>
                        <td><%=it.next()%></td>
                        <td><%=it.next()%></td>
                        <td><%=it.next()%></td>
                        <td><%=it.next()%></td>
                        <td><%=it.next()%></td>
                        <td>
                            <form action="updateFlight.jsp">
                            <input type="hidden" name="flightID" value="<%=it.next()%>">
                            <input type="submit" value="Update">
                        </form>
                        </td>
                        <td>
                            <form action="./deleteFlight">
                            <input type="hidden" name="flightID" value="<%=it.next()%>">
                            <input type="submit" value="Remove">
                        </form>
                        </td>
                    </tr>
               <% }
            %>
            
        </table>
        
    </body>
</html>
