package com.wish.www.test;

import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.liufeng.course.util.ProductUtil;
import org.liufeng.course.util.ProductVariationUtil;
import org.liufeng.course.util.PropertiesUtil;

import com.wish.www.pojo.Product;
import com.wish.www.pojo.ProductVariation;
import com.wish.www.server.pojo.ShopCommodity;

public class ProductUtilTest {
	
	private static void retrieveProductJSONObjectTest(){
		
		ProductUtil productUtil = new ProductUtil();
		
		String productId = "545146b5bdbef32e496d64f0";
		String apiKey = "JHBia2RmMiQxMDAkYk8zOXYvYy5SLmk5RjhMNFg0dHhqZyRKUGVqUERJaWg1MXZSOE1yMDJYUWswVGltLmc=";
		
		JSONObject retrieveProduct = productUtil.retrieveProductJSONObject(productId, apiKey);
		System.out.println(retrieveProduct.getInt("code"));
	}
	
	private static void retrieveProductBooleanTest(){
		
		ProductUtil productUtil = new ProductUtil();
		
		String productId = "545146b5bdbef32e496d64f0";
		String apiKey = "JHBia2RmMiQxMDAkYk8zOXYvYy5SLmk5RjhMNFg0dHhqZyRKUGVqUERJaWg1MXZSOE1yMDJYUWswVGltLmc=";
		
		Boolean productBoolean = productUtil.retrieveProductBoolean(productId, apiKey);
		System.out.println(productBoolean);
	}
	
	private static void enableProductBooleanTest(){
		
		ProductUtil productUtil = new ProductUtil();
		
		Product product = new Product();
		product.setId("545146b5bdbef32e496d64f0");
		String apiKey = "JHBia2RmMiQxMDAkYk8zOXYvYy5SLmk5RjhMNFg0dHhqZyRKUGVqUERJaWg1MXZSOE1yMDJYUWswVGltLmc=";
		
		Boolean productBoolean = productUtil.enableProductBoolean(product, apiKey);
		System.out.println(productBoolean);
	}
	
	private static void createProductBooleanTest(String parent_sku,String product_sku,String variation_sku){
		
		ProductUtil productUtil = new ProductUtil();
		/**
		 *  Example Request:
		 *  ===========================================================================
		 * main_image=http://i.imgur.com/Q1a32kD.jpg&
		 * 	name=shoe&
		 * 	description=this is a cool shoe&
		 * 	tags=red,shoe,cool&
		 * 	sku=red-shoe-11&
		 * 	inventory=100&
		 * 	price=100&
		 * 	shipping=10&
		 * 	extra_images=http://i.imgur.com/Q1a32kD.jpg|http://i.imgur.com/Cxagv.jpg&
		 * 	parent_sku=red-shoe
		 * 	=============================================================================
		 */
		Product product = new Product();
		product.setName("shoe");
		product.setMain_image("http://i1381.photobucket.com/albums/ah226/120295690/20141017044108811804492be7-afc5-4670-8d80-a643040a0301_zps31fe60d5.png");
		product.setDescription("this is a cool shoe");
		product.setTags("red,shoe,cool");
		product.setSku(product_sku);
		product.setInventory("100");
		product.setPrice("100");
		product.setShipping("10");
		product.setShipping_time("10");
		product.setExtra_images("http://i.imgur.com/Q1a32kD.jpg|http://i.imgur.com/Cxagv.jpg");
		product.setParent_sku(parent_sku);
		String apiKey = "JHBia2RmMiQxMDAkYk8zOXYvYy5SLmk5RjhMNFg0dHhqZyRKUGVqUERJaWg1MXZSOE1yMDJYUWswVGltLmc=";
		
		System.out.println("product.setSku================================"+product.getSku());
		System.out.println("product.setParent_sku================================"+product.getParent_sku());
		
		Boolean createProductBoolean = productUtil.createProductBoolean(product, apiKey);
		System.out.println("createProductBoolean========================"+createProductBoolean);
		if (createProductBoolean) {
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
			variation.setParent_sku(product.getParent_sku());
			variation.setSku(variation_sku);
			variation.setInventory("10");
			variation.setPrice("10");
			variation.setSize("12");
			variation.setShipping("3");
			System.out.println("variation.setSku================="+variation.getSku());
			System.out.println("variation.setParent_sku================="+variation.getParent_sku());
			variationUtil.createProductVariationBoolean(variation, apiKey);
			}
	}
	
	public static void disableProductJSONObjectTest(){
		ProductUtil productUtil = new ProductUtil();
		PropertiesUtil propertiesUtil = new PropertiesUtil();
		
		Product product = new Product();
		product.setId("5451f910f8821f23704fa11a");
		JSONObject retrieveProduct = productUtil.disableProductJSONObject(product, propertiesUtil.getApiKey());
		System.out.println(retrieveProduct.getInt("code"));
	}
	
	public static void enableProductJSONObjectTest(){
		ProductUtil productUtil = new ProductUtil();
		PropertiesUtil propertiesUtil = new PropertiesUtil();
		
		//商品
		Product product = new Product();
		product.setId("5451f910f8821f23704fa11a");
		JSONObject enableProductJSONObject = productUtil.enableProductJSONObject(product, propertiesUtil.getApiKey());
		System.out.println(enableProductJSONObject.getInt("code"));
	}
	
	public static void createProductWithVariationBooleanTest(){
		PropertiesUtil propertiesUtil = new PropertiesUtil();
		ProductUtil productUtil = new ProductUtil();
		//------------------------------Util-------------------------End------------------
		String operate = "create";//Disable,Enable
		ShopCommodity commodity = new ShopCommodity();
		commodity.setId(234);
		commodity.setCommodityId("545146b5bdbef32e496d64f0");
		commodity.setCommodityName("shoe");
		commodity.setCommodityDescription("this is a cool shoe");
		commodity.setCommodityKeyword("red,shoe,cool");
		commodity.setSku(UUID.randomUUID().toString());
		commodity.setCommodityColour("red");
		commodity.setCommoditySize("42");
		commodity.setCommodityStock(12);
		commodity.setCommoditySalesPrice(12.00);
		commodity.setCommodityFreight(12.00);
		commodity.setCommodityMsrp("10.99");
//		commodity.setCommodityLogisticsTime("3");
		commodity.setCommodityPrimaryPic("http://i1381.photobucket.com/albums/ah226/120295690/20141017044108811804492be7-afc5-4670-8d80-a643040a0301_zps31fe60d5.png");
		commodity.setParentSku(UUID.randomUUID().toString());
		commodity.setCommodityBought(11);
		commodity.setCommoditySaves(90);
		System.out.println("ShopCommodity========work done");
		
		com.wish.www.server.pojo.ProductVariation variation = new com.wish.www.server.pojo.ProductVariation();
		//------------------------------ShopCommodity-------------------------End------------------
		if (operate.equals("create")) {
			Object[] shopCommodityList = {commodity};
			for (int i = 0; i < shopCommodityList.length; i++) {
				System.out.println("for ShopCommodity========work done");
				ShopCommodity shopCommodity = (ShopCommodity) shopCommodityList[i];
				System.out.println(shopCommodity);
				//商品
				Product product = new Product();
				product.setName(shopCommodity.getCommodityName());
				product.setDescription(shopCommodity.getCommodityDescription());
				product.setTags(shopCommodity.getCommodityKeyword());
				product.setSku(shopCommodity.getSku());
//				product.setColor(shopCommodity.getCommodityColour());
				product.setSize(shopCommodity.getCommoditySize());
				product.setInventory(shopCommodity.getCommodityStock().toString());
				product.setPrice(shopCommodity.getCommoditySalesPrice().toString());
				product.setShipping(shopCommodity.getCommodityFreight().toString());
				product.setMsrp(shopCommodity.getCommodityMsrp());
//				product.setShipping_time(shopCommodity.getCommodityLogisticsTime());
				product.setMain_image(shopCommodity.getCommodityPrimaryPic());
				product.setParent_sku(shopCommodity.getParentSku());
				product.setBrand("");
				product.setLanding_page_url("");
				product.setUpc("");
				product.setExtra_images("http://i.imgur.com/Q1a32kD.jpg|http://i.imgur.com/Cxagv.jpg");
				product.setNum_sold(shopCommodity.getCommodityBought().toString());
				product.setNum_saves(shopCommodity.getCommoditySaves().toString());
				product.setVariants("");
				System.out.println("product========work done");
				//商品变化
				ProductVariation productVariation = new ProductVariation();
				
				
//				productVariation.setId(shopCommodity.getId().toString());
				productVariation.setSku(UUID.randomUUID().toString());
				productVariation.setColor(shopCommodity.getCommodityColour());
				productVariation.setSize(shopCommodity.getCommoditySize());
				productVariation.setInventory(shopCommodity.getCommodityStock().toString());
				productVariation.setPrice(shopCommodity.getCommoditySalesPrice().toString());
				productVariation.setShipping(shopCommodity.getCommodityFreight().toString());
				productVariation.setMsrp(shopCommodity.getCommodityMsrp());
//				productVariation.setEnabled("");
//				productVariation.setShipping_time(shopCommodity.getCommodityLogisticsTime());
				productVariation.setMain_image(shopCommodity.getCommodityPrimaryPic());
				productVariation.setParent_sku(shopCommodity.getParentSku());
				System.out.println("ProductVariation========work done");
				Boolean createProductWithVariationBoolean = productUtil.createProductWithVariationBoolean(product, productVariation, propertiesUtil.getApiKey());
				System.out.println("createProductWithVariationBoolean============"+createProductWithVariationBoolean);
			}
		}else if(operate.equals("Update")){
			Object[] shopCommodityList = {commodity};
			for (int i = 0; i < shopCommodityList.length; i++) {
				System.out.println("for ShopCommodity========work done");
				ShopCommodity shopCommodity = (ShopCommodity) shopCommodityList[i];
				System.out.println(shopCommodity);
				//商品
				Product product = new Product();
				product.setName(shopCommodity.getCommodityName());
				product.setDescription(shopCommodity.getCommodityDescription());
				product.setTags(shopCommodity.getCommodityKeyword());
				product.setSku(shopCommodity.getSku());
				product.setColor(shopCommodity.getCommodityColour());
				product.setSize(shopCommodity.getCommoditySize());
				product.setInventory(shopCommodity.getCommodityStock().toString());
				product.setPrice(shopCommodity.getCommoditySalesPrice().toString());
				product.setShipping(shopCommodity.getCommodityFreight().toString());
				product.setMsrp(shopCommodity.getCommodityMsrp());
				product.setShipping_time(shopCommodity.getCommodityLogisticsTime());
				product.setMain_image(shopCommodity.getCommodityPrimaryPic());
				product.setParent_sku(shopCommodity.getParentSku());
				product.setBrand("");
				product.setLanding_page_url("");
				product.setUpc("");
				product.setExtra_images("http://i.imgur.com/Q1a32kD.jpg|http://i.imgur.com/Cxagv.jpg");
				product.setNum_sold(shopCommodity.getCommodityBought().toString());
				product.setNum_saves(shopCommodity.getCommoditySaves().toString());
				product.setVariants("");
				System.out.println("product========work done");
				//商品变化
				ProductVariation productVariation = new ProductVariation();
//				productVariation.setId(shopCommodity.getId().toString());
				productVariation.setSku(UUID.randomUUID().toString());
				productVariation.setColor(shopCommodity.getCommodityColour());
				productVariation.setSize(shopCommodity.getCommoditySize());
				productVariation.setInventory(shopCommodity.getCommodityStock().toString());
				productVariation.setPrice(shopCommodity.getCommoditySalesPrice().toString());
				productVariation.setShipping(shopCommodity.getCommodityFreight().toString());
				productVariation.setMsrp(shopCommodity.getCommodityMsrp());
//				productVariation.setEnabled("");
//				productVariation.setShipping_time(shopCommodity.getCommodityLogisticsTime());
				productVariation.setMain_image(shopCommodity.getCommodityPrimaryPic());
				productVariation.setParent_sku(shopCommodity.getParentSku());
				System.out.println("ProductVariation========work done");
				JSONObject updateProductJSONObject = productUtil.updateProductJSONObject(product, propertiesUtil.getApiKey());
				
				System.out.println("createProductWithVariationBoolean============"+updateProductJSONObject.getString("code"));
			}
		}else if(operate.equals("Enable")){
			Object[] shopCommodityList = {commodity};
			for (int i = 0; i < shopCommodityList.length; i++) {
				ShopCommodity shopCommodity = (ShopCommodity) shopCommodityList[i];
				//商品
				Product product = new Product();
				product.setId("5451f910f8821f23704fa11a");
				JSONObject enableProductJSONObject = productUtil.enableProductJSONObject(product, propertiesUtil.getApiKey());
				System.out.println(enableProductJSONObject.getInt("code"));
			}
		}else if(operate.equals("Disable")){
			Object[] shopCommodityList = {commodity};
			for (int i = 0; i < shopCommodityList.length; i++) {
				ShopCommodity shopCommodity = (ShopCommodity) shopCommodityList[i];
				//商品
				Product product = new Product();
				product.setId(shopCommodity.getCommodityId());
				JSONObject retrieveProduct = productUtil.disableProductJSONObject(product, propertiesUtil.getApiKey());
				System.out.println(retrieveProduct.getInt("code"));
			}
		}else if(operate.equals("Retrieve")){
			Object[] shopCommodityList = {commodity};
			for (int i = 0; i < shopCommodityList.length; i++) {
				ShopCommodity shopCommodity = (ShopCommodity) shopCommodityList[i];
				//商品
				String productId = shopCommodity.getCommodityId().toString();
				JSONObject retrieveProduct = productUtil.retrieveProductJSONObject(productId, propertiesUtil.getApiKey());
				System.out.println(retrieveProduct.getInt("code"));
			}
		}
	}

	public static void main(String[] args) {
		
//		retrieveProductJSONObjectTest();
//		
//		retrieveProductBooleanTest();
		
		createProductBooleanTest(UUID.randomUUID().toString(),UUID.randomUUID().toString(),UUID.randomUUID().toString());
		
//		enableProductBooleanTest();
		
//		createProductWithVariationBooleanTest();
		
//		disableProductJSONObjectTest();

//		enableProductJSONObjectTest();
		
	}
	
	private static String getAllImageUrl(ShopCommodity shopCommodity){
		StringBuffer stringBuffer = new StringBuffer();
		PropertiesUtil propertiesUtil = new PropertiesUtil();
		if(shopCommodity.getCommodityPic1()!=null){
			stringBuffer.append(propertiesUtil.getProjectUrl()).append(shopCommodity.getCommodityPic1()).append("|");
		}
		if(shopCommodity.getCommodityPic2()!=null){
			stringBuffer.append(propertiesUtil.getProjectUrl()).append(shopCommodity.getCommodityPic2()).append("|");
		}
		if(shopCommodity.getCommodityPic3()!=null){
			stringBuffer.append(propertiesUtil.getProjectUrl()).append(shopCommodity.getCommodityPic3()).append("|");
		}
		if(shopCommodity.getCommodityPic4()!=null){
			stringBuffer.append(propertiesUtil.getProjectUrl()).append(shopCommodity.getCommodityPic4()).append("|");
		}
		if(shopCommodity.getCommodityPic5()!=null){
			stringBuffer.append(propertiesUtil.getProjectUrl()).append(shopCommodity.getCommodityPic5()).append("|");
		}
		if(shopCommodity.getCommodityPic6()!=null){
			stringBuffer.append(propertiesUtil.getProjectUrl()).append(shopCommodity.getCommodityPic6()).append("|");
		}
		if(shopCommodity.getCommodityPic7()!=null){
			stringBuffer.append(propertiesUtil.getProjectUrl()).append(shopCommodity.getCommodityPic7()).append("|");
		}
		if(shopCommodity.getCommodityPic8()!=null){
			stringBuffer.append(propertiesUtil.getProjectUrl()).append(shopCommodity.getCommodityPic8()).append("|");
		}
		if(shopCommodity.getCommodityPic9()!=null){
			stringBuffer.append(propertiesUtil.getProjectUrl()).append(shopCommodity.getCommodityPic9()).append("|");
		}
		if(shopCommodity.getCommodityPic10()!=null){
			stringBuffer.append(propertiesUtil.getProjectUrl()).append(shopCommodity.getCommodityPic10()).append("|");
		}
		if(shopCommodity.getCommodityPic11()!=null){
			stringBuffer.append(propertiesUtil.getProjectUrl()).append(shopCommodity.getCommodityPic11()).append("|");
		}
		if(shopCommodity.getCommodityPic12()!=null){
			stringBuffer.append(propertiesUtil.getProjectUrl()).append(shopCommodity.getCommodityPic12()).append("|");
		}
		if(shopCommodity.getCommodityPic13()!=null){
			stringBuffer.append(propertiesUtil.getProjectUrl()).append(shopCommodity.getCommodityPic13()).append("|");
		}
		if(shopCommodity.getCommodityPic14()!=null){
			stringBuffer.append(propertiesUtil.getProjectUrl()).append(shopCommodity.getCommodityPic14()).append("|");
		}
		if(shopCommodity.getCommodityPic15()!=null){
			stringBuffer.append(propertiesUtil.getProjectUrl()).append(shopCommodity.getCommodityPic15()).append("|");
		}
		return stringBuffer.substring(0, stringBuffer.length()-1).toString();
	}
}
