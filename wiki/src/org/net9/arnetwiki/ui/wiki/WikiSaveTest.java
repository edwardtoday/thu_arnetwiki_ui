package org.net9.arnetwiki.ui.wiki;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/*
 * @author zym
 * 
 */

public class WikiSaveTest{
	private HttpServletRequest request;
	
	public WikiSaveTest (HttpServletRequest request) {
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
	public Boolean savePage()
	{
		switch(getType())
		{
			case 1:		//term
				return saveTermPage();
			case 2:		//people
				return savePeoplePage();
			default:	//institution
				return saveInstitutionPage();
		}
	}
	public Boolean saveTermPage()
	{
		return true;
	}
	public Boolean savePeoplePage()
	{
		return true;
	}
	public Boolean saveInstitutionPage()
	{
		return true;
	}


	private HttpSession getHttpSession() {
		return request.getSession();
	}
	private static final String SESSION_KEY = "ArnetWiki Session";
}