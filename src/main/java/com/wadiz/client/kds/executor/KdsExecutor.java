package com.wadiz.client.kds.executor;
 
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.ResponseWrapper;
import javax.xml.ws.WebFault;
 
//Service Endpoint Interface
@WebService(name="NMI.receiverWS", serviceName="NMI.receiverWS",portName="NMI.receiverWSPortTypePort",
			wsdlLocation="https://safeplus.ksd.or.kr/webservices/NMI.receiverWS?wsdl",
			targetNamespace="http://performer.nmi.safe.ksd/")
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
@WebFault(messageName="Exception")
public interface KdsExecutor {
 
	@ResponseWrapper(localName="executeResponse",targetNamespace="http://performer.nmi.safe.ksd/")
	@WebMethod(operationName="execute") 
	String execute(String name);

}