<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
     <script src="//rawgithub.com/stidges/jquery-searchable/master/dist/jquery.searchable-1.0.0.min.js"></script>
       <script type="text/javascript" src= "scripts/friendList.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    <title>WhatsDown!<s:property value="#session.name"/></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="style/ChatBox.css">
	

  </head>
  
  <body>
 
    <div class="container">
    <div class="row form-group">
        <div class="col-xs-12 col-md-offset-2 col-md-8 col-lg-8 col-lg-offset-2">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-comment"></span> Comments
                    <div class="btn-group pull-right">
                        <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-chevron-down"></span>
                        </button>
                        <ul class="dropdown-menu slidedown">
                            <li><a href="javascript:window.location.reload()"><span class="glyphicon glyphicon-refresh">
                            </span>Refresh</a></li>
                            
                            <li class="divider"></li>
                            <li><a href="<s:url action="logoutAction"/>"><span class="glyphicon glyphicon-log-out"></span>
                                Sign Out</a></li>
                        </ul>
                    </div>
                </div>
                <div class="panel-body body-panel">
                    <ul class="chat">
                    <s:iterator value="messageArray">
                    <s:if test="SenderEmail == #session.selectedId"> 
                        <li class="left clearfix"><span class="chat-img pull-left">
                            <img src="http://placehold.it/50/55C1E7/fff&text=Pal" alt="User Avatar" class="img-circle" />
                        </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <strong class="primary-font"><s:property value = "senderName"/></strong> <small class="pull-right text-muted">
                                        <span class="glyphicon glyphicon-time"></span><s:property value = "time"/></small>
                                </div>
                                <p>
                                    <s:property value = "message"/>
                                </p>
                            </div>
                           </li>
                         </s:if> 
                        <s:if test="SenderEmail == #session.email">
                        <li class="right clearfix"><span class="chat-img pull-right">
                            <img src="http://placehold.it/50/FA6F57/fff&text=ME" alt="User Avatar" class="img-circle" />
                    </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <small class=" text-muted"><span class="glyphicon glyphicon-time"></span><s:property value = "time"/></small>
                                    <strong class="pull-right primary-font"><s:property value ="senderName"/></strong>
                                </div>
                                <p>
                                    <s:property value = "message"/>
                                </p>
                            </div>
                         </li>
                       </s:if>
                      </s:iterator>
                    </ul>
                </div>
                    <div class="panel-footer clearfix">
                   <!--  <form action="sendMessage" method = "Post"> -->
                    <textarea name  =  "message"  id = "text1" class="form-control" rows="3" required></textarea>
                    <span class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-xs-12" style="margin-top: 10px">
                        <button type = "submit" class="btn btn-warning btn-lg btn-block" id="btn-chat">Send</button>
                    </span>
                   <!--  </form> -->
                </div>
            </div>
        </div>
    </div>
</div>
      <div id="cant-do-all-the-work-for-you" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="mySmallModalLabel">Report</h4>
                </div>
                <div class="modal-body">
                    <p id ="response1">You message has been delivered</p><br/>
                    <p><strong><br/>
                    ~ WhatsDown</strong></p>
                </div>
            </div>
        </div>
    </div>
                        
  </body>
  
  <script type="text/javascript">

  $("#btn-chat").click(function(){
    var txt = $("textarea").val();
    if(txt != null){
    $.post("sendMessage.action", {message: txt}, function(result){
        //$("span").html(result);
         if(result=="success")
          { 
             
             $("#text1").val("");
               $('#cant-do-all-the-work-for-you').modal('show');
              // window.location.href = '#cant-do-all-the-work-for-you';
                          
          }
           else{ 
               $("#mySmallModalLabel").text("ERROR REPORT!!");
                $("#response1").text("");
                $("#response1").text("There was an issue in sending message. Try Again");
              $('#cant-do-all-the-work-for-you').modal('show');
    
     } 
       
       
       
    });
    }
    
});
  
  </script>
</html>
