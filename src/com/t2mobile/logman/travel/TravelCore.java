/*
 * @Title:     TravelCore.java
 * @Package:   com.t2mobile.logman.travel
 * @Project:   Logman
 * @Version:   1.0.0
 * @CopyRight: @2015 T2M-VAL
 */
package com.t2mobile.logman.travel;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.message.BasicNameValuePair;

import com.t2mobile.logman.storage.StageConfig.Stage;

import android.os.AsyncTask;

/**
 * 
 *
 * @author songlin.ji
 */
public class TravelCore {
	private static final String URI_HOST = "172.24.212.40:8080";

	private static final String BASE_URI = "http://" + URI_HOST + "/BugTravel/";

	private static final String URI_STAGE = BASE_URI + "FormatStage";

	private static final String URI_UPLOAD_RECORD = BASE_URI + "UploadRecord";

	private static final String URI_UPLOAD_FILE = BASE_URI + "UploadFile";

	private static final String URI_SUGGESTION = BASE_URI + "Suggestion";

	public static final void registStage(Stage stage) {
		
	}

	public static final void uploadRecord() {

	}

	public static final void uploadFiles() {
		
		MultipartEntity a = new MultipartEntity();
		
		
		HttpPost post = new HttpPost();
		
		post.setEntity(a);
		
	

	}

	public static final void suggest(int stageID, String content, IResponseHandle responseHandle) {
		try {

			HttpPost httpPost = new HttpPost(URI_SUGGESTION);
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();

			if (stageID > 0) {
				pairs.add(new BasicNameValuePair("id", String.valueOf(stageID)));
			}

			pairs.add(new BasicNameValuePair("suggestion", content));

			httpPost.setEntity(new UrlEncodedFormEntity(pairs));

			HttpClientManager.httpHandle(httpPost, responseHandle);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			responseHandle.UnsupportedEncodingException(e);
		}
	}

	private class httpAsyncTask extends AsyncTask<IHttpRequest, Integer, Long> {

		private httpAsyncTask() {

		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(Long result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}

		@Override
		protected Long doInBackground(IHttpRequest... params) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	private interface IHttpRequest {
		HttpUriRequest getRequest();
	}

}
