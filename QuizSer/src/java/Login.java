/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pwriter=res.getWriter();
        String u,p;
        String name=req.getParameter("uname");
        String password=req.getParameter("upass");
        try
        {   
              Class.forName("com.mysql.jdbc.Driver");
              Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1","root","");              
              Statement s=c.createStatement();            
              ResultSet r=s.executeQuery("select * from login where uname='"+name+"' and pass='"+password+"'");
              /*u=null;
              p=null;
              while(r.next())
              {
                  u=r.getString(2);
                  p=r.getString(3);  
              }*/
              //pwriter.println(u+p);
            //if(name.equals(u) && password.equals(p))
            if(r.next())
            {
                pwriter.println("Login Successful");
                res.sendRedirect(req.getContextPath()+"/quizIndex.html");
            }
            else
            {
                pwriter.println("Wrong Id and Password");
            }
            pwriter.close();
            r.close();
            s.close();
            c.close();
        } 
        catch (SQLException e) 
        {
             System.out.println("Error"+e);
        } 
        catch (ClassNotFoundException ex) 
        { 
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
}
