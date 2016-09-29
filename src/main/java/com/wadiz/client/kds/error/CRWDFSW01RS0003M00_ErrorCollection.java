package com.wadiz.client.kds.error;

import java.util.HashMap;
import java.util.Map;

/**
 * 크라우드펀딩 계좌유효성 결과(세부메세지): 계좌유효성결과코드
 * @author hyunlae
 *
 */
public class CRWDFSW01RS0003M00_ErrorCollection extends HashMap<String, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static CRWDFSW01RS0003M00_ErrorCollection instance = new CRWDFSW01RS0003M00_ErrorCollection();
	
	static {
			
		instance.put("0000", "정상계좌");
		instance.put("0081", "계좌유효성확인불가,(계좌유효성확인 전문 미참여 증권사) 수작업 확인 전");
		instance.put("0082", "계좌유효성확인전");
		instance.put("0083", "오류계좌(수작어등록),(계좌유효성확인 전문 미참여 증권사) 수작업 오류 입력한 결과");
		instance.put("0084", "계좌유효성산출불가,(계좌유효성확인 전문 미참여 증권사 계좌) 최종변경 계좌가 아니라 결과확인불가");
		instance.put("1000", "업무마감");
		instance.put("1001", "미인가중개업자계좌,중개업자의 고객번호와 요청한 중개업자 계좌번호 상이");
		instance.put("G401", "(증권사제공) 결과코드,매입자 주민(사업자)번호 오류가 발생했습니다.");
		instance.put("G402", "(증권사제공) 결과코드,고객 계좌번호 오류가 발생했습니다.");
		instance.put("G403", "(증권사제공) 결과코드,매입자정보와 계좌정보 불일치입니다.");
		instance.put("G404", "(증권사제공) 결과코드,입고불가증권입니다.");
		instance.put("G405", "(증권사제공) 결과코드,입고불가계좌입니다.");
		instance.put("G406", "(증권사제공) 결과코드,종목번호가 없습니다.");
		instance.put("G407", "(증권사제공) 결과코드,증권사 처리중 오류발생했습니다.");
		instance.put("G408", "(증권사제공) 결과코드,입고가능 계좌이나 계좌주실명번호와 매입자 주민번호가 일치하지 않습니다.");
		instance.put("G409", "(증권사제공) 결과코드,WRAP계좌입니다.");
		instance.put("G410", "(증권사제공) 결과코드,계좌통폐합/폐쇄계좌입니다.");
		instance.put("G411", "(증권사제공) 결과코드,계좌번호체계 오류가 발생했습니다.");
		instance.put("G430", "(증권사제공) 결과코드,전문내역이 존재하지 않습니다.");
		instance.put("G431", "(증권사제공) 결과코드,업무 마감시간 오류입니다.");
		instance.put("G432", "(증권사제공) 결과코드,입고의뢰상태가 아닙니다");
		instance.put("G433", "(증권사제공) 결과코드,송/수신 증권사 위탁자계좌번호가 상이합니다");
		instance.put("G434", "(증권사제공) 결과코드,SECN_TPCD");
		instance.put("G435", "(증권사제공) 결과코드,송/수신 입고금액 상이합니다");
		instance.put("G436", "(증권사제공) 결과코드,송/수신 증권구분이 상이합니다.");
		instance.put("G437", "(증권사제공) 결과코드,송/수신 투자자계좌번호가 상이합니다.");
		instance.put("G438", "(증권사제공) 결과코드,구 전문응답코드로 요청했습니다.");
		instance.put("G439", "(증권사제공) 결과코드,이미 접수처리된 전문입니다.");
		instance.put("G440", "(증권사제공) 결과코드,확인되지않은 정보확인 전문요청구분입니다.");
		instance.put("G441", "(증권사제공) 결과코드종목이 상이합니다.");
		
	}

	public static Map<String,String> getInstance() {
		return instance;
	}
}
