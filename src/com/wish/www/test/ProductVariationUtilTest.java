package com.wish.www.test;

import org.liufeng.course.util.ProductVariationUtil;

import com.wish.www.pojo.ProductVariation;

public class ProductVariationUtilTest {
	
	public static void main(String[] args) {
		String apiKey = "JHBia2RmMiQxMDAkYk8zOXYvYy5SLmk5RjhMNFg0dHhqZyRKUGVqUERJaWg1MXZSOE1yMDJYUWswVGltLmc=";
		/**
		 * parent_sku=red-shoe&
		 * sku=red-shoe-12&
		 * inventory=10&
		 * price=10&
		 * size=12&
		 * shipping=3&
		 */
		ProductVariationUtil variationUtil = new ProductVariationUtil();
		ProductVariation variation = new ProductVariation();
		variation.setParent_sku("jrrexliang-red-shoe15");
		variation.setSku("jrrexliang-red-shoe-16");
		variation.setInventory("10");
		variation.setPrice("10");
		variation.setSize("12");
		variation.setShipping("3");
		
		variationUtil.createProductVariationBoolean(variation, apiKey);
	}

}
