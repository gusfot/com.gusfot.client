package com.wadiz.client.kds.common;

import static org.junit.Assert.*;

import org.junit.Test;

import com.wadiz.client.kds.common.UUIDGenerator;

public class UUIDGeneratorTest {

	@Test
	public void testGenerate() {
		String uuid = UUIDGenerator.generate();
		System.out.println("uuid : " + uuid);
		assertTrue(uuid.length()>0);
	}
}
