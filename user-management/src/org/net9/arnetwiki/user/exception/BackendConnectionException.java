package org.net9.arnetwiki.user.exception;

import java.io.Serializable;


@SuppressWarnings("serial")
public class BackendConnectionException 
extends Exception 
implements Serializable {

	public BackendConnectionException() {
		super("Service connection failed.");
	}
}
