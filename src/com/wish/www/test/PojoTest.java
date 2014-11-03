package com.wish.www.test;

import com.wish.www.pojo.Product;

public class PojoTest {

	public static void main(String[] args) {
		Product product = new Product();
		product.setName("bbb");
		product.setDescription("ccc");
		String cpo = product.createProductObject();
		System.out.println(cpo);
	}
}
