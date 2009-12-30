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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript" src="fordebug.js"></script>
  <body>
  	<br/>
  	<br/>
  	<br/>
  	<div id="outerframe" style="margin:auto;padding:15px;width:600px;height:300px">
	    <div id="mainframe" style="margin:auto;padding:15px;border:1px solid;width:600px;height:300px">
	    	<%
				request.setCharacterEncoding("UTF-8");
				UserWebController controller = new UserWebController(request);  	

			%>
	    	<div id="topbar" align="right">
	    	<%	if(true) {%>
	    		<a href="signin.jsp">Sign In</a>
	    		<%} else { %>
	    		<a href="favorite.jsp">Favorite</a>|<a href="group.jsp">Group</a>|<a href="setting.jsp">Setting</a>|<a href="logout.jsp">Sign Out</a>
	    		<%} %>
	    	</div>
	    	<div id="mainlogo" style="border:1px solid;width:200px;height:80px"> here is logo</div>
	    	<br/>
	    	<div id="query" align="left">
	    		<input id="querytext" style="width:350px"/>
	    		<input id="searchbutton" type="submit" value="Search!"/>
	    		<!--<input id="signup" type="submit" value="Sign Up Now!!"/>-->
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
  </body>
</html>
