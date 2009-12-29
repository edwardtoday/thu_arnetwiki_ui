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
	public String getTermPage()
	{
		return "You are viewing term:" + getID() + 
				"<br>keyword =" + "testKeyword" +
				"<br>definition=" + "testDefinition" +
				"<br>conferences=" + "testConferences" +
				"<br>papers=" + "testPapers" +
				"<br>people=" + "testPeoples" +
				"<br>institutions=" + "testInstitutions" +
				"<br>dataset=" + "testDataset";
	}
	public String getPeoplePage()
	{
		return "You are viewing people:" + getID() + 
				"<br>keyword =" + "testKeyword" +
				"<br>name=" + "testName" +
				"<br>position=" + "testPosition" +
				"<br>affliation=" + "testAffliation" +
				"<br>address=" + "testAddress" +
				"<br>email=" + "testEmail" +
				"<br>home-page=" + "testHome-page" +
				"<br>paperlist=" + "testPaperlist";
	}
	public String getInstitutionPage()
	{
		return "You are viewing institution:" + getID() + 
				"<br>keyword =" + "testKeyword" +
				"<br>location=" + "testLocation" +
				"<br>peoplelist=" + "testPeoplelist" +
				"<br>paperlist=" + "testPaperlist";
	}


	private HttpSession getHttpSession() {
		return request.getSession();
	}
	private static final String SESSION_KEY = "ArnetWiki Session";
}