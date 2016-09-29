package com.wadiz.client.kds.persistence.mapper;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wadiz.client.kds.model.ClientRequest;
import com.wadiz.client.kds.persistence.ClientRequestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/META-INF/client-context.xml"})
public class KdsRequestMapperTest {

	@Autowired
	private ClientRequestMapper clientRequestMapper;
	
	@Test
	public void testInsert() {
		
		ClientRequest record = new ClientRequest();
		record.setContent("{'test':'test'}");
		record.setRequestSeq(1);
		record.setRequestUuid("1212121212");
		clientRequestMapper.insertSelective(record );
//		assertTrue();
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		
		Integer requestSeq =1;
		ClientRequest req = clientRequestMapper.selectByPrimaryKey(requestSeq );
		assertTrue(req != null);
	}
}
