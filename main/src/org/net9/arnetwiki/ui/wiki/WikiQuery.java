package org.net9.arnetwiki.ui.wiki;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;

import java.io.*;
import java.util.*;
import java.net.*;
import org.w3c.dom.*;
import org.codehaus.xfire.client.Client;   
import org.apache.ws.commons.schema.resolver.*;

import org.wikigroup.WikiService.WikiServiceLocator;
import org.wikigroup.WikiService.WikiServicePortType;

/*
 * @author zym
 * 
 */

public class WikiQuery{
	private HttpServletRequest request;

	public WikiQuery(HttpServletRequest request) {
		this.request = request;
	}
	public List<String> query (String text)
	{
		List<String>res = new ArrayList<String>();

		try {
			WikiServicePortType service = new WikiServiceLocator()
					.getWikiServiceHttpPort();
			res = service.wikiSearch(text, "123456");
//			service.getWikiPage(new String("100"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;		
	}
	public String show()
	{
		List<String> queryResult = query(request.getParameter("querytext"));
		
		String t="";
		for (String s:queryResult)
		{
			String id = s.substring(4, s.indexOf('[',4));
			int pos = s.indexOf("type");
			String type = s.substring(pos + 5, s.indexOf('[',pos));
			if (type.equals("Term"))
				pos = 1;
			else if(type.equals("People"))
				pos = 2;
			else //"Conf"
				pos = 3;
			t += "<a href = wiki.jsp?wiki-id=" + id + "&style=" + pos + ">" + s + "</a><br>";
		}
		return t;
	}

	private HttpSession getHttpSession() {
		return request.getSession();
	}
	private static final String SESSION_KEY = "ArnetWiki Session";
}