package org.net9.arnetwiki.ui.um;

import org.net9.arnetwiki.ui.um.exception.GenericException;
import org.net9.arnetwiki.ui.um.exception.LoginFailedException;
import org.net9.arnetwiki.ui.um.exception.NotFoundException;

public class Test {
	public static void main(String []args) 
	throws GenericException, NotFoundException, LoginFailedException {
		Backend be = new Backend("testtest", "testtest");
		be.auth();
	}
}
