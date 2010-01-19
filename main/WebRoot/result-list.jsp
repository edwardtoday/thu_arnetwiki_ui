<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="org.net9.arnetwiki.ui.wiki.WikiQuery"%>
<%@page import="org.net9.arnetwiki.ui.um.UserWebController"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<title>result-list</title>
	<link rel="stylesheet" type="text/css" href="index.css">
	<script type="text/javascript" src="jquery.js"></script>
	<script type="text/javascript" src="interface.js"></script>
	<script type="text/javascript" src="main.js"></script>
	<script type="text/javascript" src="getXmlHttp.js"></script>
</head>
  <body>
  	<div id="outerframe">
	    <div id="mainframe">
		<div id = "wiki-id">
		</div>
	    	<div id="topbar">
	    	<%	
	    		UserWebController controller = new UserWebController(request);
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
					WikiQuery tester = new WikiQuery(request);
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
