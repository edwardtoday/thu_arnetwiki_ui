<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>pdf-comment</title>
</head>


<body>
  	<div id="outerframe" style="margin:auto;padding:15px;width:600px;">
	    <div id="mainframe" style="margin:auto;padding:15px;border:1px solid;width:600px;">
	    	<div id="topbar" align="right"><a href="signin.jsp">Sign In</a></div>
	    	<div id="mainlogo" style="border:1px solid;width:200px;height:80px"> here is logo</div>
		<div class="wiki-id" style="display:none ">
			<%String id = request.getParameter("wiki-id"); %>
		</div>
		<div class="settingform">
			this is settingform<br>
			<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" width="600" height="800" align="middle">
				<param name="allowScriptAccess" value="sameDomain">
				<param name="movie" value="comment.swf"> 
				<param name="FlashVars" value="wiki-id=<%=id%>">
				<embed src="comment.swf" Flashvars="<%=id%>" width=600  height=800>
			</object>
		</div>
	</div>
	    <div id="bottom" align="center">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
</div>
</body>

</html>
