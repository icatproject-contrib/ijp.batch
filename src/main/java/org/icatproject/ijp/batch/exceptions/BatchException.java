package org.icatproject.ijp.batch.exceptions;

@SuppressWarnings("serial")
public class BatchException extends Exception {

	private int httpStatusCode;

	public BatchException(int httpStatusCode, String message) {
		super(message);
		this.httpStatusCode = httpStatusCode;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

}
