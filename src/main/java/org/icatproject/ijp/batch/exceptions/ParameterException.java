package org.icatproject.ijp.batch.exceptions;

import java.net.HttpURLConnection;

@SuppressWarnings("serial")
public class ParameterException extends BatchException {

	public ParameterException(String message) {
		super(HttpURLConnection.HTTP_BAD_REQUEST, message);
	}

}
