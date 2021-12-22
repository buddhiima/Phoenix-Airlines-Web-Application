<%-- 
    Document   : searchForAFlight
    Created on : Jun 27, 2021, 1:15:14 PM
    Author     : Buddhima
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        
        <form action="./getAvailableFlights">
            <table border="0">
                <tbody>
                    <%
                        List flightDestinationsList = (List) request.getAttribute("listOfFlghtDestinations");
                        Iterator it = flightDestinationsList.iterator(); %>
                        <tr>
                            <td>Your destination</td>
                            <td><select name="destination">
                                    <%while(it.hasNext()) { %>
                                        <option>
                                            <%=it.next()%>
                                        </option>
                                    <% }  %>
                                </select></td>
                        </tr>
                     
                    <tr>
                        <td>Date of Departure</td>
                        <td><input type="date" name="departDate" id="dateOfDeparture"></td>
                    </tr>
                    
                    <tr>
                        <td><input type="submit" id="showAvailableFlights" value="Go"/></td>
                    </tr>
                </tbody>
            </table>

        </form>
        
    </body>
</html>
