<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.net9.arnetwiki.ui.um.UserWebController"%>
<%@page import="java.awt.Window"%>
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
  	<%
  		request.setCharacterEncoding("UTF-8");
  		UserWebController controller = new UserWebController(request);
  		if(!controller.isLoggedIn()) {
  	 %>
    <br/>
  	<br/>
  	<br/>
  	<div id="outerframe" >
	    <div id="mainframe">
	    	<div id="topbar" align="right"><div id="loginuserid"></div><a href="favorite.jsp">Favorite</a>|<a href="group.jsp">Group</a>|<a href="setting.jsp">Setting</a>|<a href="logout.jsp">Sign Out</a></div>
	    	<div id="mainlogo" >
	    		<img width="135" height="135" alt="logo" src="Wiki3.png"/>
			</div>
	    	<br/>
	    	<div id="query">
				<form method="post" action="result-list.jsp" name="searchform">
					<input id="querytext" type="text" name="querytext"/>
					<input id="searchbutton" type="submit" value="Search!" >
				</form>
	    	</div>  
	    	<br/>
	    	<div id="trythis">Try This</div>
	    	<hr/>
	    	<div class="searchsamples"><a href="">SOA</a> <a href="">IR</a> </div>
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
