package org.net9.arnetwiki.ui.um.util;

import com.sun.jersey.core.util.Base64;

public final class CredentialEncoder {

	/**
	 * <p>
	 * Encode the specified credentials into a String as required by HTTP Basic
	 * Authentication (<a href="http://www.ietf.org/rfc/rfc2617.txt">RFC
	 * 2617</a>).
	 * </p>
	 * 
	 * @param username
	 *            Username to be encoded
	 * @param password
	 *            Password to be encoded
	 */
	public static String encodeBasic(String username, String password) {
		String encode = username + ":" + password;
		return new String(Base64.encode(encode));
	}
}
