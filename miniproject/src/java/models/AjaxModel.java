package models;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class AjaxModel implements ModelInterface {

    @Override
    public void doBusiness(HttpServletRequest request, HttpServletResponse response, ServletContext context) {
        Dao md = Dao.getInstance();

        try {
            String n = (String)request.getParameter("data");
//            System.out.print(request.getAttribute("data"));
            int num = Integer.parseInt(n);
            String query = "SELECT * FROM state WHERE country_code='"+num+"'";
            Statement st = md.getConnection();
            ResultSet rs = st.executeQuery(query);
            
            JSONObject obj = new JSONObject();
            JSONArray list = new JSONArray();

            while (rs.next()) {
                JSONObject temp = new JSONObject();
                temp.put(rs.getInt("state_id"), rs.getString("state_name"));
                list.add(temp);
            }
            
            obj.put("states", list);
            String str = obj.toJSONString();
            PrintWriter out = response.getWriter();
            System.out.println(str);
            out.println(str);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
