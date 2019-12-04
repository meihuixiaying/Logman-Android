/*
 * @Title:     HttpClientManager.java
 * @Package:   com.t2mobile.logman.travel
 * @Project:   Logman
 * @Version:   1.0.0
 * @CopyRight: @2015 T2M-VAL
 */
package com.t2mobile.logman.travel;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

/**
 * HttpClient 管理类
 *
 * @author songlin.ji
 */
public class HttpClientManager {

	private static HttpClient httpClient = null;

	private static final int RETRIEVE_TIMEOUT = 1000;

	private static final int CONNECTION_TIMEOUT = 6000;

	private static final int SOCKET_TIMEOUT = 5000;

	private synchronized static final HttpClient getHttpClient() {

		if (httpClient == null) {

			final HttpParams httpParams = new BasicHttpParams();

			ConnManagerParams.setTimeout(httpParams, RETRIEVE_TIMEOUT);

			HttpConnectionParams.setConnectionTimeout(httpParams, CONNECTION_TIMEOUT);

			HttpConnectionParams.setSoTimeout(httpParams, SOCKET_TIMEOUT);

			HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);

			HttpProtocolParams.setContentCharset(httpParams, HTTP.UTF_8);

			SchemeRegistry schemeRegistry = new SchemeRegistry();

			schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));

			schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));

			ClientConnectionManager manager = new ThreadSafeClientConnManager(httpParams, schemeRegistry);

			httpClient = new DefaultHttpClient(manager, httpParams);
		}

		return httpClient;
	}

	protected static final void httpHandle(HttpUriRequest request, IResponseHandle responseHandle) {
		try {
			
			HttpResponse response = getHttpClient().execute(request);

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

				String content = EntityUtils.toString(response.getEntity(), HTTP.UTF_8);

				Gson gson = new Gson();

				MessageHead messageHead = gson.fromJson(content, MessageHead.class);

				if (messageHead.getCode() == MessageHead.STATUES_SUCCESS) {
					responseHandle.requestSuccess(messageHead.getBody());
				} else {
					responseHandle.requestError(messageHead.getMessage());
				}
			} else {
				responseHandle.requestFail();
			}
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
