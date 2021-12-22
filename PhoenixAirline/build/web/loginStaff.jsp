<%-- 
    Document   : loginStaff
    Created on : Jun 17, 2021, 7:22:15 PM
    Author     : Buddhima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Login</title>
    </head>
    <body>
        
        <h3>Staff Login</h3>
        
        <form action="./loginStaff" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="staffEmail" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="staffPassword" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
        
        <p>Forgot password? You cannot change your password. Contact an admin personnel and ask for your password.</p>
        
    </body>
</html>
