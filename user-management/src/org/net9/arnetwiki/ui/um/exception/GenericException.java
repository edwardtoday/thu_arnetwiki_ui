package org.net9.arnetwiki.ui.um.exception;

import java.io.Serializable;

@SuppressWarnings("serial")
public class GenericException 
extends Exception 
implements Serializable {

	public GenericException() {
	}

	public GenericException(String message) {
		super(message);
	}

	public GenericException(Throwable throwable) {
		super(throwable.getMessage());
	}
}
