<%-- 
    Document   : clientDashboard
    Created on : Jun 22, 2021, 3:58:55 PM
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
        <title>Dashboard</title>
    </head>
    <body>
        
        <%
            List clientData = (List) request.getAttribute("listOfClientData");
            Iterator it = clientData.iterator();
            
            while(it.hasNext()) {
        %>
        
        <form action="./logoutClient">
            <input type="submit" value="Logout" />
        </form>
        
        <a href="home.html">Home</a>
        
        <img src="./Images/Profile Photos/Client/<%=it.next()%>">
        
        <form action="updateClient.jsp" method="POST">
            <input type="hidden" name="updateField" value="profilePhoto">
            <input type="submit" value="Change photo">
            <input type="hidden" name="clientEmail" value="<%=request.getAttribute("clientEmail")%>">
        </form>
        
        <h3>My info</h3>
        
        <form action="./deleteClient">
            <input type="hidden" name="clientEmail" value="<%=clientData.get(2)%>">
            <input type="submit" value="Delete Account">
        </form>
            
        <table border="0">
            <tbody>
                <tr>
                    <td>
                        <form action="updateClient.jsp" method="POST">
                            <input type="hidden" name="updateField" value="clientPassword">
                            <input type="submit" value="Change Password">
                            <input type="hidden" name="clientEmail" value="<%=request.getAttribute("clientEmail")%>">
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Full Name</td>
                    <td><%=it.next()%></td>
                    <td>
                        <form action="updateClient.jsp" method="POST">
                            <input type="hidden" name="updateField" value="clientName">
                            <input type="submit" value="Change">
                            <input type="hidden" name="clientEmail" value="<%=request.getAttribute("clientEmail")%>">
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><%=it.next()%></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td><%=it.next()%></td>
                    <td>
                        <form action="updateClient.jsp" method="POST">
                            <input type="hidden" name="updateField" value="clientGender">
                            <input type="submit" value="Change">
                            <input type="hidden" name="clientEmail" value="<%=request.getAttribute("clientEmail")%>">
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Contact</td>
                    <td><%=it.next()%></td>
                    <td>
                        <form action="updateClient.jsp" method="POST">
                            <input type="hidden" name="updateField" value="clientTel">
                            <input type="submit" value="Change">
                            <input type="hidden" name="clientEmail" value="<%=request.getAttribute("clientEmail")%>">
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Date Of Birth</td>
                    <td><%=it.next()%></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>
                        <%=it.next()%> <br> 
                        <%=it.next()%> <br>
                        <%=it.next()%> <br>
                        <%=it.next()%> <br>
                    </td>
                    <td>
                        <form action="updateClient.jsp" method="POST">
                            <input type="hidden" name="updateField" value="clientAddress">
                            <input type="submit" value="Change">
                            <input type="hidden" name="clientEmail" value="<%=request.getAttribute("clientEmail")%>">
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Joined On</td>
                    <td><%=it.next()%></td>
                </tr>
            </tbody>
        </table>
                
        <form action="./viewClientTickets" method="POST">
            <input type="hidden" name="clientEmail" value="<%=request.getAttribute("clientEmail")%>">
            <input type="submit" name="viewClientTickets" value="My tickets">
        </form>

   <% } %>
        
    </body>
                    
</html>
