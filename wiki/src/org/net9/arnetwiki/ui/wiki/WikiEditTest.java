package org.net9.arnetwiki.ui.wiki;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/*
 * @author zym
 * 
 */

public class WikiEditTest{
	private HttpServletRequest request;
	
	public WikiEditTest (HttpServletRequest request) {
		this.request = request;
	}
	public String test()
	{
		return "Test Success";
	}
	public String getID()
	{
		return request.getParameter("wiki-id");
	}
	public int getType()
	{
		return Integer.parseInt(request.getParameter("style"));
	}
	public String getEditPage()
	{
		switch(getType())
		{
			case 1:		//term
				return editTermPage();
			case 2:		//people
				return editPeoplePage();
			default:	//institution
				return editInstitutionPage();
		}
	}
	public String editTermPage()
	{
		return "<div id=\"keyword\"><textarea name=\"keyword\">keyword</textarea><br></div>" +
			"<div id=\"definition\"><textarea name=\"definition\">definition</textarea><br></div>" +
			"<div id=\"conferences\"><textarea name=\"conferences\">conferences</textarea><br></div>" + 
			"<div id=\"papers\"><textarea name=\"papers\">papers</textarea><br></div>" +
			"<div id=\"people\"><textarea name=\"people\">people</textarea><br></div>" +
			"<div id=\"institutions\"><textarea name=\"institutions\">institutions</textarea><br></div>" +
			"<div id=\"dataset\"><textarea name=\"dataset\">dataset</textarea><br></div>";
	}
	public String editPeoplePage()
	{
		return "<div id=\"keyword\"><textarea name=\"keyword\">keyword</textarea><br></div>" + 
			"<div id=\"name\"><textarea name=\"name\">name</textarea><br></div>" +
			"<div id=\"position\"><textarea name=\"position\">position</textarea><br></div>" +
			"<div id=\"affliation\"><textarea name=\"affliation\">affliation</textarea><br></div>" +
			"<div id=\"address\"><textarea name=\"address\">address</textarea><br></div>" +
			"<div id=\"email\"><textarea name=\"email\">email</textarea><br></div>" +
			"<div id=\"home-page\"><textarea name=\"home-page\">home-page</textarea><br></div>" +
			"<div id=\"paperlist\"><textarea name=\"paperlist\">paperlist</textarea><br></div>";
	}
	public String editInstitutionPage()
	{
		return "<div id=\"keyword\"><textarea name=\"keyword\">keyword</textarea><br></div>" +
			"<div id=\"location\"><textarea name=\"location\">location</textarea><br></div>" +
			"<div id=\"peoplelist\"><textarea name=\"peoplelist\">peoplelist</textarea><br></div>" +
			"<div id=\"paperlist\"><textarea name=\"paperlist\">paperlist</textarea><br></div>" +
			"<div id=\"homepage\"><textarea name=\"homepage\">homepage</textarea><br></div>";
	}


	private HttpSession getHttpSession() {
		return request.getSession();
	}
	private static final String SESSION_KEY = "ArnetWiki Session";
}