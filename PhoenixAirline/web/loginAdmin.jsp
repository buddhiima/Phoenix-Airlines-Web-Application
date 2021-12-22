<%-- 
    Document   : loginAdmin
    Created on : Jun 17, 2021, 12:15:56 PM
    Author     : Buddhima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
    </head>
    <body>
        
        <h3>Administrator Login</h3>
        
        <form action="./loginAdmin" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="adminEmail" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="adminPassword" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                    <tr>
                        <td><a href="recoverAdminPassword.jsp">Forgot Password?</a></td>
                    </tr>
                </tbody>
            </table>

        </form>
        
    </body>
</html>
