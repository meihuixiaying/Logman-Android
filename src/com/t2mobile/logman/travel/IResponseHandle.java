/*
 * @Title:     IResponseHandle.java
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
 * @param <T>
 */
public interface IResponseHandle {

	void requestFail();

	void requestError(String message);

	void requestSuccess(String body);

	void ClientProtocolException(Exception exception);

	void IOException(Exception exception);

	void UnsupportedEncodingException(Exception exception);
}
