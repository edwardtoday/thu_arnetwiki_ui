<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="org.net9.arnetwiki.ui.um.UserWebController"%>
<%@ include file="/session.jsp"%>
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
	<link rel="stylesheet" type="text/css" href="index.css">
	<script type="text/javascript" src="jquery.js"></script>
	<script type="text/javascript" src="interface.js"></script>
	<script type="text/javascript" src="main.js"></script>

  </head>
  
  <body>
  	<%
  		request.setCharacterEncoding("UTF-8");
  	 %>
    <br/>
  	<div id="outerframe" >
	    <div id="mainframe">
	    	<div id="topbar" align="right">
	    	<a href="index.jsp">Home Page</a>|<a href="favorite.jsp">Favorite</a>|<a href="group.jsp">Group</a>|<a href="logout.jsp">Sign Out</a></div>
	    	<div id="mainlogo" >
	    		<img width="135" height="135" alt="logo" src="Wiki3.png"/>
			</div>
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
  </body>
</html>
