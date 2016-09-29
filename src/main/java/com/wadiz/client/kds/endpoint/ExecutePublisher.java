package com.wadiz.client.kds.endpoint;
 
import javax.xml.ws.Endpoint;

import com.wadiz.client.kds.executor.KdsExecutorImpl;
 
//Endpoint publisher
public class ExecutePublisher{
 
	public static void main(String[] args) {
	   Endpoint.publish("http://10.16.201.200:80/webservices/NMI.receiverWS", new KdsExecutorImpl());
    }
 
}