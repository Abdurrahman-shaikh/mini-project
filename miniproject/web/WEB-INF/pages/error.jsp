<%-- 
    Document   : error
    Created on : Nov 24, 2023, 10:38:56 PM
    Author     : azmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        String errorType = (String) request.getAttribute("errorType");

        if ("notFound".equals(errorType)) {
        %>
        <h2>Email does not exist</h2>
        <%
            } else if ("incorrectPassword".equals(errorType)) {
        %>
        <h2>Incorrect Password</h2>
        <%
            } else if ("emailNotVerified".equals(errorType)) {
        %>
        <h2>Email Not Verified</h2>
        <p>Please verify your email first.</p>
        <%
            } else {
        %>
        <h2>Unknown Error</h2>
        <p>An unknown error occurred.</p>
        <%
            }
        %>
    </body>
</html>
