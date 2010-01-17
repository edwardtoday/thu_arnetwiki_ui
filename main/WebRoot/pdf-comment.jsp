<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@page import="org.net9.arnetwiki.ui.um.UserWebController"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<title>pdf-comment</title>
	<link rel="stylesheet" type="text/css" href="index.css">
	<script type="text/javascript" src="jquery.js"></script>
	<script type="text/javascript" src="interface.js"></script>
	<script type="text/javascript" src="main.js"></script>
	<script type="text/javascript" src="getXmlHttp.js"></script>
</head>

<body>
  	<div id="outerframe">
	    <div id="mainframe">
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
			<%String papername = request.getParameter("papername"); %>
			papername:<%=papername%><br>
			<div id="pdf-area">
				<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" width="600" height="800" align="middle">
					<param name="allowScriptAccess" value="sameDomain">
					<param name="movie" value="comment.swf"> 
					<param name="FlashVars" value="papername=<%=papername%>">
					<embed src="comment.swf" Flashvars="<%=papername%>" width=600  height=800>
				</object>
			</div>
		</div>
	    <div id="bottom">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
	</div>
</body>

</html>
