package jpa;


import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


@WebServlet(name="mytest2", urlPatterns={"/myurl2"})
public class MyServletPost extends HttpServlet {

    private static final long serialVersionUID = 1L;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/jpa?serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "";



    public MyServletPost() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        Connection conn = null;
        Statement stmt = null;
        // HTML
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String title = "Servlet Mysql ";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");


            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name FROM Fiche";
            ResultSet rs = stmt.executeQuery(sql);

            out.print("Hello worlds despues de consulta");

            while(rs.next()){
                int id  = rs.getInt("id");
                String name  = rs.getNString("name");
                out.println("ID: " + id);
                out.println("Name: " + name);

            }
            out.println("</body></html>");


            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se) {

            se.printStackTrace();
        } catch(Exception e) {

            e.printStackTrace();
        }finally{

            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
