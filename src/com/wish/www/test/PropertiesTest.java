package com.wish.www.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	
	public static void main(String[] args) {
		
		Properties prop = new Properties();
		InputStream in = Object.class.getResourceAsStream("/wish2url.properties"); 
		 try {   
	            prop.load(in);   
	            String base_url = prop.getProperty("auth_test").trim();
	            System.out.println(base_url);
	        } catch (IOException e) {   
	            e.printStackTrace();   
	        }
	}

}
