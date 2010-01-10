<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.net9.arnetwiki.ui.um.UserWebController"%>
<%@page import="org.net9.arnetwiki.ui.um.exception.LoginFailedException"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
	<script type="text/javascript" src="getXmlHttp.js"></script>
  </head>
  
  <script type="text/javascript" src="fordebug.js"></script>
  
  <body>
    <br/>
  	<br/>
  	<br/>
  	<div id="outerframe" >
	    <div id="mainframe">
	    	<div id="topbar" ><a href="index.jsp">HomePage</a></div>
    		<div id="mainlogo" >
    			<a href="index.jsp"><img width="135" height="135" alt="logo" src="logo2.png"/></a>
			</div>
			<hr/>
			<dir id="leftframe" >	
				<div id="query">
					<form method="post" action="result-list.jsp" name="searchform">
						<input id="querytext" type="text" name="querytext"/>
						<input id="searchbutton" type="submit" value="Search!" >
					</form>
		    	</div> 			
	    		<div id="trythis">
	    			<div class="searchsamples"><a href="">SOA</a> <a href="">IR</a> </div>
				</div>	    		
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
			    	<form id="loginform" method="post">
						<div name="username" >Username : <br/>
		    				<input name="usernametext" type="text" /></div>
		    			<div name="password" >Password : <br/>
		    				<input name="passwordtext" type="password"/></div>
						<input type="submit" value="Login" />
					</form>				    		
	    		<%
	    			}else {
						try {
							controller.login(username, password);
							session.setAttribute("username",username);
							
							String continued = request.getParameter("continue");
							if(continued != null && !continued.trim().equals("")){
								response.sendRedirect(continued);
							}
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
	    		<hr/>
	    		<div id="donothaveaccout">
	    			<!--<input id="signupsubmit" type="button" value="Sign Up!!" onClick="javascript:window.location='signup.jsp'" />-->
	    			<input id="signupsubmit" type="button" value="Sign Up!!" onClick="window.open('http://minipie.net9.org:8080/Mini-Pie/signup/')" />	
				</div>	    		
	    	</div>
	    </div>
	    <div id="bottom">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
  </body>
</html>
