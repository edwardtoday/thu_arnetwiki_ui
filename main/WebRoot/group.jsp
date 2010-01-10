<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ include file="/session.jsp"%>
<%@page import="org.net9.arnetwiki.ui.um.UserWebController"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ArnetWiki Group</title>
    
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
  	 <%
  		request.setCharacterEncoding("UTF-8");
  		//UserWebController controller = new UserWebController(request);
  	 %>
  	<div id="outerframe" >
	    <div id="mainframe" >
	    	<div id="topbar">
	    	<%	
	    		String username = (String)session.getAttribute("username");
	    		System.out.println("1:" + controller.isLoggedIn());
	    		if(!controller.isLoggedIn() || controller == null) {
	    		%>
	    		<a href="signin.jsp">Sign In</a>
	    		<%} else { %>
	    		Welcome,<%=username%><a href="index.jsp">Home</a>|<a href="favorite.jsp">Favorite</a>|<a href="group.jsp">Group</a>|<a href="setting.jsp">Setting</a>|<a href="logout.jsp">Sign Out</a>
	    		<%} %>
	    	</div>
	    	<div id="mainlogo" >
	    		<a href="index.jsp"><img width="135" height="135" alt="logo" src="logo2.png"/></a>
			</div>
	    	<hr/>
	    	<div id="mygroup" >
	    		<table id="mygrouptable">
	    			<tr>
	    				<td>Welcome1</td>
	    				<td><input type="button" value="I want to quit!!"/></td>
	    			</tr>
	    			<tr>
	    				<td>Welcome2</td>
	    				<td><input type="button" value="I want to quit!!"/></td>
	    			</tr>
	    			<tr>
	    				<td>Welcome3</td>
	    				<td><input type="button" value="I want to quit!!"/></td>
	    			</tr>	
	    		</table>
	    	</div>
	    	<div id="searchgroup" >
	    		<input type="text" name="querytext"/>
	    		<input type="button" id="searchgroupbutton" value="Search!!" onclick=""/>
	    		<div id="searchgroupresult" ></div>
	    	</div>
	    </div>
	    <div id="bottom">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
  </body>
</html>
