package com.wadiz.client.kds.error;

import java.util.HashMap;
import java.util.Map;

/**
 * 크라우드펀딩 투자자 투자한도 요청 결과 코드 목록
 * @author hyunlae
 *
 */
public class CRWDFSW01RS0001M00_ErrorCollection extends HashMap<String, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static CRWDFSW01RS0001M00_ErrorCollection instance = new CRWDFSW01RS0001M00_ErrorCollection();
	
	static {
			
			// 크라우드펀딩 투자자 투자한도 요청 결과: 한도요청결과코드리스트
			instance.put("0000", "성공");
			instance.put("0011", "미등록투자자");
			instance.put("0001", "성공(한도제한없음)");
			instance.put("0012", "한도없음");
			instance.put("1000", "업무마감");
			instance.put("1001", "미인가중개업자계좌,중개업자의 고객번호와 요청한 중개업자 계좌번호 상이");
	}

	public static Map<String,String> getInstance() {
		return instance;
	}
}
