/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import BusinessLayer.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author JSaji
 */
public class LoginDB {
    public Login getLoginDetailsDB(String tUsername){
		Login loginObj = new Login();
            try{
                 Connection cons = DBConnect.connect();
                 String selectQUN = "select * from UserLogin where UserName = ?";
                 PreparedStatement ps = cons.prepareStatement(selectQUN);
                 ps.setString(1, tUsername);
                 ResultSet rs = ps.executeQuery();
                 if(rs.next()){
                     loginObj.setmUsername(rs.getString(1));
                     loginObj.setmPassword(rs.getString(2));
                    
                 } 
                 rs.close();
                 ps.close();
                 cons.close();  
            }
            finally{
                return loginObj;
            }            
	}
}
