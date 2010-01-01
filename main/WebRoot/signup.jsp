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
  	<div id="outerframe" >
	    <div id="mainframe">
	    	<div id="topbar" align="right"><a href="index.jsp">Home Page</a>|<a href="signin.jsp">Sign In</a></div>
	    	<div id="mainlogo"> here is logo</div>
	    	<hr/>
	    	<%
	    		request.setCharacterEncoding("UTF-8");
				String username = request.getParameter("username");
				String nickname = request.getParameter("nickname");
				String password = request.getParameter("password");
				String repassword = request.getParameter("repassword");
				String email = request.getParameter("email");
				
	    	 %>
	    	<form name="signupform" action="" method="post">
	    		<div>Welcome to ArnetWiki!</div>
	    		<div>Username : <input name="username" type="text" /></div>
	    		<div>Nickname : <input name="nickname" type="text" /></div>
	    		<div>Password : <input name="password" type="password" /></div>
	    		<div>Retype Password : <input name="repassword" type="password" /></div>
	    		<div>Email : <input name="email" type="text" /></div>
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
				      	else if( sNickName=="" )
				      	{
				       		alert("Please input the nickname!");
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
	    <div id="bottom" align="right">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
  </body>
</html>
