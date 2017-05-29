package org.project.action;

import java.util.Date;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.project.DAO.MessagesDAO;
import org.project.DAO.userDao;
import org.project.bean.Messages;
import org.project.bean.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ChatBox extends ActionSupport implements SessionAware, ModelDriven<Messages>{
	private User user = new User();
	public userDao userdao= new userDao();
	MessagesDAO messagedao = new MessagesDAO();
	private SessionMap<String,Object> sessionMap;
	public ArrayList<Messages> messageArray = new ArrayList<Messages>();
	public String selectedId;
	public String selectedName;
	private Messages messages = new Messages();
	public String text;
	HttpSession session=ServletActionContext.getRequest().getSession(false);
	HttpServletRequest request = (HttpServletRequest) ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	
	
	public String execute(){
		//get messages for selected email id of certain user when clicked on contact list.
		if(session==null || session.getAttribute("login")==null){  
			return ERROR;  
		}
		System.out.println(selectedId);
		System.out.println(session.getAttribute("name"));
		sessionMap.put("selectedId", selectedId);
		String email = (String) session.getAttribute("email");
		messageArray = messagedao.getMessages(selectedId, email);
		//reverse array to get upside down array sequence in jsp
		//Collections.reverse(messageArray);
		//if(messageArray.get(0).getMessage().equalsIgnoreCase("Start Conversation now")){
			
			//return "new";
		//}
		//else{
			
			
		//}
		return SUCCESS;
	}
	
	
	public Messages getModel() {
		// TODO Auto-generated method stub
		return messages;
	}

	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sessionMap=(SessionMap)map;
		
	}


	public Messages getMessage() {
		return messages;
	}


	public void setMessage(Messages message) {
		this.messages = message;
	}
	
	public void sendText(){
		//save text in db
		String email = (String) session.getAttribute("email");
		String name = (String) session.getAttribute("name");
		selectedId = (String) session.getAttribute("selectedId");
		messages.setMessage(request.getParameter("message"));
		int flag = 0;
		messages.setReceiverEmail(selectedId);
		messages.setSenderEmail(email);
		messages.setMessage(messages.getMessage());
		messages.setSenderName(userdao.getName(email));
		messages.setReceiverName(userdao.getName(selectedId));
		
		Date date = new Date();
		String result;
		messages.setTime(date.toString());
		flag = messagedao.saveMessage(messages);
		if(flag == 1)
		{
			System.out.println("flag   "+flag );
			result = "success";
		    try {
				response.getWriter().write(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    //return result;
		}
		else{
			result = "Error";
		//return "error";
		}
	}
	

}
