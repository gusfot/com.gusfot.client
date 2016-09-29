//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.11 at 09:07:28 AM KST 
//


package com.wadiz.client.kds.msg.req;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wadiz.client.kds.common.config.KdsClientConfig;


/**
 * CRWDFSW01RQ0003M00 크라우드펀딩 계좌유효성 확인 결과 요청
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}NMI_REQ_HEADER">
 *       &lt;sequence>
 *         &lt;element name="RQ_ACOPNO">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;totalDigits value="6"/>
 *               &lt;whiteSpace value="collapse"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RQ_ACOPSEQ">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *               &lt;whiteSpace value="collapse"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="REQ_SEQ">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;totalDigits value="10"/>
 *               &lt;whiteSpace value="collapse"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SUBS_ASK_PROC_DT">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;totalDigits value="10"/>
 *               &lt;whiteSpace value="collapse"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SUBS_ASK_PROC_SEQ">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;totalDigits value="10"/>
 *               &lt;whiteSpace value="collapse"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="VERSION" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rqacopno",
    "rqacopseq",
    "reqseq",
    "subsaskprocdt",
    "subsaskprocseq",
    "version"
})
@XmlRootElement(name = "CRWDFSW01RQ0003M00")
public class CRWDFSW01RQ0003M00
    extends NMIREQHEADER
{

	public CRWDFSW01RQ0003M00() {
		this.rqacopno = new BigInteger(KdsClientConfig.get("req.rqacopno"));
		this.rqacopseq = KdsClientConfig.get("req.rqacopno");
	}
	/**
	 * 요청계좌개설자번호(RQ_ACOPNO)
	 */
    @XmlElement(name = "RQ_ACOPNO", required = true)
    protected BigInteger rqacopno;
    
    /**
     * 요청계좌개설일련번호(RQ_ACOPSEQ)
     */
    @XmlElement(name = "RQ_ACOPSEQ", required = true)
    protected String rqacopseq;
    
    /**
     * 요청일련번호(REQ_SEQ)
     */
    @XmlElement(name = "REQ_SEQ", required = true)
    protected BigInteger reqseq;
    
    /**
     * 청약신청처리일자(SUBS_ASK_PROC_DT)
     */
    @XmlElement(name = "SUBS_ASK_PROC_DT", required = true)
    protected BigInteger subsaskprocdt;
    
    /**
     * 청약신청처리일련번호(SUBS_ASK_PROC_SEQ)
     */
    @XmlElement(name = "SUBS_ASK_PROC_SEQ", required = true)
    protected BigInteger subsaskprocseq;
    
    /**
     * 버젼(VERSION)
     */
    @XmlElement(name = "VERSION", required = true)
    protected String version;

    /**
     * Gets the value of the rqacopno property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRQACOPNO() {
        return rqacopno;
    }

    /**
     * Sets the value of the rqacopno property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRQACOPNO(BigInteger value) {
        this.rqacopno = value;
    }

    /**
     * Gets the value of the rqacopseq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRQACOPSEQ() {
        return rqacopseq;
    }

    /**
     * Sets the value of the rqacopseq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRQACOPSEQ(String value) {
        this.rqacopseq = value;
    }

    /**
     * Gets the value of the reqseq property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getREQSEQ() {
        return reqseq;
    }

    /**
     * Sets the value of the reqseq property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setREQSEQ(BigInteger value) {
        this.reqseq = value;
    }

    /**
     * Gets the value of the subsaskprocdt property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSUBSASKPROCDT() {
        return subsaskprocdt;
    }

    /**
     * Sets the value of the subsaskprocdt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSUBSASKPROCDT(BigInteger value) {
        this.subsaskprocdt = value;
    }

    /**
     * Gets the value of the subsaskprocseq property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSUBSASKPROCSEQ() {
        return subsaskprocseq;
    }

    /**
     * Sets the value of the subsaskprocseq property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSUBSASKPROCSEQ(BigInteger value) {
        this.subsaskprocseq = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVERSION() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVERSION(String value) {
        this.version = value;
    }

}
