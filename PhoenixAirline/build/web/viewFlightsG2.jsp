<%-- 
    Document   : viewFlightsG2
    Created on : Jun 18, 2021, 3:43:55 PM
    Author     : Buddhima
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
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
        
        <form action="./filterFlights">
              
            <h3>Filter flights by</h3>
            <h6>Choose only 1 condition</h6>

            <table border="0">
                <tr>
                    <td>Destination</td>
                    <td><input type="text" name="destination" value="" /></td>
                    <td>Available Day</td>
                    <td>
                        <select name="availableDay">
                            <option> </option>
                            <option>Sunday</option>
                            <option>Monday</option>
                            <option>Tuesday</option>
                            <option>Wednesday</option>
                            <option>Thursday</option>
                            <option>Friday</option>
                            <option>Saturday</option>
                        </select>
                    </td>
                    <td><input type="submit" value="Filter" /></td>
                </tr>
            </table>
        </form> 
        
        <form action="./viewFlights">
            <table>
                <tr>
                    <td>
                        <input type="submit" value="Remove filters" />
                        <input type="hidden" name="role" value="Grade 2 Staff">
                    </td>
                </tr>
            </table>
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
                            <form action="">
                            <input type="hidden" name="flightID" value="<%=it.next()%>">
                        </form>
                        </td>
                        <td>
                            <form action="">
                            <input type="hidden" name="flightID" value="<%=it.next()%>">
                        </form>
                        </td>
                    </tr>
                    
               <% }
            %>
            
        </table>
        
    </body>
</html>
