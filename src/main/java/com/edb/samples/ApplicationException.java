package com.edb.samples;

import java.io.Serializable;

/**
 * The ApplicationException will thrown for any error conditions encountered in the
 * application.
 */
@javax.ejb.ApplicationException(rollback = true)
public class ApplicationException extends Exception implements Serializable {

	private static final long serialVersionUID = -5189847775512578042L;

	private String errorMessage;

	private String errorNumber;

	public ApplicationException(final Throwable cause) {
		super(cause);
	}

	public ApplicationException() {
		super();
	}

	public ApplicationException(final String message, final Throwable cause) {
		super(message, cause);
		this.errorMessage = message;
	}

	public ApplicationException(final String message) {
		super(message);
		this.errorMessage = message;
	}

	public ApplicationException(final String message, final String errNumber) {
		super(message);
		this.errorNumber = errNumber;
		this.errorMessage = message;
	}

	public ApplicationException(final Exception exception) {
		super(exception.getMessage(), exception);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorNumber(final String errorNumber) {
		this.errorNumber = errorNumber;
	}

	public String getErrorNumber() {
		return errorNumber;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
