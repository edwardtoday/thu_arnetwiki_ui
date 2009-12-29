<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.net9.arnetwiki.user.UserWebController"%>
<%@page import="org.net9.arnetwiki.user.exception.LoginFailedException"%>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <br/>
  	<br/>
  	<br/>
  	<div id="outerframe" style="margin:auto;padding:15px;width:600px;height:300px">
	    <div id="mainframe" style="margin:auto;padding:15px;border:1px solid;width:600px;height:300px">
	    	<div id="topbar" align="right"><a href="index.jsp">HomePage</a></div>
	    	<dir id="leftframe" align="left" style="float:left;width:300px;padding-left:10px">
	    		<div id="mainlogo" style="border:1px solid;width:200px;height:80px"> here is logo</div>
	    		<br/>
	    		<div id="trythis">Try This</div>
	    		<hr/>
	    		<div class="searchsamples"><a href="">SOA</a> <a href="">IR</a> </div>
	    	</dir>
	    	<br/>
	    	<div id="signin" style="margin-left:auto;border:1px solid;width:250px;height:250px">
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
	    		<form id="loginform" action="">
	    			<div id="username" style="padding-left:10px;">Username : <input id="usernametext"/></div>
	    			<div id="password" style="padding-left:10px;">Password : <input id="passwordtext" type="password"/></div>
	    			<!-- <input id="rememberlogin" type="checkbox">remember the state<br> -->
	    			<input id="loginsubmit" type="submit" value="login"/><!--<a href="">forget the password?</a>-->
	    		</form>
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
	    <div id="bottom" align="right">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
  </body>
</html>
