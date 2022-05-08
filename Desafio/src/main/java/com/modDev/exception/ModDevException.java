package com.modDev.exception;

public class ModDevException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codError;

	public ModDevException() {
	}

	public ModDevException(String cod, String msg) {
		super(msg);
		this.codError = cod;
	}

	public ModDevException(String msg) {
		super(msg);
	}

	public String getCodError() {
		return codError;
	}

	public void setCodError(String codError) {
		this.codError = codError;
	}

}
