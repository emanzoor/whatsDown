<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
Form {
    border: 3px solid #f1f1f1;
    text-align: center;
}
h1{
text-align: center;
color: #4CAF50;
}

Input {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    text-align: center;
   
}

.btn {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 50%;
}

.btn:hover {
    opacity: 0.8;
}



.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 20%;
    border-radius: 50%;
}

.container {
     width: 50%;
  margin: 0 auto;
  
}




</style>
</head>
<body>
<h1>WhatDown</h1>
    <s:form cssClass = "form" action = "sendLoginAction">
    
    <img src="images/image1.png" alt="Avatar" class="avatar">
  <br>
  <br>
  <div class="container">
    
    <input type="text" placeholder="Enter Username" name="uname" required><br>

    <input type="password" placeholder="Enter Password" name="psw" required><br>
        
    <button type="submit" class="btn">Login</button>
    
  </div>
  </s:form>
    
</body>
</html>
