<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="org.net9.arnetwiki.ui.um.UserWebController"%>
<%@page import="org.net9.arnetwiki.ui.um.xml.PersonBean"%>
<%@page import="org.net9.arnetwiki.ui.um.xml.GenericBean"%>
<%@ include file="/session.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ArnetWiki Setting</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="index.css">
	<script type="text/javascript" src="jquery.js"></script>
	<script type="text/javascript" src="interface.js"></script>
	<script type="text/javascript" src="main.js"></script>
	<script type="text/javascript" src="getXmlHttp.js"></script>
  
  </head>
  
  <body>
  	<%
  		request.setCharacterEncoding("UTF-8");
  	 %>
  	<div id="outerframe" >
	    <div id="mainframe">
	    	<div id="topbar">
	    	<a href="index.jsp">Home Page</a>|<a href="favorite.jsp">Favorite</a>|<a href="group.jsp">Group</a>|<a href="logout.jsp">Sign Out</a></div>
	    	<div id="mainlogo" >
	    		<a href="index.jsp"><img width="135" height="135" alt="logo" src="logo2.png"/></a>
			</div>
	    	<hr/>
	    	<%
	    		PersonBean pb = ses.getProfile();
	    		String tusername = "", tname="", temail="", tgender="", tbirthdate="", torganization="", ttitle="", tinterest="";
	    		if(pb.usernames.size() != 0)
	    			if(pb.usernames.iterator().next() != null)
	    				tusername = pb.usernames.iterator().next().beanName;
	    		if(pb.names.size() != 0)
	    			if(pb.names.iterator().next() != null)
	    				tname = pb.names.iterator().next().beanName;
	    		if(pb.emails.size() != 0)
	    			if(pb.emails.iterator().next() != null)
	    				temail = pb.emails.iterator().next().beanName;
	    		if(pb.genders.size() != 0)
	    			if(pb.genders.iterator().next() != null)
	    				tgender = pb.genders.iterator().next().beanName;
	    		if(pb.birthdates.size() != 0)
	    			if(pb.birthdates.iterator().next() != null)
	    				tbirthdate = pb.birthdates.iterator().next().beanName;
	    		if(pb.organizations.size() != 0)
	    			if(pb.organizations.iterator().next() != null)
	    				torganization = pb.organizations.iterator().next().beanName;
	    		if(pb.titles.size() != 0)
	    			if(pb.titles.iterator().next() != null)
	    				ttitle = pb.titles.iterator().next().beanName;
	    		if(pb.interests.size() != 0)
	    			if(pb.interests.iterator().next() != null)
	    				tinterest = pb.interests.iterator().next().beanName;
	    	 %>
	    	<form id="settingform" action="">
	    		<div>Welcome to ArnetWiki!</div>
	    		<table >
	    			<tr><td>ID</td><td><input id="id" readonly="true" value="<%=pb.id %>"/></td></tr>
	    			<tr><td>Username</td><td><input id="username" readonly="true" value="<%=tusername%>"/></td></tr>
	    			<tr><td>Name</td><td><input id="name" readonly="true" value="<%=tname%>"/></td></tr>
	    			<tr><td>Email</td><td><input id="email" readonly="true" value="<%=temail%>"/></td></tr>
	    			<tr><td>Gender</td><td><input name="gender" value="<%=tgender%>"/>male or female</td></tr>
	    			<tr><td>Birthdate</td><td><input name="birthdate" value="<%=tbirthdate%>"/>yyyy-mm-dd</td></tr>
	    			<tr><td>Organization</td><td><input id="organization" readonly="true" value="<%=torganization%>"/></td></tr>
	    			<tr><td>Title</td><td><input id="title" readonly="true" value="<%=ttitle%>"/></td></tr>
	    			<tr><td>Interests</td><td><input id="interests" readonly="true" value="<%=tinterest%>"/></td></tr>
	    		</table> 		
	    		<input id="settingsubmit" type="submit" value="Save"/>
	    		<input id="changepassword" type="button" value="Change Password" onClick="javascript:window.location='changepassword.jsp'"/>
	    	</form>
	    </div>
	    <%
	    	//tname = request.getParameter("name");
	    	//temail = request.getParameter("email");
	    	tgender = request.getParameter("gender");
	    	tbirthdate = request.getParameter("birthdate");
	    	pb.genders.clear();
	    	pb.genders.add(new GenericBean(tgender));
	    	pb.birthdates.clear();
	    	pb.birthdates.add(new GenericBean(tbirthdate));
	    	ses.updateProfile(pb);
	    	out.println("<script language='javaScript'>" +
    		"window.reload('setting.jsp');</script>");
	     %>
	    <div id="bottom">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
  </body>
</html>
