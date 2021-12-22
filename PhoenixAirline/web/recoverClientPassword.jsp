<%-- 
    Document   : recoverClientPassword
    Created on : Jul 10, 2021, 11:58:14 AM
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
        
        <form action="./recoverClientPassword" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Enter your email</td>
                        <td><input type="email" name="clientEmail" value="" /></td>
                    </tr>
                    <tr>
                        <td><h3>Select the security question and Answer you gave when joining us</h3></td>
                    </tr>
                    <tr>
                        <td>Security Question</td>
                        <td>
                            <select name="clientSecurityQuestion">
                                <option>What is the name of your first pet?</option>
                                <option>What was your childhood nickname?</option>
                                <option>What is your maternal grandmother's maiden name?</option>
                                <option>In which city/town was your first job?</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Answer</td>
                        <td><input type="text" name="clientAnswer" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Change my password" /></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>

        </form>
        
    </body>
</html>
