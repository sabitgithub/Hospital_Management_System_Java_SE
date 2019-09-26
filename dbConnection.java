/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system;

import java.sql.*;
import javax.swing.*;

public class dbConnection {
 static Connection con = null;
   public static Connection dbConnector()
   {
	   try {
		   Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmds","root","");
			Statement stmt = con.createStatement();
			JOptionPane.showMessageDialog(null, "Connection Established.Please Wait");
           return con;
		
	} catch (Exception e) {

		JOptionPane.showMessageDialog(null, e);
		return null;
	}
   }
}
