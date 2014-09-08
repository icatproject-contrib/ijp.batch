package org.icatproject.ijp.batch.exceptions;

import java.net.HttpURLConnection;

@SuppressWarnings("serial")
public class ForbiddenException extends BatchException {

	public ForbiddenException(String message) {
		super(HttpURLConnection.HTTP_FORBIDDEN, message);
	}

}
