<%-- 
    Document   : adminDashboard
    Created on : Jun 17, 2021, 12:39:59 PM
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
        <title>Dashboard</title>
    </head>
    <body>
        
        <%
            List adminData = (List) request.getAttribute("listOfAdminData");
            Iterator it = adminData.iterator();
        %>
        
        <form action="./logoutAdmin">
            <input type="submit" value="Logout" />
        </form>
        
        <img src="./Images/Profile Photos/Admin/<%=it.next()%>">
        
        <form action="updateAdmin.jsp" method="POST">
            <input type="hidden" name="updateField" value="profilePhoto">
            <input type="submit" value="Change photo">
            <input type="hidden" name="adminEmail" value="<%=request.getAttribute("adminEmail")%>">
        </form>
        
        <h3>My info</h3>
        
        <form action="./deleteAdmin">
            <input type="hidden" name="adminEmail" value="<%=adminData.get(2)%>">
            <input type="submit" value="Delete Account">
        </form>
        
        <table border="0">
            <tbody>
                <tr>
                    <td>
                        <form action="updateAdmin.jsp" method="POST">
                            <input type="hidden" name="updateField" value="adminPassword">
                            <input type="submit" value="Change Password">
                            <input type="hidden" name="adminEmail" value="<%=request.getAttribute("adminEmail")%>">
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><%=it.next()%></td>
                    <td>
                        <form action="updateAdmin.jsp" method="POST">
                            <input type="hidden" name="updateField" value="adminName">
                            <input type="submit" value="Change">
                            <input type="hidden" name="adminEmail" value="<%=request.getAttribute("adminEmail")%>">
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
                        <form action="updateAdmin.jsp" method="POST">
                            <input type="hidden" name="updateField" value="adminGender">
                            <input type="submit" value="Change">
                            <input type="hidden" name="adminEmail" value="<%=request.getAttribute("adminEmail")%>">
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Contact</td>
                    <td><%=it.next()%></td>
                    <td>
                        <form action="updateAdmin.jsp" method="POST">
                            <input type="hidden" name="updateField" value="adminTel">
                            <input type="submit" value="Change">
                            <input type="hidden" name="adminEmail" value="<%=request.getAttribute("adminEmail")%>">
                        </form>
                    </td>
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
                    <th>Staff</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><a href="registerStaff.jsp">Add Staff</a></td>
                    <td><a href="./viewStaff">View Staff</a></td>
                    <td><a href="./viewPendingRegistrations">Pending Registrations</a></td>
                </tr>
            </tbody>
            
        </table>

        
    </body>
</html>
