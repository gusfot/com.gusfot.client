package com.wadiz.client.kds.common;

import java.util.UUID;

/**
 * KDS 요청헤더 UUID 생성기
 * @author hyunlae
 *
 */
public class UUIDGenerator {

	public static String generate() {
		
	    UUID uuid = UUID.randomUUID();
	    String randomUUIDString = uuid.toString();
	
	    return randomUUIDString;
	}
}
