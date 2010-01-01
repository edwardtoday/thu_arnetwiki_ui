<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="org.net9.arnetwiki.ui.wiki.WikiPageTest "%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>wikipage</title>
</head>

<body>
  	<div id="outerframe">
	    <div id="mainframe">
	    	<div id="topbar"><a href="signin.jsp">Sign In</a></div>
	    	<div id="mainlogo"> here is logo</div>
		<div id="wiki-id">
			<%String id = request.getParameter("wiki-id"); %>
		</div>
		<div id="wiki-type">  
			<% String style = request.getParameter("style"); int type; %>
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
	    <div id="bottom">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
</div>
</body>
</html>
