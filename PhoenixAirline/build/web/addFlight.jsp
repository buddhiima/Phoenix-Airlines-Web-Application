<%-- 
    Document   : addFlight
    Created on : Jun 14, 2021, 7:29:52 PM
    Author     : Buddhima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="staffSession.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a flight</title>
    </head>
    <body>
        
        <form action="./logoutStaff">
            <input type="submit" value="Logout" />
        </form>
        
        <h1>Add a flight</h1>
        
        <form action="./addFlight" method="POST">
            
            <table border="0">
                <tbody>
                    <tr>
                        <td>Flight ID</td>
                        <td><input type="text" name="flightID" value="" /></td>
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
                        <td><input type="submit" value="Add Flight" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </tbody>
            </table>

            
        </form>
        
    </body>
</html>
