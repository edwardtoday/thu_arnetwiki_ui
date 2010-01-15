<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="org.net9.arnetwiki.ui.um.UserWebController"%>
<%@page import="org.net9.arnetwiki.ui.um.exception.LoginFailedException"%>
<%@page import="org.net9.arnetwiki.ui.um.exception.GenericException"%>
<%@ include file="/session.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ArnetWiki Favorite</title>
    
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
	    	<div id="myfavorite" >
	    		<% Map<String, ArrayList<String>> myfavorites = ses.getFavorites();
	    		 %>
	    		<table id="myfavoritetable">
	    			<tr>
	    				<td>PDF</td>
	    			</tr>
	    			<% ArrayList<String> pdfs = myfavorites.get("pdf");
	    				for(String pdfid : pdfs) {
	    			 %>
	    			<tr>
	    				<td><a href=""><%=pdfid %></a></td>
	    				<td><form name="removepdf" method="post">
							<input type="hidden" name="method" id="method" value="removepdf"/>
							<input type="hidden" name="pdfid" value="<%=pdfid%>"/>
							<input type="submit" value="Quit"/>
							</form>
						</td>
	    			</tr>
	    			<% } %>
	    			<tr>
	    				<td>WikiPage</td>
	    			</tr>
	    			<% 
	    				ArrayList<String> wikipages = myfavorites.get("wikipage");
	    				for(String wikiid : wikipages) {
	    			 %>
	    			<tr>
	    				<td><a href=""><%=wikiid %></a></td>
	    				<td><form name="removewiki" method="post">
							<input type="hidden" name="method" id="method" value="removewiki"/>
							<input type="hidden" name="wikiid" value="<%=wikiid%>"/>
							<input type="submit" value="Quit"/>
							</form>
						</td>
	    			</tr>
	    			<%
	    			 } %>
	    		</table>
	    		<%
	    			if (method != null && method.equals("removepdf")) {
						String removepdfid = request.getParameter("pdfid");
						try {
							ses.deletePdfFavorite(removepdfid);
						} catch (LoginFailedException e) {
					%>
							<p>You may not have logged in.</p> <%
						} catch (GenericException e) {
						%>
							<p>An internal error occurred. </p>
						<% 
						}
					}
					if (method != null && method.equals("removewiki")) {
						String removewikiid = request.getParameter("wikiid");
						try {
							ses.deleteWikiFavorite(removewikiid);
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
	    </div>
	    <div id="bottom">
	    	(c) ArnetWiki  <a href="">About</a> <a href="">Contact</a> <a href="">Help</a>
	    </div>
    </div>
  </body>
</html>
