<%-- 
    Document   : viewPendingRegistrations
    Created on : Jun 17, 2021, 4:50:00 PM
    Author     : Buddhima
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="adminSession.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pending Registrations</title>
    </head>
    <body>
        
        <form action="./logoutAdmin">
            <input type="submit" value="Logout" />
        </form>
        
        <h1>Pending Registrations</h1>
        
        <table border="0">
                <tr>
                    <th>Role</th>
                    <th>Joined On</th>
                    <th>Name</th>
                    <th>Email</th>
                </tr>
        
        <%
            List pendingRegistrations = (List) request.getAttribute("listOfPendingRegistrations");
            Iterator it = pendingRegistrations.iterator(); 
        
            while(it.hasNext()) { %>
                <tr>
                    <td><%=it.next()%></td>
                    <td><%=it.next()%></td>
                    <td><%=it.next()%></td>
                    <td><%=it.next()%></td>
                    <td>
                        
                        <form action="./approveStaff">
                            <input type="hidden" name="staffEmail" value="<%=it.next()%>">
                            <input type="submit" value="Approve">
                        </form>
                    </td>
                    <td>
                        <form action="./declineStaff">
                            <input type="hidden" name="staffEmail" value="<%=it.next()%>">
                            <input type="submit" value="Decline">
                        </form>
                    </td>
                </tr>
            <%} %>
        </table>
    </body>
</html>
