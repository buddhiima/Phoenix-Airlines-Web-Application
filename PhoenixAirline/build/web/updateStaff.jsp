<%-- 
    Document   : updateStaff
    Created on : Jun 21, 2021, 4:45:24 PM
    Author     : Buddhima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="adminSession.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit staff profile</title>
    </head>
    <body>
        
        <form action="./logoutAdmin">
            <input type="submit" value="Logout" />
        </form>
        
        <%
            String staffEmail = (String) request.getParameter("staffEmail");
            String updateField = (String) request.getParameter("updateField");
        %>
        
        <h3>Update details of <%=staffEmail%></h3>
        
        <%
        if(updateField.equals("role")) { %>
            <form action="./updateStaff" method="POST" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td><input type="hidden" name="staffEmail" value="<%=staffEmail%>"></td>
                        <td><input type="hidden" name="updateField" value="<%=updateField%>"></td>
                    </tr>
                    <tr>
                        <td>New Role</td>
                        <td><select name="role">
                                <option>Grade 1 Staff</option>
                                <option>Grade 2 Staff</option>
                            </select></td>
                    </tr>

                        <td><input type="submit" value="Save Changes" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </table>
            </form>
        <% } %>
        
        <%
        if(updateField.equals("staffName")) { %>
            <form action="./updateStaff" method="POST" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td><input type="hidden" name="staffEmail" value="<%=staffEmail%>"></td>
                        <td><input type="hidden" name="updateField" value="<%=updateField%>"></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="staffName" value="" /></td>
                    </tr>
                        <td><input type="submit" value="Save Changes" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </table>
            </form>
        <% } %>
        
        <%
        if(updateField.equals("staffGender")) { %>
            <form action="./updateStaff" method="POST" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td><input type="hidden" name="staffEmail" value="<%=staffEmail%>"></td>
                        <td><input type="hidden" name="updateField" value="<%=updateField%>"></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td>
                            <input type="radio" name="staffGender" value="Male" /> Male
                            <input type="radio" name="staffGender" value="Female" /> Female
                        </td>
                    </tr>
                        <td><input type="submit" value="Save Changes" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </table>
            </form>
        <% } %>
        
        <%
        if(updateField.equals("staffTel")) { %>
            <form action="./updateStaff" method="POST" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td><input type="hidden" name="staffEmail" value="<%=staffEmail%>"></td>
                        <td><input type="hidden" name="updateField" value="<%=updateField%>"></td>
                    </tr>
                    
                    <tr>
                        <td>New contact number</td>
                        <td><input type="text" name="staffTel" value="" /></td>
                    </tr> 
                        <td><input type="submit" value="Save Changes" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </table>
            </form>
        <% } %>
        
        <%
        if(updateField.equals("profilePhoto")) { %>
            <form action="./updateStaff" method="POST" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td><input type="hidden" name="staffEmail" value="<%=staffEmail%>"></td>
                        <td><input type="hidden" name="updateField" value="<%=updateField%>"></td>
                    </tr>
                    <tr>
                        <td>New Profile Photo</td>
                        <td><input type="file" name="profilePhoto" accept="image/png,image/jpeg" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Register" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </table>
            </form>
        <% } %>
       
    </body>
</html>
