package com.wadiz.client.kds;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wadiz.client.Response;
import com.wadiz.client.kds.common.config.KdsClientConfig;
import com.wadiz.client.kds.msg.req.CRWDFSW01RQ0001M00;
import com.wadiz.client.kds.msg.req.CRWDFSW01RQ0002M00;
import com.wadiz.client.kds.msg.req.CRWDFSW01RQ0003M00;
import com.wadiz.client.kds.service.KdsService;
import com.wadiz.client.kds.soap.KdsRequest;
import com.wadiz.client.kds.soap.KdsRequestData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/client-context.xml"})
public class ExecutorClientTest {

	@Autowired
	private KdsService kdsService;
	
	
	/**
	 * 크라우드펀딩 투자자 투자한도 요청 테스트
	 * @throws Exception
	 */
	@Test
	public void testGetCRWDFSW01RQ0001M00() throws Exception {
		
		String kdsApiserverUrl = KdsClientConfig.get("kds.apiserver.url");
		System.out.println( "kdsApiserverUrl : " + kdsApiserverUrl);

		// 요청전문 헤더
		CRWDFSW01RQ0001M00 reqData = new CRWDFSW01RQ0001M00();
		
		// 투자자 한도 요청 메시지
		reqData.setRQACOPNO(new BigInteger("7"));
		reqData.setRQACOPSEQ("0000");
		reqData.setREQSEQ(new BigInteger("1"));
		reqData.setISSURBUZNO("2298131587");
		reqData.setINVSTRREALNMNO("2028102637");
		reqData.setINVSTRNM("(주)신한은행");
		reqData.setVERSION("1.3");
 
		Response resData = kdsService.get(new KdsRequest(new KdsRequestData(reqData)));
		
		assertTrue(resData != null);
		
    }
	
	/**
	 * 크라우드펀딩 청약 신청  테스트
	 * @throws Exception
	 */
	@Test
	public void testGetCRWDFSW01RQ0002M00() throws Exception {

		// 요청전문 헤더
		CRWDFSW01RQ0002M00 reqData = new CRWDFSW01RQ0002M00();
		
		// 투자자 한도 요청 메시지
		reqData.setRQACOPNO(new BigInteger("7"));
		reqData.setRQACOPSEQ("0000");
		reqData.setREQSEQ(new BigInteger("1"));
		reqData.setISSURBUZNO("2298131587");
		reqData.setINVSTRREALNMNO("2028102637");
		reqData.setINVSTRNM("(주)신한은행");
		reqData.setVERSION("1.5");
 
		Response resData = kdsService.get(new KdsRequest(new KdsRequestData(reqData)));
		
		assertTrue(resData != null);
		
    }
	
	/**
	 * 크라우드펀딩 계좌유효성 확인 결과 요청  테스트
	 * @throws Exception
	 */
	@Test
	public void testGetCRWDFSW01RQ0003M00() throws Exception {

		// 요청전문 헤더
		CRWDFSW01RQ0003M00 reqData = new CRWDFSW01RQ0003M00();
		
		// 투자자 한도 요청 메시지
		reqData.setRQACOPNO(new BigInteger("7"));
		reqData.setRQACOPSEQ("0000");
		reqData.setREQSEQ(new BigInteger("1"));
		reqData.setVERSION("1.4");
 
		Response resData = kdsService.get(new KdsRequest(new KdsRequestData(reqData)));
		
		assertTrue(resData != null);
		
    }

	    
}
