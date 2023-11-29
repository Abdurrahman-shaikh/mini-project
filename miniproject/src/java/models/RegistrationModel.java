/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
/**
 *
 * @author ashim
 */
public class RegistrationModel implements ModelInterface {
    @Override
    public void doBusiness(HttpServletRequest request, HttpServletResponse response, ServletContext serv){
        
        try{
            String mail = request.getParameter("email");
            Dao md = Dao.getInstance();
            MailSender ms = new MailSender();
            String queryId = "SELECT MAX(uid) FROM user_table";
            Statement st = md.getConnection();
            int uid = 0;
            int g = -1;
            if (request.getParameter("gender").equals("male")) g = 1;
            else g = 0;
            ResultSet rs= st.executeQuery(queryId);
            while (rs.next()) uid = rs.getInt(1);
            uid++;
            String query = "INSERT INTO user_table("
                    + "uid,firstname,lastname,dob,mobileno,gender,email)"
                    + "VALUES('"+uid+"','"+request.getParameter("fname")
                    + "','" +request.getParameter("lname")+"','"
                    + request.getParameter("dob")+"',"
                    + "'"+request.getParameter("mob")
                    + "','"+g+"','"+mail+"')";
            md.storeData(st, query);
            ms.sendMail(mail);
            request.getRequestDispatcher(
                    "/WEB-INF/pages/success.jsp")
                    .forward(request,response);
       
    }catch(ServletException | IOException | ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    
}