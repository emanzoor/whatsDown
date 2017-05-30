package org.project.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.project.DAO.UserDao;
import org.project.bean.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements SessionAware, ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user = new User();
	UserDao dao = new UserDao();
	private SessionMap<String,Object> sessionMap;  
	
	@Override
	public String execute()
	{
		if(user.getEmail().equals(""))
			return ERROR;
		if(user.getPassword().equals(""))
			return ERROR;
		user =  dao.checkIfValidUser(user);
		if(user.getUsername().equals("Wrong USER")){
			addActionError(CONSTANTS.LOGIN_iNVALID_DESC);
			return ERROR;
		}
		else{
			sessionMap.put("login","true");  
			 sessionMap.put("name",user.getUsername());
			 sessionMap.put("email",user.getEmail());
			
		}
		 	  
		return SUCCESS;		
		
	}

	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sessionMap=(SessionMap)map;
		
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
