/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rayyan
 */
public class EmailVerificationModel implements ModelInterface {

    @Override
    public void doBusiness(HttpServletRequest request, HttpServletResponse response, ServletContext ser) {
        var mail = request.getParameter("email");
        Dao md = Dao.getInstance();
        try (PrintWriter out = response.getWriter()) {
            Statement st = md.getConnection();
            String queryid = "UPDATE login_table SET status=1 WHERE email='" + mail + "'";
            md.storeData(st, queryid);
            out.println("<a href=\"http://localhost:8080/miniproject/fc/?type=view&page=loginpage\">login</a>");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(EmailVerificationModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmailVerificationModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
