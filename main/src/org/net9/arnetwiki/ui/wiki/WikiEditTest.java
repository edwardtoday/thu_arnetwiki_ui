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
	private String generateWikiEditItem(String header, String content){
		return
			"<div id = '" + header + "' class='groupItem'>" + 
				"<div class='itemHeader'>" +
					header +
					"<a href='#' class='closeEl'>[-]</a>" +
				"</div>" +
				"<div class='itemContent'>" + 
					//注意 name=<header>
					"<textarea name='" + header +
					"'>" + content + 
					"</textarea><br>" +
				"</div>" +
			"</div>";
	}
	//输出的wiki前后不能加其它信息，如“you are reading <ID> wiki”之类的，否则会影响拖拽
	public String editTermPage()
	{
		return 	generateWikiEditItem("keyword", "test keyword") +
			generateWikiEditItem("definition", "test definition") +
			generateWikiEditItem("conferences", "test conferences") +
			generateWikiEditItem("papers", "test papers") +
			generateWikiEditItem("people", "test people") +
			generateWikiEditItem("institutions", "test institutions") +
			generateWikiEditItem("dataset", "test dataset");
	}
	public String editPeoplePage()
	{
		return 	generateWikiEditItem("keyword", "test keyword") +
			generateWikiEditItem("name", "test name") +
			generateWikiEditItem("position", "test position") +
			generateWikiEditItem("affliation", "test affliation") +
			generateWikiEditItem("address", "test address") +
			generateWikiEditItem("email", "test email") +
			generateWikiEditItem("home-page", "test home-page") +
			generateWikiEditItem("paperlist", "test paperlist");
	}
	public String editInstitutionPage()
	{
		return 	generateWikiEditItem("keyword", "test keyword") +
			generateWikiEditItem("location", "test location") +
			generateWikiEditItem("peoplelist", "test peoplelist") +
			generateWikiEditItem("paperlist", "test paperlist") +
			generateWikiEditItem("homepage", "test homepage");	
	}


	private HttpSession getHttpSession() {
		return request.getSession();
	}
	private static final String SESSION_KEY = "ArnetWiki Session";
}