package com.wadiz.client.kds.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * @author 황진광 2015-12-03
 *
 */
public class EncodeDecodeUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(EncodeDecodeUtil.class);
	
    /**
     * SOAP Body를 압축, 인코딩한다.
     *
     * @param   srcBytes        바이트 배열.
     * @return  압축, 인코딩된 스트링. 
     */
    public static String encodeSOAPBody(byte[] srcBytes) throws Exception {
        String result = "";
        try {

            logger.debug("[Base64GZip.encodeSOAPBody] ### START : encodeSOAPBody");
            int bodyStartInx = getSoapBodyStartInx(srcBytes);
            int bodyLastInx = getSoapBodyLastInx(srcBytes);

            byte[] buf = new byte[1024];
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream out = new GZIPOutputStream(bos);
            ByteArrayInputStream in = new ByteArrayInputStream(srcBytes,bodyStartInx, (bodyLastInx - bodyStartInx));
            try {
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            } catch(IOException e) {
            	logger.error( "[Base64GZip.encodeSOAPBody] Exception Occured.", e);
            } finally {
                if ( out != null ) out.close();
                if ( in != null ) in.close();
                srcBytes = null;
            }

            byte[] compressedData = bos.toByteArray();
            
            logger.debug("[Base64GZip.encodeSOAPBody] ### encode GZIPping ###############");

            BASE64Encoder encoder = new BASE64Encoder();
            result = encoder.encodeBuffer(compressedData);

        	logger.debug("[Base64GZip.encodeSOAPBody] ### encode base64 ################");
        	logger.debug("[Base64GZip.encodeSOAPBody] "+result);
        	logger.debug("[Base64GZip.encodeSOAPBody] ### END of Encoding #######\n");
        	
            try {
                bos.close();
            } catch (IOException e) {
            	logger.error( "[Base64GZip.encodeSOAPBody] Exception Occured.", e);
            }
        } catch(Exception ex) {
        	
        	logger.error("[Base64GZip.encodeSOAPBody] Exception", ex);
            
        	return "";
        }
        
        return result;
    }
    /**
     * 문자셋을 반영한 문자열을 압축, 인코딩한다.
     *
     * @param   srcStr          문자열.
     * @param   Etype           문자셋.
     * @return  압축, 인코딩된 스트링.
     */
    public static String encode(String srcStr,String Etype) throws Exception  {
        try {
            if(Etype==null) {
                try {
                	Etype = "UTF-8";
//                    Etype = XMLConfiguration.getInstance().get( "/proworks/WAS/characterSet" );
                    if( Etype == null || Etype.length() == 0 ) {
                        Etype="EUC-KR";
                    }
                } catch( Exception ee ) {
                    Etype="EUC-KR";
                    logger.error("[Base64GZip.encode] XMLConfiguration Exception. Use default Encoding Type [EUC-KR]", ee );

                }
            }
            logger.debug("[Base64GZip.encode] encoding " + Etype);
            byte[] input = srcStr.getBytes(Etype);
            return encodeFromByte(input);
        } catch(Exception ex) {
        	logger.debug("[Base64GZip.encode] Exception", ex);
            return "";
        }
    }
    /**
     * 바이트 배열을 스트링으로 압축, 인코딩한다.
     *
     * @param   srcBytes        바이트 배열.
     * @return  압축, 인코딩된 스트링. 
     */
    public static String encodeFromByte(byte[] srcBytes) throws Exception {
        String result = "";
        try {

        	logger.debug("[Base64GZip.encodeFromByte] ### START : encodeGZIP64");

            byte[] buf = new byte[1024];
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream out = new GZIPOutputStream(bos);
            ByteArrayInputStream in = new ByteArrayInputStream(srcBytes);
            try {
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                if ( out != null ) out.close();
                if ( in != null ) in.close();
            } catch(IOException e) {
            	logger.error( "[Base64GZip.encodeFromByte] Exception Occured.", e);
            }

            byte[] compressedData = bos.toByteArray();
            
            logger.debug("[Base64GZip.encodeFromByte] ### encode GZIPping ###############");

            BASE64Encoder encoder = new BASE64Encoder();
            result = encoder.encodeBuffer(compressedData);

            logger.debug("[Base64GZip.encodeFromByte] ### encode base64 ################");
            logger.debug("[Base64GZip.encodeFromByte] "+result);
            logger.debug("[Base64GZip.encodeFromByte] ### END of Encoding #######\n");
            
            try {
                bos.close();
            } catch (IOException e) {
            	logger.debug( "[Base64GZip.encodeFromByte] Exception Occured.", e);
            }
        } catch(Exception ex) {
        	logger.debug("[Base64GZip.encodeFromByte] Exception", ex);
            return "";
        }
        return result;
    }

    public static int getSoapBodyStartInx(byte[] soap) {
        int bodyStartInx = 0;
        String buffer = "";
        for (int i=0; i<soap.length; i++) {
            buffer += (char)soap[i];
            if ( soap[i] == 62 ) {
                if ( buffer.indexOf("ody>") > -1 ) {
                    bodyStartInx = i + 1;
                    break;
                }
                buffer = "";
            }
        }
        return bodyStartInx;
    }

    public static int getSoapBodyLastInx(byte[] soap) {
        int bodyLastInx = 0;
        String buffer = "";
        for (int i=soap.length-1; i > 0; i--) {
          buffer += (char)soap[i];
          if ( soap[i] == 60 ) {
              if ( buffer.indexOf(">ydo") > -1 ) {
                  bodyLastInx = i;
                  break;
              }
              buffer = "";
          }
        }
        return bodyLastInx;
    }  
    /**
     * 문자셋을 반영한 문자열을 압축해재, 디코딩한다.
     *
     * @param   srcStr          문자열.
     * @param   Etype           문자셋.
     * @return  압축해재, 디코딩된 스트링.
     */
    public static String decode(String srcStr,String Etype) throws Exception  {
        String result ="";
        if(Etype==null) {
            try {
            	Etype = "UTF-8";
//                Etype = XMLConfiguration.getInstance().get( "/proworks/WAS/characterSet" );
                if( Etype == null || Etype.length() == 0 ) {
                    Etype="EUC-KR";
                }
            } catch( Exception ee ) {
                Etype="EUC-KR";
                logger.error("[Base64GZip.decode] XMLConfiguration Exception. Use default Encoding Type [EUC-KR]", ee );

            }
        }
        logger.debug("[Base64GZip.decode] encoding " + Etype);

        result = new String(decodeToByte(srcStr),Etype);
        logger.debug("[Base64GZip.decode] result\n " + result);
        return result;
    }
    
    /**
     * 스트링을 바이트 배열로 압축해재, 디코딩한다.
     *
     * @param   srcStr      스트링.
     * @return  압축해재, 디코딩된 바이트 배열.
     */
    public static byte[] decodeToByte(String srcStr) throws Exception {
        byte[] decompressedData;
        try {
        	
        	logger.debug("[Base64GZip.decodeToByte] ### START : decode64GZIP");
        	logger.debug("[Base64GZip.decodeToByte] "+"SOURCE STRING\n    "+srcStr);
            
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] meta = decoder.decodeBuffer(srcStr);
            logger.debug("[Base64GZip.decodeToByte] ### decode base64 ################");

            ByteArrayInputStream bis = new ByteArrayInputStream(meta);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPInputStream in = new GZIPInputStream(bis); 
            try {
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    bos.write(buf, 0, len);
                }
            } catch (IOException e) {
            	logger.debug( "[Base64GZip.decodeToByte] Exception Occured.", e);
            } finally {
                try { if(in != null) in.close(); } catch (Exception e) {}
                try { if(bis != null) bis.close(); } catch (Exception e) {}
            }

            decompressedData = bos.toByteArray();

            try {
                bos.close();
            } catch (IOException e) {
            	logger.debug( "[Base64GZip.decodeToByte] Exception Occured.", e);
            }
        } catch(Exception ex) {
        	logger.debug("[Base64GZip.decodeToByte] Exception", ex);
            return null;
        }
        return decompressedData;
    }
}
