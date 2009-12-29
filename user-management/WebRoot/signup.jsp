<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ArnetWiki Sign Up</title>
    
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
    <br/>
  	<div id="outerframe" style="margin:auto;padding:15px;width:600px;height:300px">
	    <div id="mainframe" style="margin:auto;padding:15px;border:1px solid;width:600px;height:300px">
	    	<div id="topbar" align="right"><a href="index.jsp">Home Page</a>|<a href="signin.jsp">Sign In</a></div>
	    	<div id="mainlogo" style="border:1px solid;width:200px;height:80px"> here is logo</div>
	    	<hr/>
	    	<%
	    		request.setCharacterEncoding("UTF-8");
				String username = request.getParameter("username");
				String nickname = request.getParameter("nickname");
				String password = request.getParameter("password");
				String repassword = request.getParameter("repassword");
				String email = request.getParameter("email");
				
	    	 %>
	    	<form id="signupform" action="">
	    		<div>Welcome to ArnetWiki!</div>
	    		<div>Username : <input id="username" /></div>
	    		<div>Nickname : <input id="nickname" /></div>
	    		<div>Password : <input id="password" type="password" /></div>
	    		<div>Retype Password : <input id="repassword" type="password" /></div>
	    		<div>Email : <input id="email"/></div>
	    		<input id="signupsubmit" type="submit" value="Sign Up!!">
	    	</form>
	    </div>
	    <div id="bottom" align="right">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
  </body>
</html>
