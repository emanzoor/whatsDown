package org.project.action;

import java.util.Map;



import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.project.DAO.UserDao;
import org.project.bean.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SignUp extends ActionSupport implements SessionAware, ModelDriven<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4314267639879642269L;
	private User user = new User();
	UserDao userdao = new UserDao();
	private SessionMap<String,Object> sessionMap;
	
	
	

	@Override
	public String execute()
	{
		
		int flag = 0;
		try{
			
			flag = userdao.signUp(user);
			System.out.println(flag);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(flag==1)
		{
			sessionMap.put("login","true");  
			 sessionMap.put("name",user.getUsername());
			 sessionMap.put("email",user.getEmail());
			return SUCCESS;
		}
		if(flag==2)
		{
			addActionError(CONSTANTS.SIGNUP_EMAIL_DUPLICATE_DESC);
			return ERROR;
		}
		return ERROR;
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sessionMap=(SessionMap)map;
		
	}

}
