<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="org.net9.arnetwiki.ui.um.UserWebController"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ArnetWiki Setting</title>
    
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
  	<%
  		request.setCharacterEncoding("UTF-8");
  		UserWebController controller = new UserWebController(request);
  		if(!controller.isLoggedIn()) {
  	 %>
    <br/>
  	<div id="outerframe" style="margin:auto;padding:15px;width:600px;height:300px">
	    <div id="mainframe" style="margin:auto;padding:15px;border:1px solid;width:600px;height:300px">
	    	<div id="topbar" align="right"><a href="newindex.jsp">Home Page</a></div>
	    	<div id="mainlogo" style="border:1px solid;width:200px;height:80px"> here is logo</div>
	    	<hr/>
	    	<form id="settingform" action="">
	    		<div>Welcome to ArnetWiki!</div>
	    		<div>Nickname : <input id="nickname" /></div>
	    		<div>Email : <input id="email"/></div>
	    		<input id="settingsubmit" type="button" value="Save" onClick="javascript:window.location='newindex.jsp'"/>
	    		<input id="changepassword" type="button" value="Change Password" onClick="javascript:window.location='changepassword.jsp'"/>
	    	</form>
	    </div>
	    <div id="bottom" align="right">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
    <% } else {
    		out.println("<script language='javaScript'> alert('Please sign in!');" + 
    		"document.location.href='signin.jsp';</script>");
    	}
     %>
  </body>
</html>
