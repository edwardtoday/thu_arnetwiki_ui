<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="org.net9.arnetwiki.ui.wiki.WikiPage "%>
<%@page import="org.net9.arnetwiki.ui.um.UserWebController"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<title>wikipage</title>
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
			<%String id = request.getParameter("wiki-id"); %>
			<% String style = request.getParameter("style"); int type; %>
	    	<div id="navegation">
	    		<ul lang="en" xml:lang="en">
					<li class='selected'><a href="wiki.jsp?style=<%=style%>&wiki-id=<%=id%>">View</a></li>
					<li><a href="wiki-edit.jsp?style=<%=style%>&wiki-id=<%=id%>">Edit</a></li>
				</ul>
			</div>
	    	<div id='wiki-content'class="groupWrapper">	    
				<!-- wiki-id和wiki-type这两个div是给拖拽js传递信息的，不应显示	-->
				<div id="wiki-id" style="display:none">					
					<%= id==null ? "" : id %>
				</div>
				<div id="wiki-type" style="display:none">					
					<%= style==null ? "" : style %>
				</div>
				<%
					if (id == null || id.isEmpty() || style == null || style.isEmpty())
					{
						out.print("NULL ID or style<br>");
					}
					else
					{
						type = Integer.parseInt(style);
						WikiPage tester = new WikiPage(request);
						out.println(tester.showPage());
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
