<%-- 
    Document   : adminSession
    Created on : Jun 20, 2021, 12:37:36 PM
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
            
            if(session1.getAttribute("adminEmail") != null) {
                String adminEmail = (String)session1.getAttribute("adminEmail");
                request.setAttribute("adminEmail", adminEmail);
            }
            else {
                response.sendRedirect("loginAdmin.jsp");
            }
        %>
        
    </body>
</html>
