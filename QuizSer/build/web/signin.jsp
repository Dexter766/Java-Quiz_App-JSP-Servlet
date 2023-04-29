<%-- 
    Document   : signin
    Created on : 28 Apr, 2023, 10:45:01 AM
    Author     : LENOVO
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name=request.getParameter("name");
            String pass=request.getParameter("pass");
            //String email=request.getParameter("email");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1","root","");    
            PreparedStatement ps=con.prepareStatement("insert into login(uname,pass) values(?,?)");            
            ps.setString(1,name);
            ps.setString(2,pass);
            //ps.setString(3,email);
            int i=ps.executeUpdate();
              
            if(i>0)
            {
                response.sendRedirect("index.html");
            }
            else
            {
                out.println("Try Again");
            }
        %>
    </body>
</html>
