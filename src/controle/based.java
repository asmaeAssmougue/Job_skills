package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import Dao.user;

public class based {
    public Connection connect(){
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		String url="jdbc:mysql://localhost:3306/javaproject";
			String user="root";
			String passwrd="";
			Connection con=DriverManager.getConnection(url,user,passwrd);
			return con;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
		
    }
    
    public boolean insertU(Connection con, user U) {
    	boolean temp;
    	try {
    		
			String query1="INSERT INTO `users`(`FirstName`, `LastName`, `username`, `email`, `password`) VALUES ('"+U.getPrenom()+"','"+U.getNom()+"','"+U.getUsername()+"','"+U.getEmail()+"','"+U.getPassword()+"')";
			Statement smt2=con.createStatement();
			int rs2 = smt2.executeUpdate(query1);	
			
			if(rs2 > 0) {
				temp=true;
			}
			else {
				temp=false;
			}
			return temp;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	    return false;
    	}
    }
    public ResultSet SelectU(Connection con) {
       	
       	try {
       		String sql="SELECT * FROM `users`";
       		Statement smt=con.createStatement();
       		ResultSet rs=smt.executeQuery(sql);
       		
       		return rs;
       		
       	}catch(Exception e) {
       		e.printStackTrace();
       		return null;
       		
       	}
       	
       }
    public ResultSet selection(Connection con) {
		try {
			
		String sql = "SELECT * FROM resultat_scrapping";
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery(sql);
		     return rs;
		} catch (Exception e) {

		      e.printStackTrace();
		      return null;
              

		}
       
    }
  
}

