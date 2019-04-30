<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style>
  .glyphicon.glyphicon-off {
    font-size: 25px;
}
  </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    <title>WhatsDown!<s:property value="#session.name"/></title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/friendList.css">
     <script type="text/javascript" src= "scripts/friendList.js"></script>
     
  
    

  </head>
  
  <body>
    <%-- This is my JSP page. <s:property value="#session.name"/> <br>
     <s:iterator value="userList">
     <s:property value="username" />
     <s:property value="email" /></br>
     </s:iterator>
 --%>     <div class="row">
        <div class="col-xs-12 col-sm-offset-3 col-sm-6">
            <div class="panel panel-default" >
                <div class="panel-heading c-list">
				
				
                
                    <span class="title">Members</span>
                    <ul class="pull-right c-controls">
                        <li><a href="#cant-do-all-the-work-for-you" data-toggle="tooltip" data-placement="top" title="Add Contact"><i class="glyphicon glyphicon-plus"></i></a></li>
                        <li><a href="#" class="hide-search" data-command="toggle-search" data-toggle="tooltip" data-placement="top" title="Search"><i class="fa fa-ellipsis-v"></i></a></li>
                        <li><a href = "<s:url action="logoutAction"/>"class="hide-search" data-toggle="tooltip" data-placement="top" title="LOG OUT"> <i class = "glyphicon glyphicon-off"></i></a> </li>
                    </ul>
                </div>
                
                <div class="row" style="display: none;">
                    <div class="col-xs-12">
                        <div class="input-group c-search">
                            <input type="text" class="form-control" id="contact-list-search">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search text-muted"></span></button>
                            </span>
                        </div>
                    </div>
                </div>
                
                <ul class="list-group" id="contact-list">
                  <s:iterator value="userList">
                    <li class="list-group-item">
                        <!-- <div class="col-xs-12 col-sm-3">
                            <img src="" alt="Scott Stevens" class="img-responsive img-circle" />
                        </div> -->
                      <a href = "Chatbox.action?selectedId=<s:property value="email" />">
                         <div class="col-xs-12 col-sm-9">
                            <span class="name"> <s:property value="username" /></span><br/>
                            <span class="glyphicon glyphicon-map-marker text-muted c-info" data-toggle="tooltip" title=<s:property value="locationHint" />></span>
                            <span class="visible-xs"> <span class="text-muted"><s:property value="locationHint" /></span><br/></span>
                            <span class="fa fa-comments text-muted c-info" data-toggle="tooltip" title=<s:property value="email" />></span>
                            <span class="visible-xs"> <span class="text-muted"><s:property value="email" /></span><br/></span>
                         </div> 
                       </a>                       
                        <div class="clearfix"></div>
                    </li>
                  </s:iterator>
                  </ul>
                  
                  
       <div id="cant-do-all-the-work-for-you" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="mySmallModalLabel">Ooops!!!</h4>
                </div>
                <div class="modal-body">
                    <p>You can't add users from here... duhh! They have to sign up to be seen. Not Everything is in our control</p><br/>
                    <p><strong>Sorry<br/>
                    ~ Padfoot</strong></p>
                </div>
            </div>
        </div>
    </div>
    
    <!-- JavaScrip Search Plugin -->
    <script src="//rawgithub.com/stidges/jquery-searchable/master/dist/jquery.searchable-1.0.0.min.js"></script>
    
</div>
   
     
  </body>
</html>
