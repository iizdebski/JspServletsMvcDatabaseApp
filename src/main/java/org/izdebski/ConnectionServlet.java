package org.izdebski;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        // define the fields
        String username = "root";
        String password = "root";
        String jdbcURL = "jdbc:mysql://localhost:3306/employeedirectory";
        String driver = "com.mysql.jdbc.Driver";

        try{
            // Get the PrintWriter Object
            PrintWriter writer = response.getWriter();
            writer.println("Connecting to database"+jdbcURL);
            // Load the Driver
            Class.forName(driver);

            // Get  the connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            writer.println("Connection successfull");
            // Close the connection
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        super.doPost(request, response);
    }
}