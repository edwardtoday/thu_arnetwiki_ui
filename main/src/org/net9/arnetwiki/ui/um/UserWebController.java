package org.net9.arnetwiki.ui.um;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.net9.arnetwiki.ui.um.exception.BackendConnectionException;
import org.net9.arnetwiki.ui.um.exception.GenericException;
import org.net9.arnetwiki.ui.um.exception.LoginFailedException;
import org.net9.arnetwiki.ui.um.exception.LoginRequiredException;
import org.net9.arnetwiki.ui.um.exception.SignupFailedException;

/*
 * @author huww06
 * 
 */
public class UserWebController {
	
	private HttpServletRequest request;
	
	public UserWebController(HttpServletRequest request) {
		this.request = request;
	}
	
	public boolean isLoggedIn() 
	throws GenericException, BackendConnectionException {
		if (isLogged()) {
			Backend.testConnection();
			return true;
		} else
			return false;
	}
	
	public void login(String username, String password)
	throws GenericException, LoginFailedException {
		if (!isLogged()) {
			Backend ses = new Backend(username, password);
			ses.auth();
			getHttpSession().setAttribute(SESSION_KEY, ses);
		}
	}
	
	public void signup(String username, String password, String email)
	throws GenericException, SignupFailedException {
		if(!isLogged()) {
			Backend ses = new Backend(username, password);
		}
	}
	
	public void logout() {
		if (isLogged()) {
			getHttpSession().removeAttribute(SESSION_KEY);
			getHttpSession().invalidate();
		}
	}
	
	public Backend getSession() 
	throws LoginRequiredException {
		if (isLogged()) {
			return (Backend) getHttpSession().getAttribute(SESSION_KEY);
		}
		throw new LoginRequiredException();
	}
	
	private boolean isLogged() {
		HttpSession session = getHttpSession();
		if (session.isNew())
			return false;
		if (session.getAttribute(SESSION_KEY) == null)
			return false;
		return true;
	}
	
	private HttpSession getHttpSession() {
		return request.getSession();
	}
	
	private static final String SESSION_KEY = "ArnetWiki Session";
}
