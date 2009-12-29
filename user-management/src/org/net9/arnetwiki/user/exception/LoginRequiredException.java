package org.net9.arnetwiki.user.exception;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LoginRequiredException 
extends Exception 
implements Serializable {

	public LoginRequiredException() {
		super("Login is required");
	}
}
