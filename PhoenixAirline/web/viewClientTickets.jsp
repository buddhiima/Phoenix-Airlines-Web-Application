<%-- 
    Document   : viewClientTickets
    Created on : Jul 16, 2021, 4:07:40 PM
    Author     : Buddhima
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My flights</title>
    </head>
    <body>
        
        <%
            List clientTicketsList = (List) request.getAttribute("listOfClientTickets");
            Iterator it = clientTicketsList.iterator();
        %>
        
        <%
            if(clientTicketsList.isEmpty()) { %>
             <p>You do not have any flights coming up. Click <a href="home.html">here</a> to find your flight now!</p>
            <%}
            
            else { %>
                <table border="0">

                <% while(it.hasNext()) { %>
                    <tr>
                        <td><%=it.next()%></td>
                        <td><%=it.next()%></td>
                        <td><%=it.next()%></td>
                        <td><%=it.next()%></td>
                        <td><%=it.next()%></td>
                        <td><%=it.next()%></td>
                    </tr>
                <% } %>
                
                </table>
                
            <% } %>
        
    </body>
</html>
