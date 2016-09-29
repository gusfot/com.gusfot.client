package com.wadiz.client.kds.service;

import com.wadiz.client.Request;
import com.wadiz.client.Response;

/**
 * 메시지 서비스
 * @author hyunlae
 *
 */
public interface KdsService {

	/**
	 * KDS서버에 청약 요청을 하고, 응답을 받는다.
	 * @param request
	 * @return
	 */
	
	Response get(Request request);
	
}
