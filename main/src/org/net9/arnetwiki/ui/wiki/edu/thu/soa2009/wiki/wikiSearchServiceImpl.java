
package edu.thu.soa2009.wiki;

import javax.jws.WebService;

@WebService(serviceName = "wikiSearchService", targetNamespace = "http://soa2009.thu.edu/wiki/", endpointInterface = "edu.thu.soa2009.wiki.wikiPortType")
public class wikiSearchServiceImpl implements wikiPortType {

	public WikiPage wiki_click(WikiClick wiki_click) {
		throw new UnsupportedOperationException();
	}

	public WikiResultList wiki_search(WikiSearch wiki_search) {
		throw new UnsupportedOperationException();
	}

	public WikiPage wiki_edit(WikiEdit wiki_edit) {
		throw new UnsupportedOperationException();
	}

}
