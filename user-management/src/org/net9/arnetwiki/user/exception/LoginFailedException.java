package org.net9.arnetwiki.user.exception;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LoginFailedException 
extends Exception 
implements Serializable {

	public LoginFailedException() {
		super("Invalid username or password.");
	}
}
