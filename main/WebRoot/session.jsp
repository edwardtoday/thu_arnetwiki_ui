
<%@page import="org.net9.arnetwiki.ui.um.Backend"%>
<%@page import="org.net9.arnetwiki.ui.um.UserWebController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	UserWebController controller = new UserWebController(request);
	//System.out.println(request.getRequestURL());
	//System.out.println(request.getRequestURI());
	//System.out.println(request.getQueryString());
	String cont = request.getRequestURI();
	if (request.getQueryString() != null)
		cont += "?" + request.getQueryString(); 
	try {
		if (!controller.isLoggedIn()) {
			response.sendRedirect(request.getContextPath() + "/signin.jsp?continue=" + cont);
			return;
		}
	} catch (Exception e) {
		e.printStackTrace();
		response.sendRedirect(request.getContextPath() + "/error.jsp");
		return;
	}
	Backend ses = controller.getSession();
%>
