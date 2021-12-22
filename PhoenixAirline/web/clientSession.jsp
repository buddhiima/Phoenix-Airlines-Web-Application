<%-- 
    Document   : clientSession
    Created on : Jun 22, 2021, 4:02:07 PM
    Author     : Buddhima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        
        <%
            HttpSession session1 = request.getSession(false);
            
            if(session1.getAttribute("clientEmail") != null) {
                String clientEmail = (String)session1.getAttribute("clientEmail");
                request.setAttribute("clientEmail", clientEmail);
            }
            else {
                response.sendRedirect("loginClient.jsp");
            }
        %>
        
    </body>
</html>
