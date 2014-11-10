package com.wish.www.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.liufeng.course.util.ProductUtil;
import org.liufeng.course.util.ProductVariationUtil;

import com.wish.www.pojo.Product;
import com.wish.www.pojo.ProductVariation;
import com.wish.www.rmi.WishServer;
import com.wish.www.server.pojo.ShopCommodity;

public class WishServerIMP extends UnicastRemoteObject implements WishServer {  
	
    public WishServerIMP() throws RemoteException {  
        super();  
        // TODO Auto-generated constructor stub  
    }  
    
	@Override
	public int test() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * 
     * @param tShopCommodity 店铺商品List
     * @param tProductVariation 商品变量List
     * @param wishKey wishKey
     */
    @Override
	public String createProduct(String tShopCommodity,String tProductVariation,String wishKey) throws RemoteException{
		ProductUtil productUtil = new ProductUtil();
		ProductVariationUtil variationUtil = new ProductVariationUtil();
		JSONArray jsonArray = new JSONArray();
		//------------------------------Util-------------------------End------------------
		Object[] shopCommodityList = jsonArray.fromObject(tShopCommodity).toArray();
		Object[] productVariation = jsonArray.fromObject(tProductVariation).toArray();
		//------------------------------Param-------------------------End------------------

		for (int i = 0; i < shopCommodityList.length; i++) {
			ArrayList<ShopCommodity> sendProductList = new ArrayList<>();
			JSONObject element = JSONObject.fromObject(shopCommodityList[i]).element("createTime", "");
			ShopCommodity shopCommodity = (ShopCommodity) JSONObject.toBean(element, ShopCommodity.class);
			//商品
//			shopCommodity.setSku(UUID.randomUUID().toString());
//			shopCommodity.setParentSku(UUID.randomUUID().toString());
			Product product = new Product();
			product.setName(shopCommodity.getCommodityName());
			product.setDescription(shopCommodity.getCommodityDescription());
			product.setTags(shopCommodity.getCommodityKeyword());
			product.setSku(shopCommodity.getSku());
//			product.setColor(shopCommodity.getCommodityColour());
//			product.setSize(shopCommodity.getCommoditySize());
			product.setInventory(shopCommodity.getCommodityStock().toString());
			product.setPrice(shopCommodity.getCommoditySalesPrice().toString());
			product.setShipping(shopCommodity.getCommodityFreight().toString());
			product.setMsrp(shopCommodity.getCommodityMsrp());
			product.setShipping_time(shopCommodity.getCommodityLogisticsTime());
//			product.setMain_image("http://i1381.photobucket.com/albums/ah226/120295690/20141017044108811804492be7-afc5-4670-8d80-a643040a0301_zps31fe60d5.png");
//			product.setMain_image("http://121.40.193.132:8080/wish"+shopCommodity.getCommodityPrimaryPic());
			product.setMain_image(shopCommodity.getCommodityPrimaryPic());
			product.setParent_sku(shopCommodity.getParentSku());
			product.setBrand("");
			product.setLanding_page_url("");
			product.setUpc("");
			product.setExtra_images("http://i.imgur.com/Q1a32kD.jpg|http://i.imgur.com/Cxagv.jpg");
//			product.setExtra_images(this.getAllImageUrl(shopCommodity));
			product.setNum_sold(shopCommodity.getCommodityBought().toString());
			product.setNum_saves(shopCommodity.getCommoditySaves().toString());
			product.setVariants("");
			JSONObject productJSONObject = productUtil.createProductJSONObject(product, wishKey);
			
			if (null !=productJSONObject) {
				int code = productJSONObject.getInt("code");
				if (0 == code) {
					String string = productJSONObject.getJSONObject("data").getJSONObject("Product").getString("id");
					shopCommodity.setCommodityId(string);
					Boolean vpstate = false;
					ArrayList<com.wish.www.server.pojo.ProductVariation> sendProductVariationList = new ArrayList<com.wish.www.server.pojo.ProductVariation>();
					for (int j = 0; j < productVariation.length; j++) {
						com.wish.www.server.pojo.ProductVariation variation = (com.wish.www.server.pojo.ProductVariation) JSONObject.toBean(JSONObject.fromObject(productVariation[j]), com.wish.www.server.pojo.ProductVariation.class);
						//商品变化
//						variation.setSku(UUID.randomUUID().toString());
						ProductVariation wishproductVariation = new ProductVariation();
						wishproductVariation.setSku(variation.getSku());
						wishproductVariation.setColor(variation.getColor());
						wishproductVariation.setSize(variation.getSize());
						wishproductVariation.setInventory(variation.getInventory());
						wishproductVariation.setPrice(variation.getPrice());
						wishproductVariation.setShipping(variation.getShipping());
						wishproductVariation.setMsrp(variation.getMsrp());
						wishproductVariation.setShipping_time(variation.getShipping_time());
//						wishproductVariation.setMain_image("http://121.40.193.132:8080/wish"+variation.getMain_image());
						wishproductVariation.setMain_image(variation.getMain_image());
						wishproductVariation.setParent_sku(shopCommodity.getParentSku());
						System.out.println("ProductVariation========work done");
						JSONObject variationJSONObject = variationUtil.createProductVariationJSONObject(wishproductVariation, wishKey);
						if (null != variationJSONObject) {
							int variationCode = variationJSONObject.getInt("code");
							if (0 == variationCode) {
								String wishId = variationJSONObject.getJSONObject("data").getJSONObject("Variant").getString("id");
								variation.setWish_id(wishId);
								variation.setParent_sku(shopCommodity.getParentSku());
								sendProductVariationList.add(variation);
								vpstate = true;
							}else{
								vpstate = false;
							}
						}
						Random rand =new Random(18);
						int nextInt = rand.nextInt(2000);
						try {
							Thread.sleep(nextInt);
						} catch (InterruptedException e) {
							vpstate = false;
						}
					}
					if (vpstate) {
						shopCommodity.setShopCommodityState(1);
						shopCommodity.setUpTime(null);
						shopCommodity.setUpdateTime(null);
						shopCommodity.setDownTime(null);
						shopCommodity.setCreateTime(null);
						sendProductList.add(shopCommodity);
						return "{\"shopCommodity\":"+JSONArray.fromObject(sendProductList).toString()+",\"productVariation\":"+JSONArray.fromObject(sendProductVariationList).toString()+"}";
					}else{
						shopCommodity.setShopCommodityState(2);
						shopCommodity.setUpTime(null);
						shopCommodity.setUpdateTime(null);
						shopCommodity.setDownTime(null);
						shopCommodity.setCreateTime(null);
						sendProductList.add(shopCommodity);
						return "{\"shopCommodity\":"+JSONArray.fromObject(sendProductList).toString()+",\"productVariation\":"+JSONArray.fromObject(sendProductVariationList).toString()+"}";
					}
				} else {
					shopCommodity.setShopCommodityState(3);
					shopCommodity.setUpTime(null);
					shopCommodity.setUpdateTime(null);
					shopCommodity.setDownTime(null);
					shopCommodity.setCreateTime(null);
					sendProductList.add(shopCommodity);
					return "{\"shopCommodity\":"+JSONArray.fromObject(sendProductList).toString()+",\"productVariation\":null}";
				}
			}
			return null;
		}
		return null;
	}

}  