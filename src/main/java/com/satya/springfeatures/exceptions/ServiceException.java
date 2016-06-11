 
package com.satya.springfeatures.exceptions;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2943714933607245449L;
	private String message;
	private int errorCode;

	public ServiceException(String message) {
		this.message = message;
	}

	public ServiceException(String message, int errorCode) {
		this.message = message;
		this.errorCode = errorCode;
	}

	public ServiceException(String message, int errorCode, Throwable cause) {
		super(cause);
		this.message = message;
		this.errorCode = errorCode;
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
