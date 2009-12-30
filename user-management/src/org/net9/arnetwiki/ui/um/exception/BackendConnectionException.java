package org.net9.arnetwiki.ui.um.exception;

import java.io.Serializable;


@SuppressWarnings("serial")
public class BackendConnectionException 
extends Exception 
implements Serializable {

	public BackendConnectionException() {
		super("Service connection failed.");
	}
}
