
package edu.thu.soa2009.wiki;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "wikiPortType", targetNamespace = "http://soa2009.thu.edu/wiki/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface wikiPortType {

	@WebMethod(operationName = "wiki_click", action = "")
	@WebResult(name = "wiki_page", targetNamespace = "http://soa2009.thu.edu/wiki/")
	public WikiPage wiki_click(
			@WebParam(name = "wiki_click", targetNamespace = "http://soa2009.thu.edu/wiki/")
			WikiClick wiki_click);

	@WebMethod(operationName = "wiki_search", action = "")
	@WebResult(name = "wiki_ResultList", targetNamespace = "http://soa2009.thu.edu/wiki/")
	public WikiResultList wiki_search(
			@WebParam(name = "wiki_search", targetNamespace = "http://soa2009.thu.edu/wiki/")
			WikiSearch wiki_search);

	@WebMethod(operationName = "wiki_edit", action = "")
	@WebResult(name = "wiki_page", targetNamespace = "http://soa2009.thu.edu/wiki/")
	public WikiPage wiki_edit(
			@WebParam(name = "wiki_edit", targetNamespace = "http://soa2009.thu.edu/wiki/")
			WikiEdit wiki_edit);

}
