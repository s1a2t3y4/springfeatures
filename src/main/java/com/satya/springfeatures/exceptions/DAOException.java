 
package com.satya.springfeatures.exceptions;

public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3652645922967656209L;
	private int errorCode;

	public DAOException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public DAOException(String message, int errorCode, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}
	
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
	

	public DAOException(Throwable cause) {
		super(cause);
	}
}