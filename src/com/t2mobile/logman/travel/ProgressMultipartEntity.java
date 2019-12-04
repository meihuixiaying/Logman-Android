/*
 * @Title:     ProgressMultipartEntity.java
 * @Package:   com.t2mobile.logman.travel
 * @Project:   Logman
 * @Version:   1.0.0
 * @CopyRight: @2015 T2M-VAL
 */
package com.t2mobile.logman.travel;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.http.entity.mime.MultipartEntity;

/**
 * 
 *
 * @author songlin.ji
 */
public final class ProgressMultipartEntity extends MultipartEntity {
	
	

	@Override
	public void writeTo(OutputStream outstream) throws IOException {
		super.writeTo(outstream);
	}

	private static class ProgressOutStream extends FilterOutputStream {

		public ProgressOutStream(OutputStream out) {
			super(out);
		}

		@Override
		public void write(byte[] buffer, int offset, int length) throws IOException {
			super.write(buffer, offset, length);
		}

		@Override
		public void write(int oneByte) throws IOException {
			// TODO Auto-generated method stub
			super.write(oneByte);
		}
	}

	public static interface ProgressListener {
		void transferred(long num);
	}
}
