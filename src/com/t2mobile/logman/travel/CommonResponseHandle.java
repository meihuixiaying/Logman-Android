/*
 * @Title:     CommonResponseHandle.java
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
public class CommonResponseHandle implements IResponseHandle {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.t2mobile.logman.travel.IResponseHandle#requestFail()
	 */
	@Override
	public void requestFail() {
		// TODO Auto-generated method stub
	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.t2mobile.logman.travel.IResponseHandle#requestError(java.lang.String)
	 */
	@Override
	public void requestError(String message) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.t2mobile.logman.travel.IResponseHandle#requestSuccess(java.lang.String
	 * )
	 */
	@Override
	public void requestSuccess(String body) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.t2mobile.logman.travel.IResponseHandle#ClientProtocolException(java
	 * .lang.Exception)
	 */
	@Override
	public void ClientProtocolException(Exception exception) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.t2mobile.logman.travel.IResponseHandle#IOException(java.lang.Exception
	 * )
	 */
	@Override
	public void IOException(Exception exception) {
		// TODO Auto-generated method stub

	}

	@Override
	public void UnsupportedEncodingException(Exception exception) {
		// TODO Auto-generated method stub

	}

}
