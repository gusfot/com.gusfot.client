package com.wadiz.client.kds.error;

import java.util.HashMap;
import java.util.Map;

/**
 * 청약신청결과: 신청결과코드리스트
 * @author hyunlae
 *
 */
public class CRWDFSW01RS0002M00_ErrorCollection extends HashMap<String, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static CRWDFSW01RS0002M00_ErrorCollection instance = new CRWDFSW01RS0002M00_ErrorCollection();
	
	static {
			
		instance.put("0000", "신청성공");
		instance.put("0021", "투자한도초과");
		instance.put("0022", "투자자유형변경");
		instance.put("0023", "모집정보오류");
		instance.put("0024", "청약기간오류(청약종료)");
		instance.put("0025", "중복청약");
		instance.put("0026", "청약신청미존재");
		instance.put("0027", "투자자성명상이,실명번호가 일치하는 투자자의 성명이 당원에 등록된 내역과 다른 경우");
		instance.put("0028", "실명번호구분상이,실명번호가 일치하는 투자자의 실명번호 구분이 당원에 등록된 내역과 다른 경우");
		instance.put("0029", "기타오류");
		instance.put("0030", "청약금액오류,(청약금액 = 청약수량 * 발행가) 조건 오류");
		instance.put("0031", "계좌정보불충분,(모집이 예탁인 경우) 위탁계좌정보가 불충분하게 넘어온 경우");
		instance.put("0032", "계좌변경불가(변경기간)	,납입일이 지났거나 명세가 통보되어 계좌를 변경할 수 없는 기간");
		instance.put("0033", "계좌변경불가(청약내역없음),계좌를 변경할 청약내역이 없는 경우");
		instance.put("0034", "계좌변경불가(계좌정보미변경),계좌정보의 변경이 없는 계좌변경 신청");
		instance.put("0035", "실명번호구분 오류");
		instance.put("0036", "투자자실명번호 오류,주민번호/법인등록 번호의 자리수 오류");
		instance.put("0037", "계좌확인실명번호상이,개인 또는 외국인의 실명번호와 계좌확인실명번호가 다름");
		instance.put("0038", "계좌확인실명번호오류,주민번호/사업자등록 번호의 자리수 오류");
		instance.put("0039", "계좌변경불가(보호예수),모집되는 종목이 예탁이 아닌 보호예수로 모집되는 경우");
		instance.put("0040", "사업자등록번호상이,청약신청시 제출된 종목번호의 증권구분과 제출된 증권구분 불일치");
		instance.put("0041", "청약신청시 제출된 종목번호의 발행인과 제출된 사업자등록번호 불일치");
//		instance.put("0042", "");
		instance.put("1000", "업무마감");
		instance.put("1001", "중개업자의 고객번호와 요청한 중개업자 계좌번호 상이");
		
	}

	public static Map<String,String> getInstance() {
		return instance;
	}
}
