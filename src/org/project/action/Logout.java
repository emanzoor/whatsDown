package org.project.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport implements SessionAware {
	private SessionMap<String,Object> sessionMap;
	HttpServletRequest httpServletRequest;
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		sessionMap=(SessionMap)map;
	}
	public String execute()
	{
		try{
		HttpSession session=ServletActionContext.getRequest().getSession(false);
		System.out.println(session.getAttribute("email"));
		sessionMap.put("login","null");
		sessionMap.put("name","null");
		System.out.println(session.getAttribute("login"));
		session.removeAttribute("login");
		session.removeAttribute("name");
		session.removeAttribute("email");
		session.invalidate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	

}
