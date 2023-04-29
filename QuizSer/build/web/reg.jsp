<%-- 
    Document   : reg
    Created on : 28 Apr, 2023, 10:43:54 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <form action="signin.jsp" method="post">
            <div class="container">
                <h1>Sign in</h1>
                <label for="uname"><b>Username</b></label>
                <input type="text" name="name"> <br>
                <label for="psw"><b>Password</b></label>
                <input type="password" name="pass"> <br>
                <!--Enter E-mail : <input type="email" name="email"> <br>-->
                <div class="clearfix">
                    <button type="submit" class="btn">Register</button>
                </div>
            </div>
        </form>
    </body>
</html>
