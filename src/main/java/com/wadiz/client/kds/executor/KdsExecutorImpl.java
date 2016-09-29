package com.wadiz.client.kds.executor;

import javax.jws.WebService;

//Service Implementation
@WebService
//@WebService(endpointInterface = "ksd.safe.nmi.performer")
public class KdsExecutorImpl implements KdsExecutor{
 
	@Override
	public String execute(String name) {
		return "Hello World JAX-WS " + name;
	}
 
}