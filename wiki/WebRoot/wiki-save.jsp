<title>wiki-save</title>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="org.net9.arnetwiki.ui.wiki.WikiEditTest "%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	WikiEditTest tester = new WikiEditTest(request);
	tester.savePage();
%>
<jsp:forward page="wiki.jsp"></jsp:forward>