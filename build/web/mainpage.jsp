<%
    if (session.getAttribute("username")==null)
    {
        response.sendRedirect("index.jsp?message=Not logged in!");
    }
    
    String message="";
    
    if (request.getParameter("message")!=null)
    {
        message = request.getParameter("message");
    }
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSRF - Main Page</title>
    </head>
    <body>
        <h1>CSRF - Main Page</h1>
        
        Hello, <%= session.getAttribute("username") %><br/>
        <a href="Logout">Logout</a><br/><br/>

        Your current balance is $<%= session.getAttribute("balance") %><br/>

        <h3>Withdraw funds</h3>
        <form action="Withdraw" method="GET">
        Enter amount to withdraw: <input type="text" name="amount">
        <input type="hidden" name="nonce" value="<%=session.getAttribute("nonce")%>">
        <input type="submit" value="Withdraw">
        </form>

        <%= message %>
        
    </body>
</html>
