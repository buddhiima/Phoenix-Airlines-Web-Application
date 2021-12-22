<%-- 
    Document   : staffSession
    Created on : Jun 21, 2021, 12:45:08 PM
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
            
            if(session1.getAttribute("staffEmail") != null) {
                String staffEmail = (String)session1.getAttribute("staffEmail");
                request.setAttribute("staffEmail", staffEmail);
            }
            else {
                response.sendRedirect("loginStaff.jsp");
            }
        %>
        
    </body>
</html>

