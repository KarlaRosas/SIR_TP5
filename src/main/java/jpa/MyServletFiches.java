package jpa;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(name="fiches", urlPatterns={"/Fiches"})
public class MyServletFiches extends HttpServlet {

    private static final long serialVersionUID = 1L;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/jpa?serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "";



    public MyServletFiches() {
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
        String title = "Fiches Kanban";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body style='background-color:#D6F1EE;'>" +
                "<H1 style='color: #5e9ca0;'>Fiches</H1>\n");

        try{
            //JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Conection SQL
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;

            sql = "SELECT name FROM Fiche";
            ResultSet rs = stmt.executeQuery(sql);


            while(rs.next()){

                String name  = rs.getNString("name");
                out.println("<LI>"+name);

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

}
