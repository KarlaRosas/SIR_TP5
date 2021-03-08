package jpa;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(name="fichesinfo",
        urlPatterns={"/FichesInfo"})

public class FichesInfo extends HttpServlet {

    private static final long serialVersionUID = 1L;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/jpa?serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "";



    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        //Obtenir valeur à ajouter à la BD
        String nombre =request.getParameter("name");


        Connection conn = null;
        Statement stmt = null;


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<HTML>\n<BODY style='background-color:#D6F1EE;'>" +
                "<H1 style='color: #5e9ca0;'>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>La fuche a été ajouté à la Base de données: "
                + request.getParameter("name") + "\n" +
                "</BODY></HTML>");

        try{
            //JDBC Conection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // SQL
            stmt = conn.createStatement();

            String sql;

            //Obtenir l'ID du dernier enregistrement
            sql = "SELECT MAX(id) as id FROM Fiche";

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id  = rs.getInt("id");
                int id2 =id+1;
                stmt.executeUpdate("INSERT INTO `fiche`(`id`, `name`, `section_id`) VALUES ("+id2+",'"+ nombre+"',3)");
                //stmt.executeUpdate("INSERT INTO `utilisateur`(`id`, `name`) VALUES ("+id2+",'"+ nombre+"')");
                //INSERT INTO `fiche`(`id`, `name`, `section_id`) VALUES ([value-1],[value-2],[value-3])
            }


            out.print("Insert Success");
            out.println("</body></html>");

            rs.close();
            stmt.close();
            conn.close();

        } catch(SQLException se) {
            //JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Class.forName
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