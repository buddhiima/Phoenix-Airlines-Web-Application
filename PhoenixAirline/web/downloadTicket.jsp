<%-- 
    Document   : downloadTicket
    Created on : Jun 28, 2021, 4:16:09 PM
    Author     : Buddhima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="clientSession.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Download your ticket</title>
    </head>
    <body>
        
        <h1>Your ticket is ready!</h1>
        
        <h2>Thank you for flying with us.</h2>
        
        <p>You can download your ticket and take a print out. Please present it to the check point before boarding.</p>
        
        <form action="./downloadTicket" method="POST">
            <input type="hidden" name="clientEmail" value="<%=request.getAttribute("clientEmail")%>">
            <input type="hidden" name="ticketPlacedTime" value="<%=request.getAttribute("ticketPlacedTime")%>">
            
            <input type="submit" value="Download my ticket">
        </form>
        
    </body>
</html>
