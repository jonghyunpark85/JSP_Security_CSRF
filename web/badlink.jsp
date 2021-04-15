<%-- 
    Document   : badlink
    Created on : Feb 23, 2021, 8:42:28 AM
    Author     : root
--%>
<%@page session="false"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRSF-Bad Link</title>
    </head>
    <body>
        <h1>CSRF - BAD LINK</h1>
        
        Hi User, please click on this innocent link: <a href="http://localhost:8080/crsf/Withdraw?amount=100">Covid-19 New Vaccine</a>
        
    </body>
</html>
