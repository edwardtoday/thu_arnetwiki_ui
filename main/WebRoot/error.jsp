<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Error</title>
    
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
    <br/>
  	<br/>
  	<br/>
  	<div id="outerframe" >
	    <div id="mainframe" >
	    	<div id="topbar" align="right"><a href="index.jsp">HomePage</a></div>
	    	<dir id="leftframe" align="left" >
	    		<div id="mainlogo" >
		    		<img width="135" height="135" alt="logo" src="Wiki3.png"/>
				</div>
	    		<br/>
	    		<div id="trythis">Try This</div>
	    		<hr/>
	    		<div class="searchsamples"><a href="">SOA</a> <a href="">IR</a> </div>
	    	</dir>
	    	<br/>
	    	<div id="signin" >
	    		<p>Error!!</p>
	    	</div>
	    </div>
	    <div id="bottom" align="right">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
  </body>
</html>
