package edu.thu.soa2009.wiki;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/*
 * @author zym
 * 
 */

public class WikiTest {
	private HttpServletRequest request;
	public WikiTest () {
	}
	public WikiTest (HttpServletRequest request) {
		this.request = request;
	}

	public String getID()
	{
		return "testID";
	}

	private HttpSession getHttpSession() {
		return request.getSession();
	}
	private static final String SESSION_KEY = "ArnetWiki Session";
}