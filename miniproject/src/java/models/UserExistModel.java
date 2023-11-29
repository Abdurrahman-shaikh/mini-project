/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

/**
 *
 * @author rayyan
 */
public class UserExistModel implements ModelInterface {

    @Override
    public void doBusiness(HttpServletRequest request, HttpServletResponse response, ServletContext context) {
        String email = request.getParameter("email");
        Dao md = Dao.getInstance();
        try (PrintWriter out = response.getWriter()) {

            String query = "SELECT uid FROM user_table WHERE (email='"+email+"' OR mobileno='"+email+"')";
            Statement st = md.getConnection();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                request.setAttribute("msg", "already exists");
            } else {
                request.setAttribute("msg", "proceed");
            }
            request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
