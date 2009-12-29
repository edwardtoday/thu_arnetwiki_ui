<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="org.net9.arnetwiki.ui.wiki.WikiQueryTest"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>result-list</title>
</head>
  <body>
  	<div id="outerframe" style="padding:15px;width:600px;height:300px">
	    <div id="mainframe" style="padding:15px;border:1px solid;width:600px;height:300px">
	    	<div id="topbar" align="right"><a href="signin.jsp">Sign In</a></div>
	    	<div id="mainlogo" style="border:1px solid;width:200px;height:80px"> here is logo</div>
	    	<br/>
	    	<div id="query" align="left">
				<form method="post" action="result-list.jsp" name="searchform">
					<input type="text" name="querytext" style="width:350px"/>
					<input type="submit" value="Search!" >
				</form>
	    	</div>  
	    	<br/>
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
	    <div id="bottom" align="right">
	    	<div align="center">(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	        </div>
	    </div>
    </div>
  </body>
</html>
