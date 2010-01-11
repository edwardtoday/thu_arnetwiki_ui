<title>wiki-save</title>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="org.net9.arnetwiki.ui.wiki.WikiSaveTest "%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	WikiSaveTest tester = new WikiSaveTest(request);
	tester.savePage();
	//用jsp:forward转向时，浏览器的地址栏不变化，用户再刷新时会有问题。所以改用sendRedirect。
	response.sendRedirect("wiki.jsp?"+request.getQueryString());
%>