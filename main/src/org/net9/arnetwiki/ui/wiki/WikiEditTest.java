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
	private String generateWikiItem(String header, String content){
		return
			"<div id = '" + header + "' class='groupItem'>" + 
				"<div class='itemHeader'>" +
					header +
					"<a href='#' class='closeEl'>[-]</a>" +
				"</div>" +
				"<div class='itemContent'>" + 
					"<textarea name='" + header + "'>" + content + "</textarea>" + 
				"</div>" +
			"</div>";
		
	}
	public String editTermPage()
	{
		return 
			generateWikiItem("keyword", "test keyword") +
			generateWikiItem("definition", "test definition") +
			generateWikiItem("conferences", "test conferences") +
			generateWikiItem("papers", "test papers") +
			generateWikiItem("people", "test people") +
			generateWikiItem("institutions", "test institutions") +
			generateWikiItem("dataset", "test dataset");
	}
	public String editPeoplePage()
	{
		return 
			generateWikiItem("keyword", "test keyword") +
			generateWikiItem("name", "test name") +
			generateWikiItem("position", "test position") +
			generateWikiItem("affliation", "test affliation") +
			generateWikiItem("address", "test address") +
			generateWikiItem("email", "test email") +
			generateWikiItem("home-page", "test home-page") +
			generateWikiItem("paperlist", "test paperlist");
	}
	public String editInstitutionPage()
	{
		return 
			generateWikiItem("keyword", "test keyword") +
			generateWikiItem("location", "test location") +
			generateWikiItem("peoplelist", "test peoplelist") +
			generateWikiItem("paperlist", "test paperlist") +
			generateWikiItem("homepage", "test homepage");	
	}


	private HttpSession getHttpSession() {
		return request.getSession();
	}
	private static final String SESSION_KEY = "ArnetWiki Session";
}