/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

/**
 *
 * @author Administrator
 */
import java.sql.*;

public class DBConnect {
      public static Connection connect(){
         try{
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				String dbUrl = "http://localhost:8080/phpmyadmin";
				String username = "root";
				String password = "usbw";
				Connection connection = DriverManager.getConnection(dbUrl,username,password);
                return connection;
         }
         catch(Exception ex){
             return null;
         }
    }
}