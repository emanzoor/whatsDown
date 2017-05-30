package org.project.DAO;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import java.util.ArrayList;

import org.project.action.CONSTANTS;
import org.project.bean.User;

public class UserDao {
	

	
	private static Connection conn ;

	public User user;
	public User checkIfValidUser(User u){
		Connection con = null;
		try
		{
			Class.forName(CONSTANTS.CLASSNAME).newInstance();
			//Get a connection
			con = DriverManager.getConnection(CONSTANTS.dbURL); 
		
		}
		catch (Exception except)
		{
			except.printStackTrace();
		}
		boolean validUser = false;
		
		
		try
		{
			PreparedStatement pst = con.prepareStatement("SELECT * FROM CLASSICCARS.USERS WHERE EMAIL = ? and PASSWORD = ?");  
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			
			 ResultSet results = pst.executeQuery();
			 if (!results.next() ) {
				   
				    u.setUsername("Wrong USER");
				    return u;
				} 
			 else{
		
		   	    u.setUsername(results.getString("USERNAME")); 
					u.setEmail(results.getString("EMAIL"));
		    	 
			 }
		   
			
			
				
					validUser = true;
				
				results.close();
				pst.close();
				con.close();
			
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}

	
		return u;
	}

	private static void createConnection()
	{
		try
		{
			Class.forName(CONSTANTS.CLASSNAME).newInstance();
			//Get a connection
			conn = DriverManager.getConnection(CONSTANTS.dbURL); 
		}
		catch (Exception except)
		{
			except.printStackTrace();
		}
	}

	@SuppressWarnings("finally")
	public int signUp(User u) 
	{
		int isUSerAdded = 0;
		createConnection();

		try
		{
 
			
			PreparedStatement ps=conn.prepareStatement("insert into CLASSICCARS.USERS (USERNAME,PASSWORD,EMAIL,LOCATION) values (?,?,?,?)"); 
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
		
			ps.setString(4, u.getLocationHint());
			isUSerAdded= ps.executeUpdate();

			ps.close();
			conn.close();
			return isUSerAdded;
		}
		catch(SQLIntegrityConstraintViolationException ex)
		{
			isUSerAdded = 2;
			ex.printStackTrace();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
		finally{
			
			
			return isUSerAdded;
		}



	}
	public ArrayList<User> getUserList(String u)
	{
		User tempUser = new User();
		ArrayList<User> users = new ArrayList<User>();
		try
		{
			Connection con = null;
		try
		{
			Class.forName(CONSTANTS.CLASSNAME).newInstance();
			//Get a connection
			con = DriverManager.getConnection(CONSTANTS.dbURL); 
			
		}
		catch (Exception except)
		{
			except.printStackTrace();
		}
		PreparedStatement pst = con.prepareStatement("SELECT USERNAME,EMAIL,LOCATION FROM CLASSICCARS.USERS WHERE 1 = ?");  
		
		pst.setInt(1, 1);
		 ResultSet results = pst.executeQuery();
      
			 if(!results.next())
			 {
				 tempUser.setUsername("Empty user set");
				 users.add(0,tempUser);
				 
				 return users;
			 }
			 int i = 0;
			 
		
			 while(results.next()){
				 User tmpUser = new User();
				 tmpUser.setUsername(results.getString("USERNAME"));
				 tmpUser.setEmail(results.getString("EMAIL"));
				 tmpUser.setLocationHint(results.getString("LOCATION"));
				 if(!(tmpUser.getEmail().equals(u))){
					 users.add(i,tmpUser);
		           
		           	 
				 }
				 
				 

				
			 
			 }
			 pst.close();
			 con.close();
			 
		}
		catch(Exception ex){
			ex.printStackTrace();
		
		}
		return users;
		
	}
	public String getName(String email)
	{
		String name ="name";
		try
		{
			Connection con = null;
		
			Class.forName(CONSTANTS.CLASSNAME).newInstance();
			//Get a connection
			con = DriverManager.getConnection(CONSTANTS.dbURL); 
		
		
		
		PreparedStatement pst = con.prepareStatement("SELECT * FROM CLASSICCARS.USERS WHERE EMAIL= ?");  
		 pst.setString(1, email);
		 ResultSet results = pst.executeQuery();
		 if (results.next() ) {
				
		         name = results.getString("USERNAME") ;
		 }
		 pst.close();
		 con.close();
		}
		catch (Exception except)
		{
			except.printStackTrace();
		}
		
		return name;
	}



}
