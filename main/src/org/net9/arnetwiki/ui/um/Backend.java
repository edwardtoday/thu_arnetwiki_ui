package org.net9.arnetwiki.ui.um;

import org.net9.arnetwiki.ui.um.exception.BackendConnectionException;
import org.net9.arnetwiki.ui.um.exception.ForbiddenException;
import org.net9.arnetwiki.ui.um.exception.GenericException;
import org.net9.arnetwiki.ui.um.exception.LoginFailedException;
import org.net9.arnetwiki.ui.um.exception.NotFoundException;
import org.net9.arnetwiki.ui.um.util.CredentialEncoder;
import org.net9.arnetwiki.ui.um.xml.GenericBean;
import org.net9.arnetwiki.ui.um.xml.PersonBean;
import org.net9.arnetwiki.ui.um.xml.UpdateBean;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ociweb.xml.WAX;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class Backend {
	private static final String AUTHENTICATION_HEADER = "Authorization";
	private static final String SERVICE_ROOT_URL = "http://minipie.net9.org:8088/Mini-Pie/";
	private static final String SERVICE_API_URL = SERVICE_ROOT_URL
			+ "services/";
	private Client client;
	private WebResource rootResource;
	private String credential;

	public Backend(String username, String password) {
		credential = "Basic "
				+ CredentialEncoder.encodeBasic(username, password);
		ClientConfig config = new DefaultClientConfig();
		client = Client.create(config);
		rootResource = client.resource(SERVICE_API_URL);
	}

	public static String getServiceRootUrl() {
		return SERVICE_ROOT_URL;
	}
	
	public PersonBean getProfile() throws GenericException,
			LoginFailedException {
		try {
			InputStream stream = getXml("profile");
			Document doc = new SAXReader().read(stream);
			Element ele = doc.getRootElement();
			return new PersonBean(ele);
		} catch (UniformInterfaceException e) {
			if (e.getResponse().getStatus() == 401)
				throw new LoginFailedException();
			throw new GenericException(e);
		} catch (Exception e) {
			throw new GenericException(e);
		}
	}

	// ************************************************************

	public void auth() throws LoginFailedException, GenericException {
		try {
			getXml("auth");
		} catch (UniformInterfaceException e) {
			if (e.getResponse().getStatus() == 401)
				throw new LoginFailedException();
			throw new GenericException(e);
		} catch (Exception e) {
			throw new GenericException(e);
		}
	}

	public static void testConnection() throws GenericException,
			BackendConnectionException {
		try {
			Client.create().resource(SERVICE_ROOT_URL).get(String.class);
		} catch (UniformInterfaceException e) {
			throw new GenericException(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BackendConnectionException();
		}
	}

	private InputStream getXml(String path) {
		return rootResource.path(path).accept(MediaType.APPLICATION_XML_TYPE)
				.header(AUTHENTICATION_HEADER, credential).get(
						InputStream.class);
	}
	
	private InputStream getXml(String path, String query) {
		return rootResource.path(path).queryParam("q", query).accept(MediaType.APPLICATION_XML_TYPE)
				.header(AUTHENTICATION_HEADER, credential).get(
						InputStream.class);
	}

	private void postXml(String path, String content) {
		System.out.println(content);
		rootResource.path(path).type(MediaType.APPLICATION_XML_TYPE).header(
				AUTHENTICATION_HEADER, credential).entity(content).post();
	}

	private void postForm(String path, String content) {
		System.out.println(content);
		rootResource.path(path)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).header(
						AUTHENTICATION_HEADER, credential).entity(content)
				.post();
	}

	private void putForm(String path, String content) {
		System.out.println(content);
		rootResource.path(path)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).header(
						AUTHENTICATION_HEADER, credential).entity(content)
				.put();
	}

	private void delete(String path) {
		rootResource.path(path)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).header(
						AUTHENTICATION_HEADER, credential).delete();
	}
}
