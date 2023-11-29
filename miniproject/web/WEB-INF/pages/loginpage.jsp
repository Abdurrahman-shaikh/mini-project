<%-- 
    Document   : loginpage
    Created on : 09-Oct-2023, 10:45:01 AM
    Author     : rayyan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="fc/?type=model&page=LoginModel" method="Post">
        <input type="text" name="email" placeholder="email"/><br>
        <input type="password" name="password" placeholder="password"/><br>
        <input type="submit" value="login"/><a href="http://localhost:8080/miniproject/index.jsp">register</a>
        </form>
    </body>
</html>
