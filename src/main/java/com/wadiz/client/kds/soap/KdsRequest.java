package com.wadiz.client.kds.soap;

import java.util.HashMap;
import java.util.Map;

import com.wadiz.client.Request;
import com.wadiz.client.RequestData;

/**
 * KDS 요청클래스
 * @author hyunlae
 *
 */
public class KdsRequest implements Request {

	/**
	 * KDS 요청전문 객체(CRWDFSW01RQ0001M00, CRWDFSW01RQ0002M00, CRWDFSW01RQ0003M00)
	 */
	private RequestData data;
	
	private String callMethod;
	
	private Map<Object, Object> parameters = new HashMap<>();
	
	public KdsRequest(RequestData reqData) {
		this.data = reqData;
	}

	@Override
	public void setData(RequestData data) {
		this.data = data;
	}

	@Override
	public RequestData getData() {
		return data;
	}

	@Override
	public String getCallMethod() {
		return callMethod;
	}

	@Override
	public void setCallMethod(String callMethod) {
		this.callMethod = callMethod;		
	}

	@Override
	public void setParameters(Map<Object, Object> parameters) {
		this.parameters = parameters;
	}

	@Override
	public Map<Object, Object> getParameters() {
		return parameters;
	}

}
