<%-- 
    Document   : updateFlight
    Created on : Jun 18, 2021, 12:31:11 PM
    Author     : Buddhima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="staffSession.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Flight</title>
    </head>
    <body>
        
        <form action="./logoutStaff">
            <input type="submit" value="Logout" />
        </form>
        
        <h1>Update details of Flight <%=request.getParameter("flightID")%></h1>
        
        <form action="./updateFlight" method="POST">
            
            <table border="0">
                <tbody>
                    <tr>
                        <td><input type="hidden" name="flightID" value="<%=request.getParameter("flightID")%>" /></td>
                    </tr>
                    <tr>
                        <td>Destination</td>
                        <td><input type="text" name="destination" value="" /></td>
                    </tr>
                    <tr>
                        <td>Available Day</td>
                        <td><select name="availableDay">
                                <option>Sunday</option>
                                <option>Monday</option>
                                <option>Tuesday</option>
                                <option>Wednesday</option>
                                <option>Thursday</option>
                                <option>Friday</option>
                                <option>Saturday</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Time of Departure</td>
                        <td><input type="time" name="departTime" value="" /></td>
                    </tr>
                    <tr>
                        <td>Number of Seats</td>
                        <td><input type="number" name="noOfSeats" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Update" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </tbody>
            </table>
            
        </form>
        
    </body>
</html>
