<%-- 
    Document   : recoverAdminPassword
    Created on : Jul 13, 2021, 10:56:03 AM
    Author     : Buddhima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot password</title>
    </head>
    <body>
        
        <h1>You can recover your password here.</h1>
        
        <form action="./recoverAdminPassword" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Your email</td>
                        <td><input type="email" name="adminEmail" value="" /></td>
                    </tr>
                    <tr>
                        <td>Telephone number</td>
                        <td><input type="text" name="adminTel" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Change my password" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
        
    </body>
</html>
