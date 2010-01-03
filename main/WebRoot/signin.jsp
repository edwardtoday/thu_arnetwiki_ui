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
				  	String username = request.getParameter("username");
				  	String password = request.getParameter("password");
				  	UserWebController controller = new UserWebController(request);
  					if(controller.isLoggedIn()) {
  				%>
  					<p>You've already logged in.</p>
  				<%
  					} else if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
  				 %>
	    			<p>Please log in to continue:</p>
	    		<form name="loginform" method="post" action="">
	    			<div name="username" >Username : 
	    				<input name="usernametext" type="text" /></div>
	    			<div name="password" >Password : 
	    				<input name="passwordtext" type="password"/></div>
	    			<!-- <input id="rememberlogin" type="checkbox">remember the state<br> -->
	    			<input id="loginsubmit" type="submit" value="login" onclick="validateLogin()"/><!--<a href="">forget the password?</a>-->
	    		</form>
	    		<script language="javascript">
				     function validateLogin()
				     {
				      	var sUserName = document.loginform.usernametext.value;
				      	var sPassword = document.loginform.passwordtext.value;
				      	if( sUserName=="" )
				      	{
				       		alert("Please input the username!");
				       		return false;
				      	}
				      	else if( sPassword=="" )
				      	{
				       		alert("Please input the password!");
				       		return false;
				      	}
				      	else{
				      		document.loginform.action="newindex.jsp"; 
				      		document.loginform.Submit(); 
				      	}
				     }
				 </script>
	    		<%
	    			}else {
						try {
							controller.login(username, password);
							String cont = request.getParameter("continue");
							if (cont != null && !cont.isEmpty()) {
								response.sendRedirect(cont);
								return;
							}
				%>
					<p>You've successfully logged in as <%=username %>.</p>
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
	    		<hr/>
	    		<div id="donothaveaccout">if you do not have an account</div>
	    		<input id="signupsubmit" type="button" value="Sign Up!!" onClick="javascript:window.location='signup.jsp'" />
	    	</div>
	    </div>
	    <div id="bottom">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
  </body>
</html>
