<%-- 
    Document   : loginClient
    Created on : Jun 22, 2021, 3:01:03 PM
    Author     : Buddhima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        
        <form action="./loginClient" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td><input type="email" name="clientEmail" value="" placeholder="Email" /></td>
                    </tr>
                    <tr>
                        <td><input type="password" name="clientPassword" value="" placeholder="Password" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login " /></td>
                    </tr>
                    <tr>
                        <td><a href="recoverClientPassword.jsp">Forgot Password?</a></td>
                    </tr>
                    <tr>
                        <td>Don't have an account? <a href="registerClient.jsp">Sign up now</a></td>
                    </tr>
                </tbody>
            </table>
        </form>
        
    </body>
</html>
