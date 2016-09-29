package com.wadiz.client.kds.soap;

import com.google.gson.Gson;
import com.wadiz.client.RequestData;

/**
 * KDS 요청데이터
 * @author hyunlae
 *
 */
public class KdsRequestData implements RequestData {

	// KDS에서 받은 전문데이터
	private Object data;
	
	public KdsRequestData(Object requestData) {
		this.data = requestData;
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
