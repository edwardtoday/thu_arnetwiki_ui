package org.net9.arnetwiki.ui.wiki;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/*
 * @author zym
 * 
 */

public class WikiPageTest {
	private HttpServletRequest request;
	
	public WikiPageTest (HttpServletRequest request) {
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
	public String showPage()
	{
		switch(getType())
		{
			case 1:		//term
				return getTermPage();
			case 2:		//people
				return getPeoplePage();
			default:	//institution
				return getInstitutionPage();
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
					content +
				"</div>" +
			"</div>";
	}
	//输出的wiki前后不能加其它信息，如“you are reading <ID> wiki”之类的，否则会影响拖拽
	public String getTermPage()
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
	public String getPeoplePage()
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
	public String getInstitutionPage()
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