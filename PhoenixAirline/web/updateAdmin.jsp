<%-- 
    Document   : updateAdmin
    Created on : Jun 20, 2021, 1:02:06 PM
    Author     : Buddhima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit your profile</title>
    </head>
    <body>
        
        <form action="./logoutAdmin">
            <input type="submit" value="Logout" />
        </form>
        
        <%
            String adminEmail = (String) request.getParameter("adminEmail");
            String updateField = (String) request.getParameter("updateField");
        %>
        
        <%   
        if(updateField.equals("adminPassword")) { %>
            <form action="./updateAdmin" method="POST" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td><input type="hidden" name="adminEmail" value="<%=adminEmail%>"></td>
                        <td><input type="hidden" name="updateField" value="<%=updateField%>"></td>
                    </tr>
                    <tr>
                        <td>New password</td>
                        <td><input type="password" name="adminPassword" value="" /></td>
                    </tr>
                    <tr>
                        <td>Retype password</td>
                        <td><input type="password" name="retypeAdminPassword" value="" /></td>
                    </tr>
                        <td><input type="submit" value="Save Changes" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </table>
            </form>
        <% } %>
        
        <%   
        if(updateField.equals("adminGender")) { %>
            <form action="./updateAdmin" method="POST" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td><input type="hidden" name="adminEmail" value="<%=adminEmail%>"></td>
                        <td><input type="hidden" name="updateField" value="<%=updateField%>"></td>
                    </tr>
                    <tr>
                        <td>Choose your Gender</td>
                        <td>
                            <input type="radio" name="adminGender" value="Male" /> Male
                            <input type="radio" name="adminGender" value="Female" /> Female
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Save Changes" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </table>
            </form>
        <% } %>
        
        <%   
        if(updateField.equals("adminName")) { %>
            <form action="./updateAdmin" method="POST" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td><input type="hidden" name="adminEmail" value="<%=adminEmail%>"></td>
                        <td><input type="hidden" name="updateField" value="<%=updateField%>"></td>
                    </tr>
                    <tr>
                        <td>Full name</td>
                        <td><input type="text" name="adminName" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Save Changes" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </table>
            </form>
        <% } %>
        
        <%   
        if(updateField.equals("adminTel")) { %>
            <form action="./updateAdmin" method="POST" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td><input type="hidden" name="adminEmail" value="<%=adminEmail%>"></td>
                        <td><input type="hidden" name="updateField" value="<%=updateField%>"></td>
                    </tr>
                    <tr>
                        <td>New contact number</td>
                        <td><input type="text" name="adminTel" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Save Changes" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </table>
            </form>
        <% } %>
        
        <%   
        if(updateField.equals("profilePhoto")) { %>
            <form action="./updateAdmin" method="POST" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td><input type="hidden" name="adminEmail" value="<%=adminEmail%>"></td>
                        <td><input type="hidden" name="updateField" value="<%=updateField%>"></td>
                    </tr>
                    <tr>
                        <td>New profile photo</td>
                        <td><input type="file" name="profilePhoto" accept="image/png,image/jpeg" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Save Changes" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </table>
            </form>
        <% } %>
        
    </body>
</html>
