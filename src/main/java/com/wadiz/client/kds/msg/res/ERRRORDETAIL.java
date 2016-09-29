//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.11 at 09:06:40 AM KST 
//


package com.wadiz.client.kds.msg.res;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 에러응답전문
 * <p>Java class for NMI_RES_HEADER complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ERRRORDETAIL", propOrder = {
    "nmirequuid",
    "nmiresuuid",
    "senddate",
    "processcd",
    "validexception"
})
@XmlRootElement(name = "ERRRORDETAIL")
public class ERRRORDETAIL {

	/**
	 * 요청전문식별번호(NMI_REQ_UUID)
	 */
    @XmlElement(name = "NMI_REQ_UUID", required = true)
    protected String nmirequuid;
    
    /**
	 * 응답전문식별번호(NMI_RES_UUID)
	 */
    @XmlElement(name = "NMI_RES_UUID", required = true)
    protected String nmiresuuid;
    
    /**
	 * 전문발송일시(SEND_DATE)
	 */
    @XmlElement(name = "SEND_DATE", required = true)
    protected String senddate;
    
    /**
	 * 처리결과코드(PROCESS_CD)
	 * |순번|코드번호|내용                                |비고
	 *  1  N000   정상처리
	 *	2  N100   정합성검증오류 상세내용은    VALID_EXCEPTION SET
	 *	3  N200   스키마정보 없음
	 *	4  N300   미등록 IP 오류
	 *	5  N400   업무로직 처리중 오류
	 *	6  N500   업무정지된 참가기관
	 *	7  N600   미등록 사용자
	 *	8  N700   미등록 전문오류
	 *	9  N800   미인가된 접근
	 */
    @XmlElement(name = "PROCESS_CD", required = true)
    protected String processcd;
    
    @XmlElement(name = "VALID_EXCEPTION", required = true)
    protected String validexception;
    

    /**
     * Gets the value of the nmirequuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNMIREQUUID() {
        return nmirequuid;
    }

    /**
     * Sets the value of the nmirequuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNMIREQUUID(String value) {
        this.nmirequuid = value;
    }

    /**
     * Gets the value of the nmiresuuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNMIRESUUID() {
        return nmiresuuid;
    }

    /**
     * Sets the value of the nmiresuuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNMIRESUUID(String value) {
        this.nmiresuuid = value;
    }

    /**
     * Gets the value of the senddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSENDDATE() {
        return senddate;
    }

    /**
     * Sets the value of the senddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSENDDATE(String value) {
        this.senddate = value;
    }

    /**
     * Gets the value of the processcd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROCESSCD() {
        return processcd;
    }

    /**
     * Sets the value of the processcd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROCESSCD(String value) {
        this.processcd = value;
    }

    
    /**
     * Gets the value of the validexception property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALIDEXCEPTION() {
        return validexception;
    }

    /**
     * Sets the value of the validexception property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALIDEXCEPTION(String value) {
        this.validexception = value;
    }
}
