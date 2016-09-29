package com.wadiz.client.kds.common;

import static org.junit.Assert.*;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import com.wadiz.client.kds.msg.res.ERRRORDETAIL;

public class UnmarsharllingTest {

	@Test
	public void testUnmarshal() throws Exception {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		builder.append("<ERRRORDETAIL>");
		builder.append("<NMI_RES_UUID>7152ad91-0795-4bd4-a3ff-76d9d91c09d5</NMI_RES_UUID>");
		builder.append("<PROCESS_CD>N100</PROCESS_CD>");
		builder.append("<VALID_EXCEPTION>메시지 정합성 검증 실패: cvc-maxLength-valid: Value '20281102637' with length = '11' is not facet-valid with respect to maxLength '10' for type '#AnonType_ISSUR_BUZNOCRWDFSW01RQ0002M00'.</VALID_EXCEPTION>");
		builder.append("<SEND_DATE>20151215145515044</SEND_DATE>");
		builder.append("<NMI_REQ_UUID>9e1c9e49-ff24-4ec0-aa1d-84eda58a45ec</NMI_REQ_UUID>");
		builder.append("</ERRRORDETAIL>");
		
		System.out.println(builder.toString());
		/*String decoded = "H4sIAAAAAAAAAF1Ru26cUBDt9ytGpKC6Zi5vLBZrs2AJac3aF7CjNIjHxUbCYC1kbXcu0jll3CVS"
+"iiiJy+SzEvwPQSEPOyONNJo550hnjr13dV7Dlm+6qm3mAt1BAXiTt0XVnM6FONonpgBdnzZFWrcN"
+"nwvXvBP2nJntMcbWzPWihb9yZjCWHRz4CfPCJI5916FUQZWiRoyMy0RFBYmlGSUpqU65haiaZmFL"
+"TyiTyiFbL70wTJauE1BEW3q0mBDHi5XvJt6LpXcY+evA+XH/drh9N3y+geHD3cPd/fD6K3z/djN8"
+"eg/D7ceHN192Id/m5Dy9WvHmtD8j27Suil04TutXHEQZZZNSlHXFEOGy6s+g/gWDOYiUilB10LQ9"
+"lGnO+4k6oTa8u+B5D30Lf6VHBopQthvory9G7WeLpm2icUz8MIxZ8jx+GayX7MTdD0+QsiNElA8Q"
+"xR1b+t/V5DX0AjdxF5HnyEg1Ko+tyTJqiJYt/Ts+DuBo+mZmUa6XuU6sojSIqmUKyTRFJXqGllYa"
+"lqLp5p8AflNmtvQk1p/N73hcHQIAAA==";*/
		
//		String plain = EncodeDecodeUtil.decode(decoded, "UTF-8");
		JAXBContext jaxbContext = JAXBContext.newInstance(ERRRORDETAIL.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		StringReader sr = new StringReader(builder.toString()); 
		Object returnObj = jaxbUnmarshaller.unmarshal(sr);
		
		System.out.println(returnObj.toString());
		
		assertTrue(returnObj!=null);
	}
}
