<%-- 
    Document   : viewClientContact
    Created on : Jul 7, 2021, 12:40:26 PM
    Author     : Buddhima
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="staffSession.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Passenger</title>
    </head>
    
    <body>
        
        <%
            String ticketNo = (String) request.getAttribute("ticketNo");
            
            List clientContactList = (List) request.getAttribute("ListOfClientContact");
            
            String clientName = (String) clientContactList.get(0);
            String clientEmail = (String) clientContactList.get(1);
            String clientTel = (String) clientContactList.get(2);
            String clientHouseNo = (String) clientContactList.get(3);
            String clientStreetName = (String) clientContactList.get(4);
            String clientCity = (String) clientContactList.get(5);
            String clientProvince = (String) clientContactList.get(6);
        %>
        
        <h3>Contact Passenger of Ticket No. <%=ticketNo%></h3>
        
        <table border="0">
            <tbody>
                <tr>
                    <td>Name</td>
                    <td><%=clientName%></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><%=clientEmail%></td>
                </tr>
                <tr>
                    <td>Telephone</td>
                    <td><%=clientTel%></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><%=clientHouseNo%>,</td>
                </tr>
                <tr>
                    <td></td>
                   <td><%=clientStreetName%>,</td> 
                </tr>
                <tr>
                    <td></td>
                    <td><%=clientCity%>,</td>
                </tr>
                <tr>
                    <td></td>
                    <td><%=clientProvince%> Province</td>
                </tr>
            </tbody>
        </table>
                
        <form action="./deleteTicket">
            <input type="hidden" name="ticketNo" value="<%=ticketNo%>">
            <input type="submit" value="Cancel Ticket">
        </form>
        
    </body>
    
</html>

                    
                    
                    