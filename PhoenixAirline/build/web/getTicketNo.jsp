<%-- 
    Document   : getTicketNo
    Created on : Jun 30, 2021, 4:41:37 PM
    Author     : Buddhima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="staffSession.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
       
        <form action="./viewTicket">
            <input type="text" name="ticketNo" value="" placeholder="Ticket Number" />
            <input type="submit" value="Show Ticket" />
        </form>
        
    </body>
</html>
