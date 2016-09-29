package com.wadiz.client.kds.error;

import java.util.HashMap;
import java.util.Map;

/**
 * 크라우드펀딩 계좌유효성 결과(세부메세지): 계좌유효성결과코드
 * @author hyunlae
 *
 */
public class ErrorDetail_ErrorCollection extends HashMap<String, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ErrorDetail_ErrorCollection instance = new ErrorDetail_ErrorCollection();
	
	static {
			
		instance.put("0000", "정상처리");
		instance.put("N100", "정합성검증오류 상세내용은 VALID_EXCEPTION SET");
		instance.put("N200", "스키마정보 없음");
		instance.put("N300", "미등록 IP 오류");
		instance.put("N400", "업무로직 처리중 오류");
		instance.put("N500", "업무정지된 참가기관");
		instance.put("N600", "미등록 사용자");
		instance.put("N700", "미등록 전문오류");
		instance.put("N800", "미인가된 접근");
		instance.put("N900", "서비스종료");
		instance.put("N101", " 중복전문처리요청오류");
		instance.put("N102", "비정상전문처리오류");
		
	}

	public static Map<String,String> getInstance() {
		return instance;
	}
}
