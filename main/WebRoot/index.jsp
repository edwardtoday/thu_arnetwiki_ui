<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="org.net9.arnetwiki.ui.um.UserWebController"%>
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
  <script type="text/javascript" src="fordebug.js"></script>
  <body>
  	<br/>
  	<br/>
  	<br/>
  	<div id="outerframe" >
	    <div id="mainframe" >
	    	<%
				request.setCharacterEncoding("UTF-8");
				UserWebController controller = new UserWebController(request);  	

			%>
	    	<div id="topbar">
	    	<%	if(true) {%>
	    		<a href="signin.jsp">Sign In</a>
	    		<%} else { %>
	    		<a href="favorite.jsp">Favorite</a>|<a href="group.jsp">Group</a>|<a href="setting.jsp">Setting</a>|<a href="logout.jsp">Sign Out</a>
	    		<%} %>
	    	</div>
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
	    <div id="bottom">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
  </body>
</html>
