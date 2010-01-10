<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="org.net9.arnetwiki.ui.css.MySql"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.0 transitional//EN">
<html>
<head>
	<title>TestJSP</title>
	<meta http-equiv=Content-Type content="text/html;charset=UTF-8">
	<%!public static MySql sql = new MySql();%>
	<script>
	function fun(){
		var info="<%
		sql.select("select * from wiki");
		ResultSetMetaData meta = sql.rs.getMetaData();
		while (sql.rs.next()) {
			for (int i_col = 1; i_col <= meta.getColumnCount(); i_col++) {
				%><%= sql.rs.getString(i_col) + "  "%><%
			}
			%><br\><%
		}
		%>";
		var temp = document.getElementById("content").innerHTML;
		document.getElementById("content").innerHTML = temp+info+"<br\>";
	}
	</script>
</head>
<body>
<button onclick=fun()>Select</button>
<div id="content">

</div>
</body>
</html>
