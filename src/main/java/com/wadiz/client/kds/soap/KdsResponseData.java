package com.wadiz.client.kds.soap;

import com.google.gson.Gson;
import com.wadiz.client.ResponseData;

/**
 * KDS 응답데이터
 * @author hyunlae
 *
 */
public class KdsResponseData implements ResponseData {

	// KDS에서 받은 전문데이터
	private Object data;
	
	public KdsResponseData(Object responseData) {
		this.data = responseData;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toJson() {
		return new Gson().toJson(data);
	}

}
