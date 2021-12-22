<%-- 
    Document   : registerClient
    Created on : Jun 21, 2021, 6:37:13 PM
    Author     : Buddhima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Join Us</title>
    </head>
    <body>
        
        <form action="./registerClient" method="POST" enctype="multipart/form-data">
            
            <table border="0">
                <tbody>
                    <tr>
                        <td>Full Name (as per passport)</td>
                        <td><input type="text" name="clientName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Date Of Birth</td>
                        <td><input type="date" name="clientDOB" value="" /></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td>
                            <input type="radio" name="clientGender" value="Male" /> Male
                            <input type="radio" name="clientGender" value="Female" /> Female
                        </td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="clientEmail" value="" /></td>
                    </tr>
                    <tr>
                        <td>Contact</td>
                        <td><input type="text" name="clientTel" value="" /></td>
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
                        <td>New Password</td>
                        <td><input type="password" name="clientPassword" value="" /></td>
                    </tr>
                    <tr>
                        <td>Retype Password</td>
                        <td><input type="password" name="RetypeClientPassword" value="" /></td>
                    </tr>
                    <tr>
                        <td>Profile Photo</td>
                        <td><input type="file" name="profilePhoto" accept="image/png,image/jpeg" /></td>
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
                        <td>
                            <input type="checkbox" name="agreeToTerms" value="ON" />
                            I agree to the <a href="">Terms of Service and Privacy Policy</a>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Sign Up" /></td>
                        <td><input type="reset" value="Cancel" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        
    </body>
</html>
