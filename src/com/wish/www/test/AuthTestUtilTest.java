package com.wish.www.test;

import org.liufeng.course.util.AuthTestUtil;

public class AuthTestUtilTest {

	public static void main(String[] args) {

		String apiKey = "JHBia2RmMiQxMDAkYk8zOXYvYy5SLmk5RjhMNFg0dHhqZyRKUGVqUERJaWg1MXZSOE1yMDJYUWswVGltLmc=a";

		AuthTestUtil authTestUtil = new AuthTestUtil();
		
		Boolean authTestBoolean = authTestUtil.authTestBoolean(apiKey);
		
		System.out.println("authTestBoolean=======["+authTestBoolean+"]");
		
	}

}
