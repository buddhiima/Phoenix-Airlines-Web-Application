<%-- 
    Document   : updateClient
    Created on : Jun 22, 2021, 4:35:02 PM
    Author     : Buddhima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change your profile</title>
    </head>
    <body>
        
        <%
            String clientEmail = (String) request.getParameter("clientEmail");
            String updateField = (String) request.getParameter("updateField");
            
            out.println(clientEmail+updateField);
        %>
        
        <%   
        if(updateField.equals("clientName")) { %>
            <form action="./updateClient" method="POST" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td><input type="hidden" name="clientEmail" value="<%=clientEmail%>"></td>
                        <td><input type="hidden" name="updateField" value="<%=updateField%>"></td>
                    </tr>
                    <tr>
                        <td>Full Name (as per passport)</td>
                        <td><input type="text" name="clientName" value="" /></td>
                    <tr>
                        <td><input type="submit" value="Save Changes" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </table>
            </form>
        <% } %>
        
        <%   
        if(updateField.equals("clientGender")) { %>
            <form action="./updateClient" method="POST" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td><input type="hidden" name="clientEmail" value="<%=clientEmail%>"></td>
                        <td><input type="hidden" name="updateField" value="<%=updateField%>"></td>
                    </tr>
                    <tr>
                        <td>Choose your Gender</td>
                        <td>
                            <input type="radio" name="clientGender" value="Male" /> Male
                            <input type="radio" name="clientGender" value="Female" /> Female
                        </td>
                    <tr>
                        <td><input type="submit" value="Save Changes" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </table>
            </form>
        <% } %>
        
        <%   
        if(updateField.equals("clientTel")) { %>
            <form action="./updateClient" method="POST" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td><input type="hidden" name="clientEmail" value="<%=clientEmail%>"></td>
                        <td><input type="hidden" name="updateField" value="<%=updateField%>"></td>
                    </tr>
                    <tr>
                        <td>New contact number</td>
                        <td><input type="text" name="clientTel" value="" /></td>
                    <tr>
                        <td><input type="submit" value="Save Changes" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </table>
            </form>
        <% } %>
        
        <%   
        if(updateField.equals("clientAddress")) { %>
            <form action="./updateClient" method="POST" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td><input type="hidden" name="clientEmail" value="<%=clientEmail%>"></td>
                        <td><input type="hidden" name="updateField" value="<%=updateField%>"></td>
                    </tr>
                    <tr>
                        <td>New address</td>
                    </tr>
                    <tr>
                        <td>House No</td>
                        <td><input type="text" name="clientHouseNo" value="" /></td>
                    </tr>
                    <tr>
                        <td>Street Name</td>
                        <td><input type="text" name="clientStreetName" value="" /></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td><input type="text" name="clientCity" value="" /></td>
                    </tr>
                    <tr>
                        <td>Province</td>
                        <td>
                            <select name="clientProvince">
                                <option>Western</option>
                                <option>North Western</option>
                                <option>Central</option>
                                <option>Eastern</option>
                                <option>Southern</option>
                                <option>Northern</option>
                                <option>North Central</option>
                            </select>
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
        if(updateField.equals("profilePhoto")) { %>
            <form action="./updateClient" method="POST" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td><input type="hidden" name="clientEmail" value="<%=clientEmail%>"></td>
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
        
        <%   
        if(updateField.equals("clientPassword")) { %>
            <form action="./updateClient" method="POST" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td><input type="hidden" name="clientEmail" value="<%=clientEmail%>"></td>
                        <td><input type="hidden" name="updateField" value="<%=updateField%>"></td>
                    </tr>
                    <tr>
                        <td>New password</td>
                        <td><input type="password" name="clientPassword" value="" /></td>
                    </tr>
                    <tr>
                        <td>Retype password</td>
                        <td><input type="password" name="retypeClientPassword" value="" /></td>
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
