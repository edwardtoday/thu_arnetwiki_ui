<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="org.net9.arnetwiki.ui.wiki.WikiQueryTest"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<title>result-list</title>
	<link rel="stylesheet" type="text/css" href="index.css">
	<script type="text/javascript" src="jquery.js"></script>
	<script type="text/javascript" src="interface.js"></script>
	<script type="text/javascript" src="main.js"></script>
</head>
  <body>
  	<div id="outerframe">
	    <div id="mainframe">
	    	<div id="topbar"><a href="signin.jsp">Sign In</a></div>
	    	<div id="mainlogo" >
	    		<img width="135" height="135" alt="logo" src="Wiki3.png"/>
			</div>
	    	<br/>
	    	<div id="query">
				<form method="post" action="result-list.jsp" name="searchform">
					<input type="text" name="querytext"/>
					<input type="submit" value="Search!" >
				</form>
	    	</div>  
	    	<br/>
			<div id="result-list">
			<% 
				String querytext = request.getParameter("querytext");
				if (querytext == null || querytext.isEmpty())
					out.print("NULL querytext");
				else
				{
					out.print("querytext:"+querytext+"<br>");
					WikiQueryTest tester = new WikiQueryTest(request);
					out.println(tester.show());
				}
			%>
			</div>
	    </div>
	    <div id="bottom">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
  </body>
</html>
