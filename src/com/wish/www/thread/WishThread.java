package com.wish.www.thread;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.liufeng.course.util.HTTPUtil;
import org.liufeng.course.util.ProductUtil;
import org.liufeng.course.util.ProductVariationUtil;
import org.liufeng.course.util.PropertiesUtil;

import com.wish.www.pojo.Product;
import com.wish.www.pojo.ProductVariation;
import com.wish.www.server.pojo.ShopCommodity;

public class WishThread extends Thread {
	private String tOperate;
	private String tShopCommodity;
	private String tProductVariation;
	public WishThread(String tOperate,String tShopCommodity,String tProductVariation) {
		this.tOperate = tOperate;
		this.tShopCommodity = tShopCommodity;
		this.tProductVariation = tProductVariation;
	}
	
	public void run() {
		System.out.println("MyThread.run()======================["+this.currentThread().getId()+"]================operate=============["+tOperate+"]");

		PropertiesUtil propertiesUtil = new PropertiesUtil();
		ProductUtil productUtil = new ProductUtil();
		ProductVariationUtil variationUtil = new ProductVariationUtil();
		JSONArray jsonArray = new JSONArray();
		//------------------------------Util-------------------------End------------------
		String operate = tOperate;;
		Object[] shopCommodityList = jsonArray.fromObject(tShopCommodity).toArray();
		Object[] productVariation = jsonArray.fromObject(tProductVariation).toArray();
		//------------------------------Param-------------------------End------------------
		if (operate.equals("create")) {
			ArrayList<ShopCommodity> sendProductList = new ArrayList<>();
			for (int i = 0; i < shopCommodityList.length; i++) {
				JSONObject element = JSONObject.fromObject(shopCommodityList[i]).element("createTime", "");
				ShopCommodity shopCommodity = (ShopCommodity) JSONObject.toBean(element, ShopCommodity.class);
				//商品
				shopCommodity.setSku(UUID.randomUUID().toString());
				shopCommodity.setParentSku(UUID.randomUUID().toString());
				Product product = new Product();
				product.setName(shopCommodity.getCommodityName());
				product.setDescription(shopCommodity.getCommodityDescription());
				product.setTags(shopCommodity.getCommodityKeyword());
				product.setSku(shopCommodity.getSku());
//				product.setColor(shopCommodity.getCommodityColour());
//				product.setSize(shopCommodity.getCommoditySize());
				product.setInventory(shopCommodity.getCommodityStock().toString());
				product.setPrice(shopCommodity.getCommoditySalesPrice().toString());
				product.setShipping(shopCommodity.getCommodityFreight().toString());
				product.setMsrp(shopCommodity.getCommodityMsrp());
				product.setShipping_time(shopCommodity.getCommodityLogisticsTime());
				product.setMain_image("http://i1381.photobucket.com/albums/ah226/120295690/20141017044108811804492be7-afc5-4670-8d80-a643040a0301_zps31fe60d5.png");
//				product.setMain_image(shopCommodity.getCommodityPrimaryPic());
				product.setParent_sku(shopCommodity.getParentSku());
				product.setBrand("");
				product.setLanding_page_url("");
				product.setUpc("");
				product.setExtra_images("http://i.imgur.com/Q1a32kD.jpg|http://i.imgur.com/Cxagv.jpg");
//				product.setExtra_images(this.getAllImageUrl(shopCommodity));
				product.setNum_sold(shopCommodity.getCommodityBought().toString());
				product.setNum_saves(shopCommodity.getCommoditySaves().toString());
				product.setVariants("");
				JSONObject productJSONObject = productUtil.createProductJSONObject(product, propertiesUtil.getApiKey());
				
				if (null !=productJSONObject) {
					int code = productJSONObject.getInt("code");
					if (0 == code) {
						String string = productJSONObject.getJSONObject("data").getJSONObject("Product").getString("id");
						shopCommodity.setCommodityId(string);
						ArrayList<com.wish.www.server.pojo.ProductVariation> sendProductVariationList = new ArrayList<com.wish.www.server.pojo.ProductVariation>();
						Boolean vpstate = false;
						for (int j = 0; j < productVariation.length; j++) {
							com.wish.www.server.pojo.ProductVariation variation = (com.wish.www.server.pojo.ProductVariation) JSONObject.toBean(JSONObject.fromObject(productVariation[j]), com.wish.www.server.pojo.ProductVariation.class);
							//商品变化
							variation.setSku(UUID.randomUUID().toString());
							ProductVariation wishproductVariation = new ProductVariation();
							wishproductVariation.setSku(variation.getSku());
							wishproductVariation.setColor(variation.getColor());
							wishproductVariation.setSize(variation.getSize());
							wishproductVariation.setInventory(variation.getInventory());
							wishproductVariation.setPrice(variation.getPrice());
							wishproductVariation.setShipping(variation.getShipping());
							wishproductVariation.setMsrp(variation.getMsrp());
							wishproductVariation.setShipping_time(variation.getShipping_time());
							wishproductVariation.setMain_image(variation.getMain_image());
							wishproductVariation.setParent_sku(shopCommodity.getParentSku());
							System.out.println("ProductVariation========work done");
							JSONObject variationJSONObject = variationUtil.createProductVariationJSONObject(wishproductVariation, propertiesUtil.getApiKey());
							if (null != variationJSONObject) {
								int variationCode = variationJSONObject.getInt("code");
								if (0 == variationCode) {
									String wishId = variationJSONObject.getJSONObject("data").getJSONObject("Variant").getString("id");
									variation.setWish_id(wishId);
									sendProductVariationList.add(variation);
									vpstate = true;
								}else{
									vpstate = false;
								}
							}
							Random rand =new Random(18);
							int nextInt = rand.nextInt(3000);
							try {
								Thread.sleep(nextInt);
							} catch (InterruptedException e) {
								vpstate = false;
							}
						}
						if (vpstate) {
							shopCommodity.setShopCommodityState(1);
							sendProductList.add(shopCommodity);
							HTTPUtil.sendPost("http://192.168.1.110:8080/wish/server/editShopProduct/","shopCommodity="+jsonArray.fromObject(sendProductList).toString()+"&productVariation="+jsonArray.fromObject(sendProductVariationList).toString());
						}else{
							shopCommodity.setShopCommodityState(2);
							sendProductList.add(shopCommodity);
							HTTPUtil.sendPost("http://192.168.1.110:8080/wish/server/editShopProduct/","shopCommodity="+jsonArray.fromObject(sendProductList).toString()+"&productVariation="+jsonArray.fromObject(sendProductVariationList).toString());
						}
					} else {
						shopCommodity.setShopCommodityState(3);
						sendProductList.add(shopCommodity);
						HTTPUtil.sendPost("http://192.168.1.110:8080/wish/server/editShopProduct/","shopCommodity="+jsonArray.fromObject(sendProductList).toString()+"&productVariation=");
					}
				}
			}
		}else if(operate.equals("update")){
			ArrayList<ShopCommodity> sendProductList = new ArrayList<>();
			for (int i = 0; i < shopCommodityList.length; i++) {
				JSONObject element = JSONObject.fromObject(shopCommodityList[i]).element("createTime", "");
				ShopCommodity shopCommodity = (ShopCommodity) JSONObject.toBean(element, ShopCommodity.class);
				//商品
				Product product = new Product();
				product.setId(shopCommodity.getCommodityId());
				product.setName(shopCommodity.getCommodityName());
				product.setDescription(shopCommodity.getCommodityDescription());
				product.setTags(shopCommodity.getCommodityKeyword());
				product.setSku(shopCommodity.getSku());
//				product.setColor(shopCommodity.getCommodityColour());
//				product.setSize(shopCommodity.getCommoditySize());
				product.setInventory(shopCommodity.getCommodityStock().toString());
				product.setPrice(shopCommodity.getCommoditySalesPrice().toString());
				product.setShipping(shopCommodity.getCommodityFreight().toString());
				product.setMsrp(shopCommodity.getCommodityMsrp());
				product.setShipping_time(shopCommodity.getCommodityLogisticsTime());
				product.setMain_image("http://i1381.photobucket.com/albums/ah226/120295690/20141017044108811804492be7-afc5-4670-8d80-a643040a0301_zps31fe60d5.png");
				product.setMain_image(shopCommodity.getCommodityPrimaryPic());
				product.setParent_sku(shopCommodity.getParentSku());
				product.setBrand("");
				product.setLanding_page_url("");
				product.setUpc("");
//				product.setExtra_images("http://i.imgur.com/Q1a32kD.jpg|http://i.imgur.com/Cxagv.jpg");
				product.setExtra_images(this.getAllImageUrl(shopCommodity));
				product.setNum_sold(shopCommodity.getCommodityBought().toString());
				product.setNum_saves(shopCommodity.getCommoditySaves().toString());
				product.setVariants("");
				JSONObject productJSONObject = productUtil.updateProductJSONObject(product, propertiesUtil.getApiKey());
				
				if (null !=productJSONObject) {
					int code = productJSONObject.getInt("code");
					if (0 == code) {
						String string = productJSONObject.getJSONObject("data").getJSONObject("Product").getString("id");
						shopCommodity.setCommodityId(string);
						ArrayList<com.wish.www.server.pojo.ProductVariation> sendProductVariationList = new ArrayList<com.wish.www.server.pojo.ProductVariation>();
						Boolean vpstate = false;
						for (int j = 0; j < productVariation.length; j++) {
							com.wish.www.server.pojo.ProductVariation variation = (com.wish.www.server.pojo.ProductVariation) JSONObject.toBean(JSONObject.fromObject(productVariation[j]), com.wish.www.server.pojo.ProductVariation.class);
							//商品变化
							variation.setSku(UUID.randomUUID().toString());
							ProductVariation wishproductVariation = new ProductVariation();
							wishproductVariation.setId(variation.getWish_id());
							wishproductVariation.setSku(variation.getSku());
							wishproductVariation.setColor(variation.getColor());
							wishproductVariation.setSize(variation.getSize());
							wishproductVariation.setInventory(variation.getInventory());
							wishproductVariation.setPrice(variation.getPrice());
							wishproductVariation.setShipping(variation.getShipping());
							wishproductVariation.setMsrp(variation.getMsrp());
							wishproductVariation.setShipping_time(variation.getShipping_time());
							wishproductVariation.setMain_image(variation.getMain_image());
							wishproductVariation.setParent_sku(shopCommodity.getParentSku());
							System.out.println("ProductVariation========work done");
							JSONObject variationJSONObject = variationUtil.updateProductVariationJSONObject(wishproductVariation, propertiesUtil.getApiKey());
							if (null != variationJSONObject) {
								int variationCode = variationJSONObject.getInt("code");
								if (0 == variationCode) {
									String wishId = variationJSONObject.getJSONObject("data").getJSONObject("Variant").getString("id");
									variation.setWish_id(wishId);
									sendProductVariationList.add(variation);
									vpstate = true;
								}else{
									vpstate = false;
								}
							}
							Random rand =new Random(18);
							int nextInt = rand.nextInt(3000);
							try {
								Thread.sleep(nextInt);
							} catch (InterruptedException e) {
								vpstate = false;
							}
						}
						if (vpstate) {
							shopCommodity.setShopCommodityState(1);
							sendProductList.add(shopCommodity);
							HTTPUtil.sendPost("http://192.168.1.110:8080/wish/server/editShopProduct/","shopCommodity="+jsonArray.fromObject(sendProductList).toString()+"&productVariation="+jsonArray.fromObject(sendProductVariationList).toString());
						}else{
							shopCommodity.setShopCommodityState(2);
							sendProductList.add(shopCommodity);
							HTTPUtil.sendPost("http://192.168.1.110:8080/wish/server/editShopProduct/","shopCommodity="+jsonArray.fromObject(sendProductList).toString()+"&productVariation="+jsonArray.fromObject(sendProductVariationList).toString());
						}
					} else {
						shopCommodity.setShopCommodityState(3);
						sendProductList.add(shopCommodity);
						HTTPUtil.sendPost("http://192.168.1.110:8080/wish/server/editShopProduct/","shopCommodity="+jsonArray.fromObject(sendProductList).toString()+"&productVariation=");
					}
				}
			}
		}else if(operate.equals("enable")){

			ArrayList<ShopCommodity> sendProductList = new ArrayList<>();
			for (int i = 0; i < shopCommodityList.length; i++) {
				JSONObject element = JSONObject.fromObject(shopCommodityList[i]).element("createTime", "");
				ShopCommodity shopCommodity = (ShopCommodity) JSONObject.toBean(element, ShopCommodity.class);
				//商品
				Product product = new Product();
				product.setId(shopCommodity.getCommodityId().toString());
				JSONObject enableProductJSONObject = productUtil.enableProductJSONObject(product, propertiesUtil.getApiKey());
				
				if (null !=enableProductJSONObject) {
					int code = enableProductJSONObject.getInt("code");
					if (0 == code) {
						ArrayList<com.wish.www.server.pojo.ProductVariation> sendProductVariationList = new ArrayList<com.wish.www.server.pojo.ProductVariation>();
						Boolean vpstate = false;
						for (int j = 0; j < productVariation.length; j++) {
							com.wish.www.server.pojo.ProductVariation variation = (com.wish.www.server.pojo.ProductVariation) JSONObject.toBean(JSONObject.fromObject(productVariation[j]), com.wish.www.server.pojo.ProductVariation.class);
							//商品变化
							ProductVariation wishproductVariation = new ProductVariation();
							wishproductVariation.setId(variation.getWish_id());
							wishproductVariation.setSku(variation.getSku());
							System.out.println("ProductVariation========work done");
							JSONObject variationJSONObject = variationUtil.enableProductVariationJSONObject(wishproductVariation, propertiesUtil.getApiKey());
							if (null != variationJSONObject) {
								int variationCode = variationJSONObject.getInt("code");
								if (0 == variationCode) {
									variation.setEnabled("true");
									sendProductVariationList.add(variation);
									vpstate = true;
								}else{
									vpstate = false;
								}
							}
							Random rand =new Random(18);
							int nextInt = rand.nextInt(3000);
							try {
								Thread.sleep(nextInt);
							} catch (InterruptedException e) {
								vpstate = false;
							}
						}
						if (vpstate) {
							shopCommodity.setShopCommodityState(4);
							shopCommodity.setCommodityIsEnable(1);
							sendProductList.add(shopCommodity);
							HTTPUtil.sendPost("http://192.168.1.110:8080/wish/server/editShopProduct/","shopCommodity="+jsonArray.fromObject(sendProductList).toString()+"&productVariation="+jsonArray.fromObject(sendProductVariationList).toString());
						}else{
							shopCommodity.setShopCommodityState(2);
							shopCommodity.setCommodityIsEnable(0);
							sendProductList.add(shopCommodity);
							HTTPUtil.sendPost("http://192.168.1.110:8080/wish/server/editShopProduct/","shopCommodity="+jsonArray.fromObject(sendProductList).toString()+"&productVariation="+jsonArray.fromObject(sendProductVariationList).toString());
						}
					} else {
						shopCommodity.setShopCommodityState(3);
						shopCommodity.setCommodityIsEnable(0);
						sendProductList.add(shopCommodity);
						HTTPUtil.sendPost("http://192.168.1.110:8080/wish/server/editShopProduct/","shopCommodity="+jsonArray.fromObject(sendProductList).toString()+"&productVariation=");
					}
				}
			}
		
		}else if(operate.equals("disable")){

			ArrayList<ShopCommodity> sendProductList = new ArrayList<>();
			for (int i = 0; i < shopCommodityList.length; i++) {
				JSONObject element = JSONObject.fromObject(shopCommodityList[i]).element("createTime", "");
				ShopCommodity shopCommodity = (ShopCommodity) JSONObject.toBean(element, ShopCommodity.class);
				//商品
				Product product = new Product();
				product.setId(shopCommodity.getCommodityId().toString());
				JSONObject enableProductJSONObject = productUtil.disableProductJSONObject(product, propertiesUtil.getApiKey());
				
				if (null !=enableProductJSONObject) {
					int code = enableProductJSONObject.getInt("code");
					if (0 == code) {
						ArrayList<com.wish.www.server.pojo.ProductVariation> sendProductVariationList = new ArrayList<com.wish.www.server.pojo.ProductVariation>();
						Boolean vpstate = false;
						for (int j = 0; j < productVariation.length; j++) {
							com.wish.www.server.pojo.ProductVariation variation = (com.wish.www.server.pojo.ProductVariation) JSONObject.toBean(JSONObject.fromObject(productVariation[j]), com.wish.www.server.pojo.ProductVariation.class);
							//商品变化
							ProductVariation wishproductVariation = new ProductVariation();
							wishproductVariation.setId(variation.getWish_id());
							wishproductVariation.setSku(variation.getSku());
							System.out.println("ProductVariation========work done");
							JSONObject variationJSONObject = variationUtil.disableProductVariationJSONObject(wishproductVariation, propertiesUtil.getApiKey());
							if (null != variationJSONObject) {
								int variationCode = variationJSONObject.getInt("code");
								if (0 == variationCode) {
									variation.setEnabled("false");
									sendProductVariationList.add(variation);
									vpstate = true;
								}else{
									vpstate = false;
								}
							}
							Random rand =new Random(18);
							int nextInt = rand.nextInt(3000);
							try {
								Thread.sleep(nextInt);
							} catch (InterruptedException e) {
								vpstate = false;
							}
						}
						if (vpstate) {
							shopCommodity.setShopCommodityState(5);
							shopCommodity.setCommodityIsEnable(0);
							sendProductList.add(shopCommodity);
							HTTPUtil.sendPost("http://192.168.1.110:8080/wish/server/editShopProduct/","shopCommodity="+jsonArray.fromObject(sendProductList).toString()+"&productVariation="+jsonArray.fromObject(sendProductVariationList).toString());
						}else{
							shopCommodity.setShopCommodityState(2);
							shopCommodity.setCommodityIsEnable(0);
							sendProductList.add(shopCommodity);
							HTTPUtil.sendPost("http://192.168.1.110:8080/wish/server/editShopProduct/","shopCommodity="+jsonArray.fromObject(sendProductList).toString()+"&productVariation="+jsonArray.fromObject(sendProductVariationList).toString());
						}
					} else {
						shopCommodity.setShopCommodityState(3);
						shopCommodity.setCommodityIsEnable(0);
						sendProductList.add(shopCommodity);
						HTTPUtil.sendPost("http://192.168.1.110:8080/wish/server/editShopProduct/","shopCommodity="+jsonArray.fromObject(sendProductList).toString()+"&productVariation=");
					}
				}
			}
		
		}
			
	
	}
	
	
	private String getAllImageUrl(ShopCommodity shopCommodity){
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
