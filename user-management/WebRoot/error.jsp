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
	    		<p>Error!!</p>
	    	</div>
	    </div>
	    <div id="bottom" align="right">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
  </body>
</html>
