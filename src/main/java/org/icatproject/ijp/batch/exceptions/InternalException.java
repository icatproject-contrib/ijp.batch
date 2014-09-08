package org.icatproject.ijp.batch.exceptions;

import java.net.HttpURLConnection;

@SuppressWarnings("serial")
public class InternalException extends BatchException {

	public InternalException(String message) {
		super(HttpURLConnection.HTTP_INTERNAL_ERROR, message);
	}

}
