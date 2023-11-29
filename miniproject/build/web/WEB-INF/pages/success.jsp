<%-- 
    Document   : success
    Created on : Nov 27, 2023, 2:27:17 PM
    Author     : azmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
        out.println(msg);
    }
%>

Success
