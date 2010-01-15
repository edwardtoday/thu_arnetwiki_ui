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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ociweb.xml.Version;
import com.ociweb.xml.WAX;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class Backend {
	private static final String AUTHENTICATION_HEADER = "Authorization";
	private static final String SERVICE_ROOT_URL = "http://minipie.net9.org/ArnetPie/";
	private static final String SERVICE_API_URL = "http://minipie.net9.org/ArnetPie/resources/";
	private Client client;
	private WebResource rootResource;
	private String credential;
	private ClientResponse response;

	public Backend(String username, String password) {
		credential = "Basic "
				+ CredentialEncoder.encodeBasic(username, password);
		ClientConfig config = new DefaultClientConfig();
		client = Client.create(config);
		rootResource = client.resource(SERVICE_API_URL);
	}
	
	/**
	 * Sign up
	 * @param username
	 * @param password
	 * @param email
	 * @return
	 * @throws GenericException
	 * @throws NotFoundException
	 */
	public String signup(String username, String password, String email) 
		throws GenericException, NotFoundException {
		try {
			String entitycontent = "username=" + username + "&email=" + email + "&password=" + password;
			response = rootResource.path("users").entity(entitycontent).post(ClientResponse.class);
			return response.getEntity(String.class);
		} catch (UniformInterfaceException e) {
			if (e.getResponse().getStatus() == 404)
				throw new NotFoundException();
			throw new GenericException(e);
		} catch (Exception e) {
			throw new GenericException(e);
		}
	}
	
	public void changePassword(String password) throws GenericException, 
				NotFoundException {
		try {
			putForm("password", "password=" + password);
		} catch (UniformInterfaceException e) {
			if (e.getResponse().getStatus() == 404)
				throw new NotFoundException();
			throw new GenericException(e);
		} catch (Exception e) {
			throw new GenericException(e);
		}
	}
	
	/**
	 * getProfile
	 * @return
	 * @throws GenericException
	 * @throws LoginFailedException
	 */
	public PersonBean getProfile() throws GenericException,
			LoginFailedException {
		try {
			InputStream stream = getXml("users/myself");
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
	
	/**
	 * updateProfile
	 * @param updatebean
	 * @throws LoginFailedException
	 * @throws GenericException
	 * @throws NotFoundException
	 */
	public void updateProfile(PersonBean updatebean) throws LoginFailedException,
			GenericException, NotFoundException {
		try {
			StringWriter writer = new StringWriter();
			WAX wax = new WAX(writer, Version.V1_0);
			updatebean.toXML(wax);
			wax.close();
			rootResource.path("users/myself")
				.type(MediaType.APPLICATION_XML_TYPE).header(
				AUTHENTICATION_HEADER, credential).entity(writer.toString())
				.put();
		} catch (UniformInterfaceException e) {
			if (e.getResponse().getStatus() == 401)
				throw new LoginFailedException();
			if (e.getResponse().getStatus() == 404)
				throw new NotFoundException();
			throw new GenericException(e);
		}
	}
	
	/**
	 * addPdfFavorite
	 * @param id
	 * @throws GenericException
	 * @throws LoginFailedException
	 */
	public void addPdfFavorite(String id) throws GenericException,
		LoginFailedException {
		try {
			response = rootResource.path("collection/pdfs")
			.header(AUTHENTICATION_HEADER, credential).entity("pdfid=" + id)
			.post(ClientResponse.class);
		} catch (UniformInterfaceException e) {
			if(e.getResponse().getStatus() == 401)
				throw new LoginFailedException();
			throw new GenericException(e);
		}
	}
	
	/**
	 * deletePdfFavorite
	 * @param id
	 * @throws GenericException
	 * @throws LoginFailedException
	 */
	public void deletePdfFavorite(String id) throws GenericException,
			LoginFailedException {
		try {
			response = rootResource.path("collection/pdfs/" + id).header(
					AUTHENTICATION_HEADER, credential)
					.delete(ClientResponse.class);
		} catch (UniformInterfaceException e) {
			if (e.getResponse().getStatus() == 401)
				throw new LoginFailedException();
			throw new GenericException(e);
		}
	}
	
	/**
	 * addWikiFavorite
	 * @param id
	 * @throws GenericException
	 * @throws LoginFailedException
	 */
	public void addWikiFavorite(String id) throws GenericException,
			LoginFailedException {
		try {
			response = rootResource.path("collection/wikipages").header(
					AUTHENTICATION_HEADER, credential).entity("wikipageid=" + id)
					.post(ClientResponse.class);
		} catch (UniformInterfaceException e) {
			if (e.getResponse().getStatus() == 401)
				throw new LoginFailedException();
			throw new GenericException(e);
		}
	}
	
	/**
	 * deleteWikiFavorite
	 * @param id
	 * @throws GenericException
	 * @throws LoginFailedException
	 */
	public void deleteWikiFavorite(String id) throws GenericException,
			LoginFailedException {
		try {
			response = rootResource.path("collection/wikipages/" + id).header(
					AUTHENTICATION_HEADER, credential).delete(
					ClientResponse.class);
		} catch (UniformInterfaceException e) {
			if (e.getResponse().getStatus() == 401)
				throw new LoginFailedException();
			throw new GenericException(e);
		}
	}
	
	/**
	 * getFavorites
	 * @return
	 * @throws GenericException
	 * @throws LoginFailedException
	 */
	public Map<String, ArrayList<String>> getFavorites() throws GenericException,
			LoginFailedException {
		try {
//			InputStream stream = getXml("collection");
//			Document doc = new SAXReader().read(stream);
			Map<String, ArrayList<String>> result = new 
					HashMap<String, ArrayList<String>>();
//			List pdflists = doc.selectNodes("pdf");
//          Iterator pdfit = pdflists.iterator();
            ArrayList<String> pdfs = new ArrayList<String>();
//            while(pdfit.hasNext()){
//	            Element elm = (Element)pdfit.next();
//	            Attribute attribute = elm.attribute("id");
//	            String nodename = attribute.getValue();
//	            pdfs.add(nodename);
//            }
            pdfs.add("pdf1");
            pdfs.add("pdf2");
            result.put("pdf", pdfs);
//          List wikipagelists = doc.selectNodes("wiki-page");
//          Iterator wikipageit = wikipagelists.iterator();
            ArrayList<String> wikipages = new ArrayList<String>();
//          while(wikipageit.hasNext()){
//	            Element elm = (Element)wikipageit.next();
//	            Attribute attribute = elm.attribute("tag");
//	            String nodename = attribute.getValue();
//	            wikipages.add(nodename);
//          }
            wikipages.add("wiki1");
            wikipages.add("wiki2");
            result.put("wikipage", wikipages);
            return result;
		} catch (UniformInterfaceException e) {
			if (e.getResponse().getStatus() == 401)
				throw new LoginFailedException();
			throw new GenericException(e);
		} catch (Exception e) {
			throw new GenericException(e);
		}
	}
	
	/**
	 * createGroup
	 * @param name
	 * @return
	 * @throws GenericException
	 * @throws LoginFailedException
	 */
	public String createGroup(String name) throws GenericException,
			LoginFailedException {
		try {
			String entitycontent = "group=" + name;
			response = rootResource.path("groups").header(
					AUTHENTICATION_HEADER, credential).entity(entitycontent).post(ClientResponse.class);
			return response.getEntity(String.class);
		} catch (UniformInterfaceException e) {
			if (e.getResponse().getStatus() == 401)
				throw new LoginFailedException();
			throw new GenericException(e);
		} catch (Exception e) {
			throw new GenericException(e);
		}
	}
	
	/**
	 * joinGroup
	 * @param groupid
	 * @throws GenericException
	 * @throws LoginFailedException
	 */
	public void joinGroup(String groupid) throws GenericException,
			LoginFailedException {
		try {
			String entitycontent = "groupid=" + groupid;
			response = rootResource.path("connection/group_apply").header(
					AUTHENTICATION_HEADER, credential)
				.entity(entitycontent).post(ClientResponse.class);
		} catch (UniformInterfaceException e) {
			if (e.getResponse().getStatus() == 401)
				throw new LoginFailedException();
			throw new GenericException(e);
		} catch (Exception e) {
			throw new GenericException(e);
		}
	} 
	
	/**
	 * listGroups
	 * @return
	 * @throws GenericException
	 * @throws LoginFailedException
	 */
	public ArrayList<String> listGroups() throws GenericException,
			LoginFailedException {
		try {
//			response = rootResource.path("connection/grouplist").accept(MediaType.TEXT_PLAIN_TYPE)
//			.header(AUTHENTICATION_HEADER, credential).get(
//					ClientResponse.class);
//			String result = response.getEntity(String.class);
//			String split[] = result.split("&");
			ArrayList<String> groupList = new ArrayList<String>();
//			for(int i = 0; i < split.length; i++)
//				groupList.add(split[i]);
			groupList.add("1");
			groupList.add("2");
			groupList.add("3");
			groupList.add("4");
			return groupList;
		} catch (UniformInterfaceException e) {
			if (e.getResponse().getStatus() == 401)
				throw new LoginFailedException();
			throw new GenericException(e);
		} catch (Exception e) {
			throw new GenericException(e);
		}
	}
	
	/**
	 * quitGroup
	 * @param groupid
	 * @throws GenericException
	 * @throws LoginFailedException
	 */
	public void quitGroup(String groupid) throws GenericException,
			LoginFailedException {
		try {
			rootResource.path("connection/grouplist/" + groupid).header(
					AUTHENTICATION_HEADER, credential).delete();
		} catch (UniformInterfaceException e) {
			if (e.getResponse().getStatus() == 401)
				throw new LoginFailedException();
			throw new GenericException(e);
		} catch (Exception e) {
			throw new GenericException(e);
		}
	} 
	
	/**
	 * login
	 * @throws LoginFailedException
	 * @throws GenericException
	 */
	public void auth() throws LoginFailedException, GenericException {
		try {
			rootResource.path("password/verify").header(AUTHENTICATION_HEADER, credential).get(
					InputStream.class);
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
