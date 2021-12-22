<%-- 
    Document   : registerStaff
    Created on : Jun 20, 2021, 12:49:48 PM
    Author     : Buddhima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="adminSession.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Staff Registration</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
       
        <h3>Employee Registration</h3>
        
        <form action="./registerStaff" method="POST" enctype="multipart/form-data">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Role</td>
                        <td><select name="role">
                                <option>Grade 1 Staff</option>
                                <option>Grade 2 Staff</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="staffName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="staffEmail" value="" /></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td>
                            <input type="radio" name="staffGender" value="Male" /> Male
                            <input type="radio" name="staffGender" value="Female" /> Female
                        </td>
                    </tr>
                    <tr>
                        <td>Telephone</td>
                        <td><input type="text" name="staffTel" value="" /></td>
                    </tr> 
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="staffPassword" value="" /></td>
                    </tr>
                    <tr>
                        <td>Retype Password</td>
                        <td><input type="password" name="retypeStaffPassword" value="" /></td>
                    </tr>
                    <tr>
                        <td>Profile Photo</td>
                        <td><input type="file" name="profilePhoto" accept="image/png,image/jpeg" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Register" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
        
    </body>
</html>

