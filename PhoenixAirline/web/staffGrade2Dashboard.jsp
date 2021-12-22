<%-- 
    Document   : staffGrade2Dashboard
    Created on : Jun 17, 2021, 8:00:21 PM
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
        <title>Dashboard</title>
    </head>
    <body>
        
        <%
            List staffData = (List) request.getAttribute("listOfStaffData");
            Iterator it = staffData.iterator();
        %>
        
        <form action="./logoutStaff">
            <input type="submit" value="Logout" />
        </form>
        
        <img src="./Images/Profile Photos/Staff/<%=it.next()%>">
        
        <table border="0">
            <thead>
                <tr>
                    <th>Personal Info</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Name</td>
                    <td><%=it.next()%></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><%=it.next()%></td>
                </tr>
                <tr>
                    <td>Role</td>
                    <td><%=it.next()%></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td><%=it.next()%></td>
                </tr>
                <tr>
                    <td>Contact</td>
                    <td><%=it.next()%></td>
                </tr>
                <tr>
                    <td>Joined on</td>
                    <td><%=it.next()%></td>
                </tr>
            </tbody>
        </table>
                
        <table border="0">
            <thead>
                <tr>
                    <th>Flights</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <a href="addFlight.jsp">New Flight</a>
                    </td>
                    <td>
                         <form action="./viewFlights">
                            <input type="hidden" name="role" value="<%=staffData.get(3)%>">
                            <input type="submit" value="Show Flights">
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
                            
                            
        <table border="0">
            <thead>
                <tr>
                    <th>Tickets</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <a href="getTicketNo.jsp">Search for a Ticket</a>
                    </td>
                </tr>
            </tbody>
        </table>
        
    </body>
</html>
