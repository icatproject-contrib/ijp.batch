package org.icatproject.ijp.batch.exceptions;

import java.net.HttpURLConnection;

@SuppressWarnings("serial")
public class SessionException extends BatchException {

	public SessionException(String message) {
		super(HttpURLConnection.HTTP_FORBIDDEN, message);
	}

}
