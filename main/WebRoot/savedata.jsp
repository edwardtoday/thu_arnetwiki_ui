<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="org.net9.arnetwiki.ui.css.MySql"%>
<%@ page import="java.sql.*"%>
<%!public static MySql sql = new MySql();%>
<%
	String uid = request.getParameter("uid").trim();
	String info = request.getParameter("info").trim(); 
	sql.select("select info from wiki where id='"+uid+"'");
	if(sql.rs.next()){
		sql.update("update wiki set info='"+info+"' where id='"+uid+"'");
	}
	else{
		sql.insert(String.format("insert into wiki values('%s','%s')", uid, info));
	}
	out.println("update succeed!");
%>;