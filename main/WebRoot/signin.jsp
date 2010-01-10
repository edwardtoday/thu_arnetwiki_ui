<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.net9.arnetwiki.ui.um.UserWebController"%>
<%@page import="org.net9.arnetwiki.ui.um.exception.LoginFailedException"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ArnetWiki Sign In</title>
    
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
  
  <script type="text/javascript" src="fordebug.js"></script>
  
  <body>
    <br/>
  	<br/>
  	<br/>
  	<div id="outerframe" >
	    <div id="mainframe">
	    	<div id="topbar" ><a href="index.jsp">HomePage</a></div>
	    	<dir id="leftframe" >
	    		<div id="mainlogo" >
	    			<img width="135" height="135" alt="logo" src="Wiki3.png"/>
				</div>
	    		<div id="trythis">Try This</div>
	    		<div class="searchsamples"><a href="">SOA</a> <a href="">IR</a> </div>
	    	</dir>
	    	<br/>
	    	<div id="signin" >
	    		<%
				  	request.setCharacterEncoding("UTF-8");
				  	String username = request.getParameter("usernametext");
				  	String password = request.getParameter("passwordtext");
				  	UserWebController controller = new UserWebController(request);
	 					if(controller.isLoggedIn()) {
	 				%>
	 					<p>You've already logged in.</p>
	 					<a href="index.jsp">click to go to the index.</a>
	 				<%
	 					} else if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
	 				 %>
	    			<p>Please log in to continue:</p>
			    	<form name="loginform" method="post">
						<div name="username" >Username : 
		    				<input name="usernametext" type="text" /></div>
		    			<div name="password" >Password : 
		    				<input name="passwordtext" type="password"/></div>
						<input type="submit" value="Login" />
					</form>	
					<hr/>
	    		<div id="donothaveaccout">if you do not have an account</div>
	    		<!--<input id="signupsubmit" type="button" value="Sign Up!!" onClick="javascript:window.location='signup.jsp'" />-->
	    		<input id="signupsubmit" type="button" value="Sign Up!!" onClick="window.open('http://minipie.net9.org:8080/Mini-Pie/signup/')" />	
	    		<%
	    			}else {
						try {
							controller.login(username, password);
							session.setAttribute("username",username);
							session.setAttribute("password",password);
				%>
					<p>You've successfully logged in as <%=username %>.</p>
					<a href="index.jsp">click to go to the index.</a>
				<%
					} catch(LoginFailedException e){
				%>
					<p>Login failed.</p>
				<%
					} catch (Exception e) {
						e.printStackTrace();
						response.sendRedirect("error.jsp");
						return;
						}
					}
				%>
	    	</div>
	    </div>
	    <div id="bottom">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
  </body>
</html>
