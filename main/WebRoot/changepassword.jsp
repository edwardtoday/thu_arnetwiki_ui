<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ include file="/session.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ArnetWiki</title>
    
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
    <br/>
  	<div id="outerframe" >
	    <div id="mainframe" >
	    	<div id="topbar">
	    	<a href="index.jsp">Home Page</a>|<a href="favorite.jsp">Favorite</a>|<a href="group.jsp">Group</a>|<a href="setting.jsp">Setting</a>|<a href="logout.jsp">Sign Out</a></div>
	    	<div id="mainlogo" >
	    		<img width="135" height="135" alt="logo" src="Wiki3.png"/>
			</div>
	    	<hr/>
	    	<%
				  	request.setCharacterEncoding("UTF-8");
				  	String currentpassword = request.getParameter("currentpassword");
				  	String oldpassword = (String)session.getAttribute("password");
				  	String newpassword = request.getParameter("newpassword");
				  	String renewpassword = request.getParameter("retypenewpassword");
				  		if(currentpassword != null && !currentpassword.equals(oldpassword)) {
	 				%>
	 					<p>Old Password error!</p>
	 				<%
	 					} else if(newpassword != null && !newpassword.equals(renewpassword)) {
	 				%>
	 					<p>New password not equal!</p>
	 				<%
	 					} else if (currentpassword == null || currentpassword.isEmpty() || 
	 					newpassword == null || newpassword.isEmpty() || 
	 					renewpassword == null || renewpassword.isEmpty()) {
	 				 %>
	    	<form id="signupform" action="">
	    		<div>Welcome to ArnetWiki!</div>
	    		<div>Current password : <input id="currentpassword" type="password"/></div>
	    		<div>New password : <input id="newpassword" type="password"/></div>
	    		<div>Retype New password : <input id="retypenewpassword" type="password"/></div>
	    		<input id="changepassword" type="button" value="Save" onClick="javascript:window.location='setting.jsp'"/>
	    	</form>
	    	<%
	    			}else {
						try {
							
				%>
					<p>You've successfully changed the password.</p>
				<%
					} catch (Exception e) {
						e.printStackTrace();
						response.sendRedirect("error.jsp");
						return;
						}
					}
				%>
	    </div>
	    <div id="bottom" align="right">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
  </body>
</html>
