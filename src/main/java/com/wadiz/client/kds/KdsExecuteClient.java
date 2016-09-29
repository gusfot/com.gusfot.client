package com.wadiz.client.kds;
 
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wadiz.client.Client;
import com.wadiz.client.Request;
import com.wadiz.client.RequestData;
import com.wadiz.client.Response;
import com.wadiz.client.kds.common.EncodeDecodeUtil;
import com.wadiz.client.kds.common.config.KdsClientConfig;
import com.wadiz.client.kds.error.CRWDFSW01RS0001M00_ErrorCollection;
import com.wadiz.client.kds.error.CRWDFSW01RS0002M00_ErrorCollection;
import com.wadiz.client.kds.error.CRWDFSW01RS0003M00_ErrorCollection;
import com.wadiz.client.kds.error.ErrorDetail_ErrorCollection;
import com.wadiz.client.kds.exception.KdsResponseException;
import com.wadiz.client.kds.executor.KdsExecutor;
import com.wadiz.client.kds.model.ClientRequest;
import com.wadiz.client.kds.model.ClientResponse;
import com.wadiz.client.kds.msg.req.CRWDFSW01RQ0001M00;
import com.wadiz.client.kds.msg.req.CRWDFSW01RQ0002M00;
import com.wadiz.client.kds.msg.req.CRWDFSW01RQ0003M00;
import com.wadiz.client.kds.msg.req.NMIREQHEADER;
import com.wadiz.client.kds.msg.res.CRWDFSW01RS0001M00;
import com.wadiz.client.kds.msg.res.CRWDFSW01RS0002M00;
import com.wadiz.client.kds.msg.res.CRWDFSW01RS0003M00;
import com.wadiz.client.kds.msg.res.CRWDFSW01RS0003S00;
import com.wadiz.client.kds.msg.res.ERRRORDETAIL;
import com.wadiz.client.kds.msg.res.NMIRESHEADER;
import com.wadiz.client.kds.persistence.ClientRequestMapper;
import com.wadiz.client.kds.persistence.ClientResponseMapper;
import com.wadiz.client.kds.soap.KdsRequestData;
import com.wadiz.client.kds.soap.KdsResponse;
import com.wadiz.client.kds.soap.KdsResponseData;
 
/**
 * KDS 호출 클라이언트
 * @author hyunlae
 *
 */
@Component
public class KdsExecuteClient implements Client {
 
	private static final Logger logger = LoggerFactory.getLogger(KdsExecuteClient.class);
	private static final String RESPONSE_OK = "0000";
	private static final Map<String, String>  CRWDFSW01RS0003S00_ERROR_COLLECTION = new HashMap<String, String>();
	private static final Map<String, String>  ERRRORDETAIL_ERROR_COLLECTION = new HashMap<String, String>();
	
	
	@Autowired
	private ClientRequestMapper clientRequestMapper;
	
	@Autowired
	private ClientResponseMapper clientResponseMapper;
	
//	@Autowired
//	private TbPersonalUserInfoMapper tbPersonalUserInfoMapper;
//	
//	@Autowired
//	private TbBusinessLicenseInfoMapper tbBusinessLicenseInfoMapper;
	
	/**
	 * KDS 서버에 요청한다.
	 * 호출 예외발생 시 최대 2번까지 호출한다.
	 * 
	 * @param executor
	 * @param encodedRequestData
	 * @throws Exception 
	 */
	private String invoke(KdsExecutor executor, RequestData requestData) throws Exception {

		int currentCount = 0,
			maxTryCount = 2;		// 시도횟수 2번
		String result = null;
		
		  // 요청전물을 인코딩한다.
        String encodedRequestData = encode(requestData.getData());
        
		while(currentCount<maxTryCount ) {
			
			try {
				
				// 첫번째 시도
				result = executor.execute(encodedRequestData);
				logger.debug("request result : " + result);
				break;
				
			} catch(WebServiceException e) {
				
				if(currentCount != (maxTryCount-1)) {
					logger.error("KDS 연계 서버 호출 중 예외가 발생하였습니다. 5초후에 재시도합니다.");
					Thread.sleep(5000);
				}else {
					logger.error("재시도중 KDS 연계 서버 호출 중 예외가 발생하였습니다. 해당 전문에 대하여 확인바랍니다.");
				}
				
				e.printStackTrace();
				currentCount++;
		
			}
			
		}
		
		
		return result;
	}

	
	/**
	 * 응답전문의 정상처리결과(0000) 여부 확인
	 * - 처리결과코드가 정상(0000)이 아닌 경우, 참가기관은 결과코드를 바탕으로 송신전문의
	 * 문제점을 개선하여 재 송신한다.
	 * 만약, 결과코드 및 송신전문의 내용만으로 예외에 대한 업무현황을 파악하기 어려울
	 * 경우, 송신전문의 요청일련번호를 포함하는 “장애현황파악요청서”*를 작성하여 KSD에
	 * 현황파악을 의뢰하여 처리한다.
	 * 
	 * @param response
	 * @throws KdsResponseException
	 */
	private boolean isValidResponse(Object response) {
		
		boolean result = false;
		String processcd = "";
		
		try {
			// 정상 응답전문일 경우
			processcd = ((NMIRESHEADER)response).getPROCESSCD();
			
		}catch(java.lang.ClassCastException e) {
//			e.printStackTrace();
			logger.debug(e.getMessage());
			// 예외발생 응답전문일 경우
			processcd = ((ERRRORDETAIL)response).getPROCESSCD();
		}
		
		// 응답처리 결과 조회
		if(!RESPONSE_OK.equals(processcd) ) {
			logger.error("응답처리 결과가 비정상입니다. 확인바랍니다.\n처리결과코드가 정상(0000)이 아닌 경우, 참가기관은 결과코드를 바탕으로 송신전문의 문제점을 개선하여 재 송신한다.\n"
		  + "만약, 결과코드 및 송신전문의 내용만으로 예외에 대한 업무현황을 파악하기 어려울 경우, 송신전문의 요청일련번호를 포함하는 '장애현황파악요청서'를 작성하여 KSD에\n"
		  + "현황파악을 의뢰하여 처리한다");
			
		}else {
			logger.info("응답처리 결과가 정상입니다.");
			result = true;
		}
			
		return result;
		
	}

	/**
	 * 응답받은 전문내용을 decoding(xml)한다.
	 * @param responseObject
	 * @param result
	 * @return
	 * @throws Exception 
	 */
	private Object decode(Response response, Class<?> responseObject, String result) throws Exception {

		Object returnObj = null;

		
		// 예외발생시
		try {
			
			logger.debug("responseObject : " + responseObject);
			logger.debug("정상 응답전물.");
			StringReader sr = new StringReader(EncodeDecodeUtil.decode(result, "UTF-8"));
			JAXBContext jaxbContext = JAXBContext.newInstance(responseObject);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			returnObj = jaxbUnmarshaller.unmarshal(sr);
			
			response.setSuccess(true);
			response.setCode("SUSS000");
			response.setMessage(getResultMessage(returnObj));
			
		}catch (javax.xml.bind.UnmarshalException e) {
			logger.debug("오류 응답전물.");
			e.printStackTrace();
			
			StringReader sr = new StringReader(EncodeDecodeUtil.decode(result, "UTF-8"));
			JAXBContext jaxbContext = JAXBContext.newInstance(ERRRORDETAIL.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			returnObj = jaxbUnmarshaller.unmarshal(sr);
			
			response.setSuccess(true);
			response.setCode("SUDI000");
			String processcd = ((ERRRORDETAIL)returnObj).getPROCESSCD();
			response.setMessage(processcd);
		}
		
		isValidResponse(returnObj);
		
		return returnObj;
	}

	
	/**
	 * 각 응답코드의 설명을 반환한다. 
	 * @param returnObj
	 * @return
	 */
	private String getResultMessage(Object returnObj) {
		
		String message = "", code = "";
		Map<String, String> errorCodeMap = null;
		
		try {
			
			if(returnObj instanceof CRWDFSW01RS0001M00) {
				
				code = ((CRWDFSW01RS0001M00)returnObj).getLMTREQRESULTCD();
				
				errorCodeMap = CRWDFSW01RS0001M00_ErrorCollection.getInstance();
				String tmp = errorCodeMap.get(code);
				
				// 알수 업는 코드일 경우 코드값으로 ..
				if(tmp !=null) {
					message = tmp; 
				}else {
					message = code;
				}
				
			}else if(returnObj instanceof CRWDFSW01RS0002M00) {
				
				code = ((CRWDFSW01RS0002M00)returnObj).getASKRESULTCD();
			
				errorCodeMap = CRWDFSW01RS0002M00_ErrorCollection.getInstance();
				String tmp = errorCodeMap.get(code);
//				String tmp = CRWDFSW01RS0002M00_ERROR_COLLECTION.get(code);
				
				// 알수 업는 코드일 경우 코드값으로 ..
				if(tmp !=null) {
					message = tmp; 
				}else {
					message = code;
				}
				
			}else if(returnObj instanceof CRWDFSW01RS0003M00) {
				
				List<CRWDFSW01RS0003S00> resultList = ((CRWDFSW01RS0003M00)returnObj).getACCFMRESULT();
				int size = resultList.size();
				String tmpMessage="";
				
				if(resultList!=null) {
					for (int i = 0; i < size; i++ ) {
						
						CRWDFSW01RS0003S00 resultCd = resultList.get(i);
						code = resultCd.getACCFMRESULTCD();
						
						errorCodeMap = CRWDFSW01RS0003M00_ErrorCollection.getInstance();
						String tmp = errorCodeMap.get(code);
						
						// 알수 업는 코드일 경우 코드값으로 ..
						if(tmp !=null) {
							tmpMessage += tmp + ( size==(i+1) ?"":"|");
						}else {
							tmpMessage += code+( size==(i+1) ?"":"|");
						}
					}
				}
				
				message = tmpMessage;
				
			}else {
				
				code = ((ERRRORDETAIL)returnObj).getVALIDEXCEPTION();
				
				errorCodeMap = ErrorDetail_ErrorCollection.getInstance();
				String tmp = errorCodeMap.get(code);
				
				// 알수 업는 코드일 경우 코드값으로 ..
				if(tmp !=null) {
					message = tmp; 
				}else {
					message = code;
				}
				
			}
			
		}catch (Exception e) {
			message= "알수없는 코드";
			e.printStackTrace();
		}
		
		logger.info("result code message: " + message);
		
		return message;
	}


	/**
	 * 요청전문내용(xml)을  encoding한다.
	 * @param object
	 * @return
	 * @throws JAXBException
	 * @throws PropertyException
	 * @throws Exception
	 */
	private String encode(Object xmlObject) throws JAXBException, PropertyException, Exception {
		
		String rawData = marshalling(xmlObject);
		
		return EncodeDecodeUtil.encode(rawData, null);
	}

	/**
	 * 요청전문 Object를 xmlString으로 반환한다.
	 * @param xmlObject
	 * @return
	 * @throws JAXBException
	 * @throws PropertyException
	 */
	
	private String marshalling(Object xmlObject) throws JAXBException, PropertyException {
		
		JAXBContext context = JAXBContext.newInstance(xmlObject.getClass());
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter st = new StringWriter(); 
		m.marshal(xmlObject, st);
		String rawData = st.toString();
		
		logger.debug("rawData : " + rawData);
		
		return rawData;
	}
	
	/**
	 * 요청전문 내용에 따른 응당전문객체타입 조회
	 * @param requestData
	 * @param responseObject
	 * @return
	 * @throws Exception 
	 */
	private Class<?> getResponseObject(Object requestData, Class<?> responseObject) throws Exception {
		
		if(requestData instanceof CRWDFSW01RQ0001M00) {
			responseObject = CRWDFSW01RS0001M00.class;
		}else if(requestData instanceof CRWDFSW01RQ0002M00) {
			responseObject = CRWDFSW01RS0002M00.class;
		}else if(requestData instanceof CRWDFSW01RQ0003M00) {
			responseObject = CRWDFSW01RS0003M00.class;
		}else {
			logger.error("KDS 전문유형이 아닙니다.");
			//throw new Exception();
			responseObject = ERRRORDETAIL.class;
		}
		
		return responseObject;
	}

	
	
	@Override
	public Response invoke(Request request) throws Exception {
		
		// 응답 Object
		Class<?> responseObject = null;
		Response response = new KdsResponse();
		
		KdsRequestData requestData = (KdsRequestData) request.getData();
		
		// 요청전물을 DB에 저장한다.
		insertRequestLog(requestData);
		
		responseObject = getResponseObject(requestData.getData(), responseObject);
		
		String urlString    = KdsClientConfig.get("kds.apiserver.url"),//service URI, refer to wsdl document above
			   namespaceURI = "http://performer.nmi.safe.ksd/",				// namespace
			   serviceName  = "NMI.receiverWS",								// serviceName
			   portType     = "NMI.receiverWSPortTypePort";					// portTypeName

		URL url = new URL(urlString);
		QName qname = new QName(namespaceURI, serviceName);						
		QName portQName = new QName(namespaceURI, portType);
        
		Service service = Service.create(url, qname);
        KdsExecutor executor = service.getPort(portQName, KdsExecutor.class);
        
        // 인코딩된 전물을 KDS에 요청하여 응답을 받는다.
        Object responseObj = null;
        
		// KDS 연계서버 호출 후 응답메세지를 받는다.
        String result = null;
        result = invoke(executor, requestData); 

        responseObj = decode(response, responseObject, result);
        
        // 응답객체를 응답객체 저장
        response.setResponseData(new KdsResponseData(responseObj));
		
        
        insertResponseLog(response);
        
        return response;
	}


	/**
	 * 요청전문 DB에저장
	 * @param response
	 */
	private void insertResponseLog(Response response) {
		
		try {
			
			ClientResponse kdsResponse = new ClientResponse();
			String responseUuid = "", requestUuid="";
			BigInteger  replSeq;
			Object tmpObj = response.getResponseData().getData();
			if(tmpObj instanceof CRWDFSW01RS0001M00 || tmpObj instanceof CRWDFSW01RS0002M00 || tmpObj instanceof CRWDFSW01RS0003M00) {
				responseUuid = ((NMIRESHEADER)response.getResponseData().getData()).getNMIRESUUID();
				requestUuid = ((NMIRESHEADER)response.getResponseData().getData()).getNMIREQUUID();
			}else {
				responseUuid = ((ERRRORDETAIL)response.getResponseData().getData()).getNMIRESUUID();
				requestUuid = ((ERRRORDETAIL)response.getResponseData().getData()).getNMIREQUUID();
			}
			
			if(tmpObj instanceof CRWDFSW01RS0001M00 ) {
				replSeq = ((CRWDFSW01RS0001M00)response.getResponseData().getData()).getREPLSEQ();
				kdsResponse.setReplSeq(replSeq.longValue());
			}
			
			if(tmpObj instanceof CRWDFSW01RS0002M00) {
				replSeq = ((CRWDFSW01RS0002M00)response.getResponseData().getData()).getREPLSEQ();
				kdsResponse.setReplSeq(replSeq.longValue());
			}
			kdsResponse.setResponseUuid(responseUuid);
	        kdsResponse.setRequestUuid(requestUuid);
	        kdsResponse.setContent(response.getResponseData().toJson());
	        
			clientResponseMapper.insertSelective(kdsResponse);
		}catch(Exception e) {
			logger.error("insertResponseLog 저장에 실패하였습니다.");
			e.printStackTrace();
		}
	}

	/**
	 * 응답전문 DB에저장
	 * @param requestData
	 */
	private void insertRequestLog(KdsRequestData requestData) {
		
		try {
			Object data = requestData.getData();
			
			String reqType = "";
//			int refId = 0;
//			if(data instanceof CRWDFSW01RQ0001M00) {
//				reqType = "1";
//			}else if(data instanceof CRWDFSW01RQ0002M00) {
//				reqType = "2";
//				String realNo = ((CRWDFSW01RQ0002M00)data).getINVSTRREALNMNO();	// 투자자실명번호
//				boolean isPersonal = "11".equals(((CRWDFSW01RQ0002M00)data).getINVSTRREALNMNOTPCD()) ? true: false;
//				logger.debug("realNo: " + realNo);
//				logger.debug("isPersonal: " + isPersonal);
//				if(isPersonal){
//					String ssn1 =realNo.substring(0, 6);
//					String ssn2 =realNo.substring(6, 13);
//					String encSsn1 = AES256Util.encWadizKey(ssn1);
//					String encSsn2 = AES256Util.encWadizKey(ssn2);;
//					TbPersonalUserInfo  userInfo = tbPersonalUserInfoMapper.selectPersonalUserInfoBySsn(encSsn1, encSsn2);
//					refId = userInfo.getUserId();
//				}else {
//					String corpRegNo = realNo;
//					TbBusinessLicenseInfo  businessLicenseInfo  =tbBusinessLicenseInfoMapper.selectBusinessLicenseInfoByCorpRegNo(corpRegNo );
//					refId = businessLicenseInfo.getRegUserId();
//				}
//			}else if(data instanceof CRWDFSW01RQ0003M00) {
//				reqType = "3";
//			}
			
			ClientRequest record = new ClientRequest();
			record.setRequestUuid(((NMIREQHEADER)requestData.getData()).getNMIREQUUID());
			record.setContent(requestData.toJson());
//			record.setRefId(refId);
			record.setType(reqType);
			
			clientRequestMapper.insertSelective(record);
			int reqSeq = record.getRequestSeq();
						
			if(data instanceof CRWDFSW01RQ0001M00) {
				((CRWDFSW01RQ0001M00)data).setREQSEQ(new BigInteger(String.valueOf(reqSeq)));
			}else if(data instanceof CRWDFSW01RQ0002M00) {
				((CRWDFSW01RQ0002M00)data).setREQSEQ(new BigInteger(String.valueOf(reqSeq)));
			}else if(data instanceof CRWDFSW01RQ0003M00) {
				((CRWDFSW01RQ0003M00)data).setREQSEQ(new BigInteger(String.valueOf(reqSeq)));
			}
			
		}catch(Exception e) {
			logger.error("insertRequestLog 저장에 실패하였습니다.");
			e.printStackTrace();
		}
	}

 
}