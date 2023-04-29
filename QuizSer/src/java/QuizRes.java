/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;

public class QuizRes extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String qname,value[];  //qname is radio button name and value is ans selected
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        int count=0;
        String ans="";
        //The enumeration interface defines the method by which you can enumerate
        //(obtain one at a time) the elements in a collection of objects.
        Enumeration paramNames=request.getParameterNames();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            st=con.createStatement();
            rs=st.executeQuery("select ans from quiz");
            //next() moves the cursor to the next row
            //this method return false if there are no more rows in the result set
            while(rs.next()&& paramNames.hasMoreElements())
            {
                String un=rs.getString(1);
                qname=(String)paramNames.nextElement();
                value=request.getParameterValues(qname); //reutrm type of getParameterValues is string array
                for(int i=0;i<value.length;i++)
                {
                    ans=value[i];
                }
                if(un.equals(ans))
                {
                    count++;
                }
            }
            out.println("<h1>You have scored "+count+" marks out of 5.</h1>");
        }
        catch(Exception e)
        {
            out.println("Sorry! try again!"+e);
        }
       
       /* int count=0;
        String q1="",q2="",q3="";
        q1=request.getParameter("java");
        q2=request.getParameter("ext");
        q3=request.getParameter("feat");
        if(q1.equals("r2"))
        {
            out.println("Your answer is correct!<br/>");
            count++;
        }
        else
        {
            out.println("Correct answer is "+(request.getParameter("r2"))+"<br/>");
        }
        if(q2.equals("r8"))
        {
            out.println("Your answer is correct!<br/>");
            count++;
        }
        else
        {
            out.println("Correct answer is "+(request.getParameter("r8"))+"<br/>");
        }
        if(q3.equals("r10"))
        {
            out.println("Your answer is correct!<br/>");
            count++;
        }
        else
        {
            out.println("Correct answer is "+(request.getParameter("r10"))+"<br/>");
        }
        if(count==3)
        {
            out.println("<h1>Congratulation!!! All answers are correct.</h1>");
        }
        else
        {
            out.println("<h1>you scored "+count+" points.</h1>");
        }*/
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

   
}
