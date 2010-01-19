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

public class WikiPage {
	private HttpServletRequest request;
	String wikixml;
	public WikiPage (HttpServletRequest request) {
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
	public String showPage()
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
				return getTermPage();
			case 2:		//people
				return getPeoplePage();
			default:	//institution//"Conf"
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
	private String generateWikiLink(String header, String content){
		return
			"<div id = '" + header + "' class='groupItem'>" + 
				"<div class='itemHeader'>" +
					header +
					"<a href='#' class='closeEl'>[-]</a>" +
				"</div>" +
				"<div class='itemContent'>" + 
					"<a href='" + content + "'>" + content + "</a>" +
				"</div>" +
			"</div>";
	}
	private String generateWikiMail(String header, String content){
		return
			"<div id = '" + header + "' class='groupItem'>" + 
				"<div class='itemHeader'>" +
					header +
					"<a href='#' class='closeEl'>[-]</a>" +
				"</div>" +
				"<div class='itemContent'>" + 
					"<a href='mailto:" + content + "'>" + content + "</a>" +
				"</div>" +
			"</div>";
	}
	private String generateListStarter(String header){
		return
			"<div id = '" + header + "' class='groupItem'>" + 
				"<div class='itemHeader'>" +
					header +
					"<a href='#' class='closeEl'>[-]</a>" +
				"</div>" +
				"<div class='itemContent'>";
	}
	private String generateListContent(String content){
		return			"<a rel='external' href='result-list.jsp?querytext=" + content + "'>" +
					content + "</a><br>";
	}
	private String generatePaperContent(String content){
		return			"<a rel='external' href='pdf-comment.jsp?papername=" + content + "'>" +
					content + "</a><br>";
	}
	private String generateListEnd(){
		return		"</div>" +
			"</div>";
	}
	
	public String getTermPage()
	{
		String res = "You are viewing term:" + getID() + "<br>";
		try{
		Document document = DocumentHelper.parseText(wikixml);
		Element rootElm = document.getRootElement();
		res +=
			generateWikiItem("keyword", rootElm.element("anchor").getText()) +
			generateWikiItem("definition", rootElm.element("def").getText()) +
//			generateWikiItem("conferences", "test conferences") +
			generateListStarter("papers");
		String paperlist = rootElm.element("paperlist").getText();
		String paper[] = paperlist.split("[\"+\"]");
		for(int i=0;i<paper.length;i++)
		{
			if (paper[i].length() != 0)
				res += generatePaperContent(paper[i]);
		}
		res += generateListEnd() +
			generateListStarter("people");
		String peoplelist = rootElm.element("peoplelist").getText();
		String people[] = peoplelist.split("\\+");
		for(int i=0;i<people.length;i++)
		{
			System.out.println(people[i]);
			res += generateListContent(people[i]);
		}
		res += generateListEnd();
		res += generateWikiItem("dataset", rootElm.element("dataset").getText());
		} catch (Exception e) {
			res = e.toString();
			e.printStackTrace();
		}
		return res;
	}
	public String getPeoplePage()
	{
		String res = "You are viewing people:" + getID() + "<br>";
		try{
		Document document = DocumentHelper.parseText(wikixml);
		Element rootElm = document.getRootElement();
		res +=
			generateWikiItem("name", rootElm.element("PeopleName").getText()) +
			generateWikiItem("affliation", rootElm.element("Affiliation").getText()) +
			generateWikiItem("address", rootElm.element("Address").getText()) +
			generateWikiMail("email", rootElm.element("Email").getText()) +
			generateWikiLink("home-page", rootElm.element("Homepage").getText());
		res += generateListStarter("papers");
		
		String paperlist = rootElm.element("PaperList").getText();
		String paper[] = paperlist.split("[\"+\"]");
		for(int i=0;i<paper.length;i++)
		{
			if (paper[i].length() != 0)
				res += generatePaperContent(paper[i]);
		}
		res += generateListEnd() +
			generateListStarter("LinkPeople");
		String peoplelist = rootElm.element("LinkList").getText();
		String people[] = peoplelist.split("\\+");
		for(int i=0;i<people.length;i++)
		{
			System.out.println(people[i]);
			res += generateListContent(people[i]);
		}
		res += generateListEnd();

		} catch (Exception e) {
			res = e.toString();
			e.printStackTrace();
		}
		return res;
	}
	public String getInstitutionPage()
	{
		String res = "You are viewing Conference:" + getID() + "<br>";
		try{
		Document document = DocumentHelper.parseText(wikixml);
		Element rootElm = document.getRootElement();
		res +=
			generateWikiItem("keyword", rootElm.element("anchor").getText()) +
			generateWikiItem("location", rootElm.element("Location").getText());
		res += generateListStarter("papers");
		String paperlist = rootElm.element("paperlist").getText();
		String paper[] = paperlist.split("[\"+\"]");
		for(int i=0;i<paper.length;i++)
		{
			if (paper[i].length() != 0)
				res += generatePaperContent(paper[i]);
		}
		res += generateListEnd() +
			generateListStarter("people");
		String peoplelist = rootElm.element("peoplelist").getText();
		String people[] = peoplelist.split("\\+");
		for(int i=0;i<people.length;i++)
		{
			System.out.println(people[i]);
			res += generateListContent(people[i]);
		}
		res += generateListEnd();
		res += generateWikiLink("home-page", rootElm.element("HomePage").getText());

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