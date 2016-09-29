package com.wadiz.client.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testSubstring() {
		String invstrRealnmno = "8204051341913";
		String ss1 = invstrRealnmno.substring(0, 6);
		String ss2 = invstrRealnmno.substring(6, 13);
		
		assertTrue("820405".equals(ss1) && "1341913".equals(ss2));
	}
	
	
	@Test
	public void testSubstring2() {
		String text = "50000";
		System.out.println(text.replaceAll("0000", ""));
//		System.out.println("substr : " + ss1);
	}
}
