package com.wadiz.client.kds.common;

import org.junit.Test;

import com.wadiz.client.kds.common.EncodeDecodeUtil;

public class EncodeDecodeUtilTest {

	@Test
	public void testEncode() {
		
	}
	
	@Test
	public void testDecode() throws Exception {
		String srcStr = "H4sIAAAAAAAAAG1SW2uDMBR+768Q31NPvEwLqaWoBUGjTWL7KF7SUegsrGNs/35x2lbZkpd8l/Od"
						+"cBKy+Xq7aJ/y/Xa+dmsdL0HXZNdc23P3utYLsUOert0+qq6tLtdOrvVvedM3/oIE7Bju+BEw4wCA"
						+"UwB/oalF2L7cBllOM98lxhPMRB7tfVUFD0NPjI5oX/YIK2083oU8+YUmYAeb2PF6x8hNLKF4OEaD"
						+"YgY9SUXZh7KIF4kog1BdAqtGf/nBH9MDF0zR24SmNCtFHoTGXOMZEzP+EDEeZ9THS5sYdzBINI1/"
						+"2xRFHPqerCtTmh5yHCmRjU+APPdlhSyvcbDTmFVtnYgxK5mm8IECp7XBAhdZrtkgu6ksVMNJnVRK"
						+"g1u3hnp1T+HTFB7RsAy3InoMC4PaeNWP9SkO5pxlQcT5MLD+1SbEghj/fIUfwO9fIlcCAAA=";
		String Etype = "UTF-8";
		String decoded = EncodeDecodeUtil.decode(srcStr, Etype);
		
		System.out.println(decoded);
	}
	
	
}
