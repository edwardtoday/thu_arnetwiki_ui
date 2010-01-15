<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ include file="/session.jsp"%>
<%@page import="org.net9.arnetwiki.ui.um.UserWebController"%>
<%@page import="org.net9.arnetwiki.ui.um.exception.LoginFailedException"%>
<%@page import="org.net9.arnetwiki.ui.um.exception.GenericException"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ArnetWiki Group</title>
    
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
  		String method = request.getParameter("method");
  		//UserWebController controller = new UserWebController(request);
  	 %>
  	<div id="outerframe" >
	    <div id="mainframe" >
	    	<div id="topbar">
	    	<%	
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
	    	<div id="mygroup" >
	    		<% ArrayList<String> mygroups = ses.listGroups();
	    		 %>
	    		<table id="mygrouptable">
	    			<% for(String groupid : mygroups) {
	    			%> 
	    			<tr>
	    				<td><a href=""><%=groupid %></a></td>
	    				<td><form name="removegroup" method="post">
							<input type="hidden" name="method" id="method" value="removegroup"/>
							<input type="hidden" name="groupid" value="<%=groupid%>"/>
							<input type="submit" value="Quit"/>
							</form>
						</td>
	    			</tr>
	    			<% }
	    			 %>	
	    		</table>
	    		<%
	    			if (method != null && method.equals("removegroup")) {
						String removegroupid = request.getParameter("groupid");
						try {
							ses.quitGroup(removegroupid);
						} catch (LoginFailedException e) {
					%>
							<p>You may not have logged in.</p> <%
						} catch (GenericException e) {
						%>
							<p>An internal error occurred. </p>
						<% 
						}
					}
	    		 %>
	    	</div>
	    	<div id="searchgroup" >
	    		<input type="text" name="querytext"/>
	    		<input type="button" id="searchgroupbutton" value="Search!!" onclick=""/>
	    		<div id="searchgroupresult" ></div>
	    	</div>
	    	<div id="creategroup" >
		    	<div class="items">
					<div class="header">Create Group</div>
					<div class="content">
						<form name="creategroup" method="post">
							<input type="text" name="createtext"/>
							<input type="submit" value="Create"/>
						</form>
				<%	String creategroupid = request.getParameter("createtext");	 
					if (method != null && creategroupid != null
					&& !creategroupid.isEmpty() && method.equals("creategroup")) {
						try {
							ses.createGroup(creategroupid);
						} catch (LoginFailedException e) {
					%>
							<p>You may not have logged in.</p> <%
						} catch (GenericException e) {
						%>
							<p>An internal error occurred. </p>
						<% 
						}
					}
				%></div>
				</div>
			</div>
	    </div>
	    <div id="bottom">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
  </body>
</html>
