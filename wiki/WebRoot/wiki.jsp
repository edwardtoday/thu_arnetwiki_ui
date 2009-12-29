<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="org.net9.arnetwiki.ui.wiki.WikiPageTest "%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>wikipage</title>
</head>

<body>
  	<div id="outerframe" style="padding:15px;width:600px;">
	    <div id="mainframe" style="padding:15px;border:1px solid;width:600px;">
	    	<div id="topbar" align="right"><a href="signin.jsp">Sign In</a></div>
	    	<div id="mainlogo" style="border:1px solid;width:200px;height:80px"> here is logo</div>
		<div class="wiki-id" style="display:none ">
			<%String id = request.getParameter("wiki-id"); %>
		</div>
		<div class="wiki-type" style="display:none ">  
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
	    <div id="bottom" align="center">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
</div>
</body>
</html>
