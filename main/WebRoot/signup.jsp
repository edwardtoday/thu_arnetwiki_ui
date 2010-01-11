<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="org.net9.arnetwiki.ui.um.UserWebController"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ArnetWiki Sign Up</title>
    
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
  
  <body>
  	<div id="outerframe" >
	    <div id="mainframe">
	    	<div id="topbar"><a href="index.jsp">Home Page</a>|<a href="signin.jsp">Sign In</a></div>
	    	<div id="mainlogo" >
	    		<a href="index.jsp"><img width="135" height="135" alt="logo" src="logo2.png"/></a>
			</div>
	    	<hr/>
	    	<%
	    		request.setCharacterEncoding("UTF-8");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String repassword = request.getParameter("repassword");
				String email = request.getParameter("email");
				UserWebController controller = new UserWebController(request);
				if(username == null || password == null || email == null || repassword == null || !password.equals(repassword)) {
	    	 %>
	    	<form id="signupform" action="" method="post">
	    		<div>Username : <br/><input name="username" type="text" /></div>
	    		<div>Password : <br/><input name="password" type="password" /></div>
	    		<div>Retype Password : <br/><input name="repassword" type="password" /></div>
	    		<div>Email : <br/><input name="email" type="text" /></div>
	    		<input id="signupsubmit" type="submit" value="Sign Up!!" onclick="validateLogin()">
	    	</form>
	    	<script language="javascript">
				     function validateLogin()
				     {
				      	var sUserName = document.signupform.username.value;
				      	var sNickName = document.signupform.nickname.value;
				      	var sPassword = document.signupform.password.value;
				      	var sRePassword = document.signupform.repassword.value;
				      	var sEmail = document.signupform.email.value;
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
				      	else if( sRePassword=="" )
				      	{
				       		alert("Please input the password again!");
				       		return false;
				      	}
				      	else if( sEmail=="" )
				      	{
				       		alert("Please input the email!");
				       		return false;
				      	}
				      	else if(sPassword != sRePassword)
				      	{
				      		alert("Please check the password!");
				       		return false;
				      	}
				      	else{
				      		document.signupform.action="newindex.jsp"; 
				      		document.signupform.Submit(); 
				      	}
				     }
				 </script>
	    </div>
	    <% } else {
	    	
	    }
	     %>
	    <div id="bottom">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
  </body>
</html>
