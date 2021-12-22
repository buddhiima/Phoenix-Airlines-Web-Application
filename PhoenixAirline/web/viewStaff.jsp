<%-- 
    Document   : viewStaff
    Created on : Jun 20, 2021, 8:03:28 PM
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
        <title>Staff</title>
    </head>
    <body>
        
        <%
            List staffList = (List) request.getAttribute("listOfStaff");
        %>
        
        <form action="./logoutAdmin">
            <input type="submit" value="Logout" />
        </form>
        
        <form action="./filterStaff">
              
            <h3>Filter staff by</h3>
            <h6>Select only one option.</h6>

            <table border="0">
                <tr>
                    <td>Role</td>
                    <td>
                        <select name="role">
                            <option> </option>
                            <option>Grade 1 Staff</option>
                            <option>Grade 2 staff</option>
                        </select>
                    </td>
                    <td>Gender</td>
                    <td>
                        <select name="staffGender">
                            <option> </option>
                            <option>Male</option>
                            <option>Female</option>
                        </select>
                    </td>
                    <td>Joined Year</td>
                    <td>
                        <select name="staffJoinedDate">
                            <option> </option>
                            <option>2019</option>
                            <option>2020</option>
                            <option>2021</option>
                        </select>
                    </td>
                    <td><input type="submit" value="Filter" /></td>
                </tr>
            </table>
        
        </form> 
        
        
        <form action="./viewStaff">
            <table>
                <tr>
                    <td>
                        <input type="submit" value="Remove filters" />
                    </td>
                </tr>
            </table>
        </form>
 
        
        
        <table>
            
            <tr>
                <th>Profile Photo</th>
                <th>Role</th>
                <th>Joined On</th>
                <th>Name</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Contact</th>
                <th>IP Address</th>
                <th>Last Logged On</th>
            </tr>
            
            <%
                Iterator it = staffList.iterator();
                while(it.hasNext()) { %>
                    <tr>
                        <td>
                            <img src="Images/Profile Photos/Staff/<%=it.next()%>" width="100" height="100">
                            <form action="updateStaff.jsp" method="POST">
                                <input type="hidden" name="updateField" value="profilePhoto">
                                <input type="submit" value="Change profile photo">
                                <input type="hidden" name="staffEmail" value="<%=it.next()%>">
                            </form>
                        </td>
                        <td>
                            <%=it.next()%>
                            <form action="updateStaff.jsp" method="POST">
                                <input type="hidden" name="updateField" value="role">
                                <input type="submit" value="Change">
                                <input type="hidden" name="staffEmail" value="<%=it.next()%>">
                            </form>
                        </td>
                        <td><%=it.next()%></td>
                        <td>
                            <%=it.next()%>
                        <form action="updateStaff.jsp" method="POST">
                                <input type="hidden" name="updateField" value="staffName">
                                <input type="submit" value="Change">
                                <input type="hidden" name="staffEmail" value="<%=it.next()%>">
                            </form></td>
                        <td><%=it.next()%></td>
                        <td>
                            <%=it.next()%>
                            <form action="updateStaff.jsp" method="POST">
                                <input type="hidden" name="updateField" value="staffGender">
                                <input type="submit" value="Change">
                                <input type="hidden" name="staffEmail" value="<%=it.next()%>">
                            </form>
                        </td>
                        <td>
                            <%=it.next()%>
                            <form action="updateStaff.jsp" method="POST">
                                <input type="hidden" name="updateField" value="staffTel">
                                <input type="submit" value="Change">
                                <input type="hidden" name="staffEmail" value="<%=it.next()%>">
                            </form>
                        </td>
                        <td><%=it.next()%></td>
                        <td><%=it.next()%></td>
                        <td>
                            <form action="./deleteStaff">
                            <input type="hidden" name="staffEmail" value="<%=it.next()%>">
                            <input type="submit" value="Delete Account">
                        </form>
                        </td>
                    </tr>
               <% }
            %>
            
        </table>
        
    </body>
</html>
