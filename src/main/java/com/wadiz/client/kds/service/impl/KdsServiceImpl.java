package com.wadiz.client.kds.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wadiz.client.Request;
import com.wadiz.client.Response;
import com.wadiz.client.kds.KdsExecuteClient;
import com.wadiz.client.kds.service.KdsService;

@Service
public class KdsServiceImpl implements KdsService{

	@Autowired
	private KdsExecuteClient client;
	
	@Override
	public Response get(Request req) {
		
		Response res = null;
		
		try {
			res = client.invoke(req);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

}
