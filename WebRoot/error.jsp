<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">
.errors {
	background-color:#FFCCCC;
	border:1px solid #CC0000;
	width:400px;
	margin-bottom:8px;
}
.errors li{
	list-style: none;
}
</style>
    <base href="<%=basePath%>">
    
    <title>Sorry! Try Again</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <s:if test="hasActionErrors()">
   <div class="errors" align="center">
      <s:actionerror/>
   </div>
   </s:if>
   <s:if test="#session.login!=true">
   <p style= " color:red;
    font-size: 30px" align="center">
   Hey you got to login <a href = "Login.jsp">here</a> to chat with your peeps  <br></p>
    </s:if>
  </body>
</html>
