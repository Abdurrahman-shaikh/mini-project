<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.*" %>
<%@page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <title>User Registration</title>
        <script src="async.js"></script>
    </head>
    <body>
        <form action="fc/?type=model&page=RegistrationModel" method="post">
            <input type="text" name="fname" placeholder="First Name" required=""/><br>
            <input type="text" name="lname" placeholder="Last Name" required=""/><br>
            <input type="password" name="psw" placeholder="Password" required=""/><br>
            <input id = "em1" type="email" name="email" placeholder="Email" onblur="caller('em1','sid');" required="" /><span id ="sid"></span><br>
            <input id= "em2" type="text" name="mob" placeholder="Mobile Number" onblur="caller('em2','si');" required="" /><span id ="si"></span><br>
            <input type="date" name="dob" required=""><br>
            Gender:
            <input type="radio" name="gender" value="male" required="">Male
            <input type="radio" name="gender" value="female" required="">Female<br>
            <input type="submit" value="Submit"/><a href="http://localhost:8080/miniproject/fc/?type=view&page=loginpage">login</a>
            <input type="submit" value="Submit"/><a href="http://localhost:8080/miniproject/fc/?type=view&page=ajaxdemo">ajax</a>
        </form>
    </body>
</html>
