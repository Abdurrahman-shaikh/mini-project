/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.sql.*;

public class Dao implements Serializable {

    private Dao() {}
    private static Dao md = null;

    public synchronized static Dao getInstance() {
        if (md == null) md = new Dao();
        return md;
    }

    public Statement getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniprojectdb?useSSL=false&allowPublicKeyRetrieval=true", "azmi", "Pass@#11221");
        return con.createStatement();
    }

    public boolean storeData(Statement st, String query) throws SQLException {
        return st.execute(query);
    }
}
