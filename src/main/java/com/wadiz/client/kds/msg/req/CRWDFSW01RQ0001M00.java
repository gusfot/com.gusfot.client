//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.11 at 09:07:09 AM KST 
//


package com.wadiz.client.kds.msg.req;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * CRWDFSW01RQ0001M00 크라우드펀딩 투자자 투자한도 요청
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
 *         &lt;element name="ISSUR_BUZNO">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *               &lt;whiteSpace value="collapse"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INVSTR_REALNMNO">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *               &lt;whiteSpace value="collapse"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INVSTR_NM">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
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
    "issurbuzno",
    "invstrrealnmno",
    "invstrnm",
    "version"
})
@XmlRootElement(name = "CRWDFSW01RQ0001M00")
public class CRWDFSW01RQ0001M00
    extends NMIREQHEADER
{

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
     * 발행인사업자등록번호(ISSUR_BUZNO)
     */
    @XmlElement(name = "ISSUR_BUZNO", required = true)
    protected String issurbuzno;
    
    /**
     * 투자자실명번호(INVSTR_REALNMNO)
     */
    @XmlElement(name = "INVSTR_REALNMNO", required = true)
    protected String invstrrealnmno;
    
    /**
     * 투자자성명(INVSTR_NM)
     */
    @XmlElement(name = "INVSTR_NM", required = true)
    protected String invstrnm;
    
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
     * Gets the value of the issurbuzno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISSURBUZNO() {
        return issurbuzno;
    }

    /**
     * Sets the value of the issurbuzno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISSURBUZNO(String value) {
        this.issurbuzno = value;
    }

    /**
     * Gets the value of the invstrrealnmno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINVSTRREALNMNO() {
        return invstrrealnmno;
    }

    /**
     * Sets the value of the invstrrealnmno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINVSTRREALNMNO(String value) {
        this.invstrrealnmno = value;
    }

    /**
     * Gets the value of the invstrnm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINVSTRNM() {
        return invstrnm;
    }

    /**
     * Sets the value of the invstrnm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINVSTRNM(String value) {
        this.invstrnm = value;
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
