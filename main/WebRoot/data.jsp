<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="org.net9.arnetwiki.ui.css.MySql"%>
<%@ page import="java.sql.*"%>
<%!public static MySql sql = new MySql();%>
<%
	String uid = request.getParameter("uid").trim();
	sql.select("select info from wiki where id='"+uid+"'");
	while (sql.rs.next()) {
		out.println(sql.rs.getString(1));
	}
%>;