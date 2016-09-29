package com.wadiz.client.kds.common.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 설정파일 Config
 * @author hyunlae
 *
 */
public class KdsClientConfig {

	
	public static String get(String key) {
		
		Properties prop = new Properties();
		InputStream input = null;
		
		try {

			String filename = "kdsclient.properties";
    		input = KdsClientConfig.class.getClassLoader().getResourceAsStream(filename);
    		if(input==null){
    	            System.out.println("Sorry, unable to find " + filename);
    		    return null;
    		}

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			return prop.getProperty(key);

		} catch (IOException ex) {

			ex.printStackTrace();
			return null;
			
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		
	}
}
