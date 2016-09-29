package com.wadiz.client.kds.soap;

import com.wadiz.client.Response;
import com.wadiz.client.ResponseData;

/**
 * KDS 응답 클래스
 * @author hyunlae
 *
 */
public class KdsResponse implements Response {

	/**
	 * KDS 응답내용 
	 */
	private ResponseData responseData;
	
	/**
	 * KDS 응답결과
	 */
	private boolean success;
	
	/**
	 * 결과 메세지(정상 응답일 경우 없을 수도 있음.)
	 */
	private String message;
	
	
	private String code;
	
	@Override
	public boolean isSuccess() {
		return success;
	}

	@Override
	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void setResponseData(ResponseData responseData) {
		this.responseData = responseData;
		
	}

	@Override
	public ResponseData getResponseData() {
		return responseData;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}

}
