/*
 * @Title:     MessageHead.java
 * @Package:   com.t2mobile.logman.travel
 * @Project:   Logman
 * @Version:   1.0.0
 * @CopyRight: @2015 T2M-VAL
 */
package com.t2mobile.logman.travel;

/**
 * 
 *
 * @author songlin.ji
 */
public class MessageHead {

	public static final int STATUES_SUCCESS = 0;

	public static final int STATUES_ERROR = 1;

	public static final int STATUES_FAIL = 2;

	private int code = 0;

	private String message;

	private String body;

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
