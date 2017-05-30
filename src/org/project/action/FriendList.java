package org.project.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.project.DAO.UserDao;
import org.project.bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class FriendList extends ActionSupport implements SessionAware{

	/**
	 * 
	 * 
	 */
	public UserDao dao = new UserDao();
	public ArrayList<User> userList = new ArrayList<User>();
	
	private SessionMap<String,Object> sessionMap;
	private static final long serialVersionUID = 1L;
	@Override
	public String execute()
	{
		 //show all the users except the one with which you are logged in
		 HttpSession session=ServletActionContext.getRequest().getSession(false);  
	        if(session==null || session.getAttribute("login")==null||  session.getAttribute("login")=="null"){  
	            return ERROR;  
	        }  
	        else{  
	        	String email = (String) session.getAttribute("email");
	        	userList = dao.getUserList(email);
	        	if(userList.get(0).getUsername().equals("Empty user set"))
	        	{
	        		addActionError(CONSTANTS.EMPTY_USER_SET);
	    			return ERROR;
	        	}
	        
	            return SUCCESS;  
	        }
	}
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sessionMap=(SessionMap)map;
		
	}

}
