<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>wiki-edit</title>
</head>

<body>
  	<div id="outerframe" style="padding:15px;width:600px;">
	    <div id="mainframe" style="padding:15px;border:1px solid;width:600px;">
	    	<div id="topbar" align="right"><a href="signin.jsp">Sign In</a></div>
	    	<div id="mainlogo" style="border:1px solid;width:200px;height:80px"> here is logo</div>

		<div class="wiki-id" style="display:none ">  <%String id = request.getParameter("wiki-id");%></div>
		<div class="wiki-type" style="display:none ">  <% String style = request.getParameter("style"); int type;%></div>
		<%
			if (id == null || id.isEmpty() || style == null || style.isEmpty())
			{
				out.print("NULL ID or style<br>");
			}else{
				type = Integer.parseInt(style);
				switch(type)
				{
					case 1:		//term
						%>
					<form method="post" action="wiki-save.jsp" name="saveform">
						<input type="text" name="wiki-id" value="<%=id%>" ><br>
						<input type="text" name="style" value="<%=style%>" ><br>
						<textarea name="keyword">keyword</textarea><br>
						<textarea name="definition">definition</textarea><br>
						<textarea name="conferences">conferences</textarea><br>
						<textarea name="papers">papers</textarea><br>
						<textarea name="people">people</textarea><br>
						<textarea name="institutions">institutions</textarea><br>
						<textarea name="dataset">dataset</textarea><br>
						<input type="submit" value="提交" >
						<input type="reset" value="重置"><br>
					</form>
						<%
						break;
					case 2:		//people
						%>
					<form method="post" action="wiki-save.jsp" name="saveform">
						<input type="text" name="wiki-id" value="<%=id%>" ><br>
						<input type="text" name="style" value="<%=style%>" ><br>
						<textarea name="keyword">keyword</textarea><br>
						<textarea name="name">name</textarea><br>
						<textarea name="position">position</textarea><br>
						<textarea name="affliation">affliation</textarea><br>
						<textarea name="address">address</textarea><br>
						<textarea name="email">email</textarea><br>
						<textarea name="home-page">home-page</textarea><br>
						<textarea name="paperlist">paperlist</textarea><br>
						<input type="submit" value="提交" >
						<input type="reset" value="重置"><br>
					</form>
						<%
						break;
					case 3:		//institution
						%>
					<form method="post" action="wiki-save.jsp" name="saveform">
						<input type="text" name="wiki-id" value="<%=id%>" ><br>
						<input type="text" name="style" value="<%=style%>" ><br>
						<textarea name="keyword">keyword</textarea><br>
						<textarea name="location">location</textarea><br>
						<textarea name="peoplelist">peoplelist</textarea><br>
						<textarea name="paperlist">paperlist</textarea><br>
						<textarea name="homepage">homepage</textarea><br>
						<input type="submit" value="提交" >
						<input type="reset" value="重置"><br>
					</form>
						<%
						break;
				}
			}
		%>

	</div>
	    <div id="bottom" align="center">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
</div>
</body>
</html>
