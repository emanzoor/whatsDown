package org.project.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import org.project.action.CONSTANTS;
import org.project.bean.Messages;
import org.project.bean.User;

public class MessagesDAO {

	private static Connection conn ;
	private Messages message;
	
	public ArrayList<Messages> getMessages(String selected, String userEmail){
		ArrayList<Messages> messageArray = new ArrayList<Messages>();
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
		PreparedStatement pst = con.prepareStatement("SELECT * FROM CLASSICCARS.MESSAGES WHERE SENGER_ID = ? and RECEIVER_ID = ? or SENGER_ID = ? and RECEIVER_ID = ?");  
		
		pst.setString(1, selected);
		pst.setString(2, userEmail);
		pst.setString(3, userEmail);
		pst.setString(4, selected);
		
		 ResultSet results = pst.executeQuery();
         Messages tmpMessage = new Messages();
			 if(!results.next())
			 {
				 tmpMessage.setMessage("Start Conversation now");
				 messageArray.add(0,tmpMessage);
			
				 
				 return messageArray;
			 }
			 else{
			 int i = 0;
			 
			 System.out.println(results.getFetchSize()+"   "+ pst.getMaxRows());
			 do{
		         Messages tempMessage = new Messages();
		         tempMessage.setMessage(results.getString("MESSAGE"));
		         tempMessage.setSenderEmail(results.getString("SENGER_ID"));
		         tempMessage.setReceiverEmail(results.getString("RECEIVER_ID"));
		         tempMessage.setSenderName(results.getString("SENDER_NAME"));
		         tempMessage.setReceiverName(results.getString("RECEIVER_NAME"));
		         tempMessage.setTime(results.getString("TIME"));
					 messageArray.add(i,tempMessage);
				
					 
					 i++;
		       	
			 
			 }while(results.next());
			 }
			 
		}
		catch(Exception ex){
			ex.printStackTrace();
		
		}


	
		return messageArray;
	}

	public int saveMessage(Messages message) {
		int messageSent= 0;
		
		try
		{
 
			Connection con = null;
			try
			{
			Class.forName(CONSTANTS.CLASSNAME).newInstance();
			//Get a connection
			con = DriverManager.getConnection(CONSTANTS.dbURL); 
		
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			PreparedStatement ps=con.prepareStatement("insert into CLASSICCARS.MESSAGES (MESSAGE,RECEIVER_ID,SENGER_ID,SENDER_NAME,RECEIVER_NAME,TIME) values (?,?,?,?,?,?)"); 
			ps.setString(1, message.getMessage());
			ps.setString(2, message.getReceiverEmail());
			ps.setString(3, message.getSenderEmail());
			ps.setString(4, message.getSenderName());
			ps.setString(5, message.getReceiverName());
			ps.setString(6, message.getTime());
			messageSent= ps.executeUpdate();

			ps.close();
			
		}
		catch(SQLIntegrityConstraintViolationException ex)
		{
               messageSent = 2;
			ex.printStackTrace();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
		finally{
			
		}

			
     return messageSent;
	}
	
}
