package models;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

public class LoginModel implements ModelInterface {

    @Override
    public void doBusiness(HttpServletRequest request, HttpServletResponse response, ServletContext context) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Dao md = Dao.getInstance();

        try (PrintWriter out = response.getWriter()) {
            String query = "SELECT password, status FROM login_table WHERE email='" + email + "'";
            Statement st = md.getConnection();
            ResultSet rs = st.executeQuery(query);

            if (!rs.next()) {
                request.setAttribute("errorType", "notFound");
            } else {
                String storedPassword = rs.getString("password");
                int storedStatus = rs.getInt("status");

                if (!storedPassword.equals(password)) {
                    request.setAttribute("errorType", "incorrectPassword");
                } else if (storedStatus != 1) {
                    request.setAttribute("errorType", "emailNotVerified");
                } else {
                    request.getRequestDispatcher("/WEB-INF/pages/loginSuccess.jsp").forward(request, response);
                    return;
                }
            }

            request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
