package org.net9.arnetwiki.ui.wiki;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;

import java.io.*;
import java.util.*;
import java.net.*;

import org.codehaus.xfire.client.Client;   
import org.apache.ws.commons.schema.resolver.*;

import org.wikigroup.WikiService.WikiServiceLocator;
import org.wikigroup.WikiService.WikiServicePortType;

import org.dom4j.*;
import org.dom4j.io.*; 



/*
 * @author zym
 * 
 */

public class WikiEdit{
	private HttpServletRequest request;
	private String wikixml;
	
	public WikiEdit (HttpServletRequest request) {
		this.request = request;
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
		try {
			WikiServicePortType service = new WikiServiceLocator()
					.getWikiServiceHttpPort();
			wikixml = service.getWikiPage(getID());
		} catch (Exception e) {
			e.printStackTrace();
		}
		switch(getType())
		{
			case 1:		//term
				return editTermPage();
			case 2:		//people
				return editPeoplePage();
			default:	//institution//"Conf"
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
					"<textarea name='" + content +
					"'>" + content + 
					"</textarea><br>" +
				"</div>" +
			"</div>";
	}
	public String editTermPage()
	{
		String res = "";
		try{
		Document document = DocumentHelper.parseText(wikixml);
		Element rootElm = document.getRootElement();
		res +=
			generateWikiEditItem("keyword", rootElm.element("anchor").getText()) +
			generateWikiEditItem("definition", rootElm.element("def").getText()) +
			generateWikiEditItem("papers", rootElm.element("paperlist").getText()) +
			generateWikiEditItem("peoples", rootElm.element("peoplelist").getText()) +
			generateWikiEditItem("dataset", rootElm.element("dataset").getText());
		} catch (Exception e) {
			res = e.toString();
			e.printStackTrace();
		}
		return res;
	}
	public String editPeoplePage()
	{
		String res = "";
		try{
		Document document = DocumentHelper.parseText(wikixml);
		Element rootElm = document.getRootElement();
		res +=
			generateWikiEditItem("name", rootElm.element("PeopleName").getText()) +
			generateWikiEditItem("affliation", rootElm.element("Affiliation").getText()) +
			generateWikiEditItem("address", rootElm.element("Address").getText()) +
			generateWikiEditItem("email", rootElm.element("Email").getText()) +
			generateWikiEditItem("home-page", rootElm.element("Homepage").getText()) +
			generateWikiEditItem("papers", rootElm.element("paperlist").getText()) +
			generateWikiEditItem("LinkPeople", rootElm.element("LinkList").getText());
		} catch (Exception e) {
			res = e.toString();
			e.printStackTrace();
		}
		return res;
	}
	public String editInstitutionPage()
	{
		String res = "";
		try{
		Document document = DocumentHelper.parseText(wikixml);
		Element rootElm = document.getRootElement();
		res +=
			generateWikiEditItem("keyword", rootElm.element("anchor").getText()) +
			generateWikiEditItem("location", rootElm.element("Location").getText()) +
			generateWikiEditItem("papers", rootElm.element("paperlist").getText()) +
			generateWikiEditItem("people", rootElm.element("peoplelist").getText()) +
			generateWikiEditItem("home-page", rootElm.element("Homepage").getText());
		} catch (Exception e) {
			res = e.toString();
			e.printStackTrace();
		}
		return res;
	}


	private HttpSession getHttpSession() {
		return request.getSession();
	}
	private static final String SESSION_KEY = "ArnetWiki Session";
}