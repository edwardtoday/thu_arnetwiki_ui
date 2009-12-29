package org.net9.arnetwiki.ui.wiki;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;

/*
 * @author zym
 * 
 */

public class WikiQueryTest{
	private HttpServletRequest request;
	
	public WikiQueryTest(HttpServletRequest request) {
		this.request = request;
	}
	public String test()
	{
		return "testSuccess";
	}
	public List<String> query(String text)
	{
		List<String>res = new ArrayList<String>();
		res.add("<a href=\"wiki.jsp?style=1&wiki-id=11111\">wikipage</a>");
		res.add("<a href=\"wiki.jsp?style=2&wiki-id=22222\">wikipage</a>");
		res.add("<a href=\"wiki.jsp?style=3&wiki-id=33333\">wikipage</a>");
		return res;		
	}
	public String show()
	{
		List<String> queryResult = query(request.getParameter("querytext"));
		String t="";
		for (String s:queryResult)
		{
			t += s + "<br>";
		}
		return t;
	}

	private HttpSession getHttpSession() {
		return request.getSession();
	}
	private static final String SESSION_KEY = "ArnetWiki Session";
}