package org.net9.arnetwiki.ui.wiki;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.ArrayList;

import java.io.*;
import java.util.*;
import java.net.*;
import org.w3c.dom.*;
import org.apache.soap.util.xml.*;
import org.apache.soap.*;
import org.apache.soap.encoding.*;
import org.apache.soap.encoding.soapenc.*;
import org.apache.soap.rpc.*;
import org.apache.soap.transport.http.SOAPHTTPConnection;

import edu.thu.soa2009.wiki.*;

/*
 * @author zym
 * 
 */

public class WikiPage {
	private HttpServletRequest request;
	private String endpoint = "http://127.0.0.1:8088/mockwikiHttpBinding";

	public WikiPage (HttpServletRequest request) {
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
		WikiPage res;
		try {
	    		URL url = new URL (endpoint);
			SOAPMappingRegistry smr = new SOAPMappingRegistry ();
			StringDeserializer sd = new StringDeserializer ();
			smr.mapTypes (Constants.NS_URI_SOAP_ENC, new QName ("", "wiki_click"), null, null, sd);
	        // 创建传输路径和参数
			SOAPHTTPConnection st = new SOAPHTTPConnection();
	        // 创建调用
			Call call = new Call ();
			call.setSOAPTransport(st);
			call.setSOAPMappingRegistry (smr);
	
			call.setTargetObjectURI (endpoint);
			call.setMethodName("wiki_click");
			call.setEncodingStyleURI ("http://schemas.xmlsoap.org/soap/encoding/");
	
			Vector params = new Vector();
			params.addElement(new Parameter("wiki_ID", String.class, getID(), null));
			params.addElement(new Parameter("wiki_versionNo", String.class, "1", null));
			call.setParams(params);
			Response resp = null;
			try {
				resp = call.invoke (url, "wiki_click");
			}
			catch (SOAPException e) {
				System.err.println("Caught SOAPException (" + e.getFaultCode () + "): " + e.getMessage ());
				return null;
			}
	        // 检查返回值
			if (resp != null && !resp.generatedFault()) {
				Parameter ret = resp.getReturnValue();
				Object value = ret.getValue();
				System.out.println ("Answer--> " + value);
	
				edu.thu.soa2009.wiki.WikiPage wp = (edu.thu.soa2009.wiki.WikiPage)value;
				switch(getType())
				{
					case 1:		//term
						return getTermPage(wp);
					case 2:		//people
						return getPeoplePage(wp);
					default:	//institution
						return getInstitutionPage(wp);
				}
			} else {
				Fault fault = resp.getFault ();
				System.err.println ("Generated fault: ");
				System.out.println (" Fault Code = " + fault.getFaultCode());
				System.out.println (" Fault String = " + fault.getFaultString());
				return null;
			}
	
		}
		catch (Exception e) 
		{
			System.err.println(e.toString());
			e.printStackTrace();
			return null;
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
	public String getTermPage(edu.thu.soa2009.wiki.WikiPage wp)
	{
		TermPage tp = wp.getTerm();
		PeopleType people = tp.getPeople();
		InstiType institution = tp.getInsitutions();

		return "You are viewing term:" + getID() + 
			"<br>" +
			generateWikiItem("keyword", "test keyword") +
			generateWikiItem("definition", tp.getDef()) +
			generateWikiItem("conferences", "test conferences") +
			generateWikiItem("papers", tp.getPapers()) +
			generateWikiItem("people", people.getName()) +
			generateWikiItem("institutions", institution.getLocation()) +
			generateWikiItem("dataset", tp.getDataset());
	}
	public String getPeoplePage(edu.thu.soa2009.wiki.WikiPage wp)
	{
		PeopleType pt = wp.getPeople().getPeopleList();

		return "You are viewing people:" + getID() + 
			"<br>" +
			generateWikiItem("keyword", "test keyword") +
			generateWikiItem("name", pt.getName()) +
			generateWikiItem("position", pt.getPosition()) +
			generateWikiItem("affliation", "test affliation") +
			generateWikiItem("address", pt.getAddress()) +
			generateWikiItem("email", pt.getEmail()) +
			generateWikiItem("home-page", pt.getHomePage()) +
			generateWikiItem("paperlist", pt.getPaperlist());
	}
	public String getInstitutionPage(edu.thu.soa2009.wiki.WikiPage wp)
	{
		InstiType it = wp.getInsti().getInstiList();
		return "You are viewing institution:" + getID() + 
			"<br>" +
			generateWikiItem("keyword", "test keyword") +
			generateWikiItem("location", it.getLocation()) +
			generateWikiItem("peoplelist", it.getPeoplelist()) +
			generateWikiItem("paperlist", it.getPaperlist()) +
			generateWikiItem("homepage", it.getHomepage());			
	}


	private HttpSession getHttpSession() {
		return request.getSession();
	}
	private static final String SESSION_KEY = "ArnetWiki Session";
}