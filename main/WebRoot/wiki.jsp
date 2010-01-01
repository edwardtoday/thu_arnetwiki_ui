<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="org.net9.arnetwiki.ui.wiki.WikiPageTest "%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<title>wikipage</title>
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
	    	<div id="navegation">
	    		<ul lang="en" xml:lang="en">
	    			<% String wikiType = request.getParameter("style");
	    				if(wikiType == null)wikiType = "";
	    			%>
					<li <%= wikiType.equals("1")? "class='selected'" : ""%>><a href="">Term</a></li>
					<li <%= wikiType.equals("2")? "class='selected'" : ""%>><a href="">People</a></li>
					<li <%= wikiType.equals("3")? "class='selected'" : ""%>><a href="">Role</a></li>
				</ul>
			</div>
	    	<div id='wiki-content'class="groupWrapper">	    	
				<div id="wiki-id" style="display:none">
					<%String id = request.getParameter("wiki-id"); %>
					<%= id==null ? "" : id %>
				</div>
				<div id="wiki-type" style="display:none">  
					<% String style = request.getParameter("style"); int type; %>
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
						WikiPageTest tester = new WikiPageTest(request);
						out.println(tester.showPage());
				%>
						<br><a href="wiki-edit.jsp?style=<%=style%>&wiki-id=<%=id%>">Edit</a>
						<br><a href="pdf-comment.jsp?style=<%=style%>&wiki-id=<%=id%>">ViewPdf</a>
				<%
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
