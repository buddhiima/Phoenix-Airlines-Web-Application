<%-- 
    Document   : home
    Created on : Jun 25, 2021, 11:59:11 AM
    Author     : Buddhima
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="clientSession.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    
    <body>
        <a href="loginClient.jsp">Login Client</a>
        <a href="registerClient.jsp">Join Us </a>
        <a href="loginStaff.jsp">Login Staff</a>
        
        <h1>welcome</h1>
       
        <h3>Find my flight</h3>
        
        <%@include file="searchForAFlight.jsp"%>
        
        <h1>footer</h1>
        
    </body>
</html>
