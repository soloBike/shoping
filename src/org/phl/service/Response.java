package org.phl.service;

import java.io.Serializable;

public class Response implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int LOGIN_MESSAGE = 0;
	public static final int REGISTER_MESSAGE = 1;
	public static final int SEARCH_MESSAGE = 2;
	public static final int OFFLINE_MESSAGE = 3;
	public static final int PAY_MESSAGE = 4;
	private int messageType;
	private boolean result;
	private String message;
	private Object obj;

	public int getMessageType() {
		return messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public static int getLoginMessage() {
		return LOGIN_MESSAGE;
	}

	public static int getRegisterMessage() {
		return REGISTER_MESSAGE;
	}

	public static int getSearchMessage() {
		return SEARCH_MESSAGE;
	}

	public static int getOfflineMessage() {
		return OFFLINE_MESSAGE;
	}

	public static int getPayMessage() {
		return PAY_MESSAGE;
	}

	public String toString() {
		return (new StringBuilder("Response [messageType=")).append(messageType).append(", result=").append(result)
				.append(", message=").append(message).append(", obj=").append(obj).append("]").toString();
	}

}
