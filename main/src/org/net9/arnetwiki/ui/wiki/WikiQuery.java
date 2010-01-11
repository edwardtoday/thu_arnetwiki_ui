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

public class WikiQuery{
	private HttpServletRequest request;
			
	private String endpoint = "http://127.0.0.1:8088/mockwikiHttpBinding";
	public WikiQuery(HttpServletRequest request) {
		this.request = request;
	}
	public String test()
	{
		return "testSuccess";
	}
	public List<String> query (String text)
	{
		List<String>res = new ArrayList<String>();
	try {
    		URL url = new URL (endpoint );
		SOAPMappingRegistry smr = new SOAPMappingRegistry ();
		StringDeserializer sd = new StringDeserializer ();
		smr.mapTypes (Constants.NS_URI_SOAP_ENC, new QName ("", "wiki_search"), null, null, sd);
        // 创建传输路径和参数
		SOAPHTTPConnection st = new SOAPHTTPConnection();
        // 创建调用
		Call call = new Call ();
		call.setSOAPTransport(st);
		call.setSOAPMappingRegistry (smr);

		call.setTargetObjectURI (endpoint);
		call.setMethodName("wiki_search");
		call.setEncodingStyleURI ("http://schemas.xmlsoap.org/soap/encoding/");

		Vector params = new Vector();
		params.addElement(new Parameter("userquery", String.class, request.getParameter("querytext"), null));
		params.addElement(new Parameter("password", String.class, "soa2009", null));
		call.setParams(params);
		Response resp = null;
		try {
			resp = call.invoke (url, "wiki_search");
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
			WikiResultList wrl = (WikiResultList)value;
			for (WikiResultList.ReturnedList a: wrl.getReturnedList())
			{
				res.add("<a href=\"wiki.jsp?style=" + a.getWikiHit() +
					"&wiki-id=" + a.getWikiID() +"\">" + a.getWikiURL() + "</a>");
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
	}

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