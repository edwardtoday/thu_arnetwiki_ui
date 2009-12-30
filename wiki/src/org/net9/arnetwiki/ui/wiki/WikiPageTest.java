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
				"<br><div id = \"keyword\">keyword =" + "testKeyword" +
				"</div><div id = \"definition\"> definition=" + "testDefinition" +
				"</div><div id = \"conferences\">conferences=" + "testConferences" +
				"</div><div id = \"papers\">papers=" + "testPapers" +
				"</div><div id = \"people\">people=" + "testPeoples" +
				"</div><div id = \"institutions\">institutions=" + "testInstitutions" +
				"</div><div id = \"dataset\">dataset=" + "testDataset</div>";
	}
	public String getPeoplePage()
	{
		return "You are viewing people:" + getID() + 
				"<br><div id = keyword>keyword =" + "testKeyword" +
				"</div><div id = name>name=" + "testName" +
				"</div><div id = position>position=" + "testPosition" +
				"</div><div id = affliation>affliation=" + "testAffliation" +
				"</div><div id = address>address=" + "testAddress" +
				"</div><div id = email>email=" + "testEmail" +
				"</div><div id = home-page>home-page=" + "testHome-page" +
				"</div><div id = paperlist>paperlist=" + "testPaperlist</div>";
	}
	public String getInstitutionPage()
	{
		return "You are viewing institution:" + getID() + 
				"<br><div id = keyword>keyword =" + "testKeyword" +
				"</div><div id = location>location=" + "testLocation" +
				"</div><div id = peoplelist>peoplelist=" + "testPeoplelist" +
				"</div><div id = paperlist>paperlist=" + "testPaperlist</div>";
	}


	private HttpSession getHttpSession() {
		return request.getSession();
	}
	private static final String SESSION_KEY = "ArnetWiki Session";
}