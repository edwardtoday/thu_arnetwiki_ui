package org.net9.arnetwiki.ui.um.exception;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LoginFailedException 
extends Exception 
implements Serializable {

	public LoginFailedException() {
		super("Invalid username or password.");
	}
}
