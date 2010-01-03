package org.net9.arnetwiki.ui.um.exception;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SignupFailedException 
extends Exception 
implements Serializable {

	public SignupFailedException() {
		super("Invalid username or password or email.");
	}
}
