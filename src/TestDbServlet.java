
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String user = "springstudent";
        String pass = "springstudent";

        String jdbc = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.jdbc.driver";


        try {
            PrintWriter out = response.getWriter();

            out.println("Connecting to database " + jdbc);

            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbc, user, pass);

            out.println("Connection successful!");

            myConn.close();

        }
        catch (Exception exc) {
            exc.printStackTrace();
            throw new ServletException();
        }

    }
}
