package org.liufeng.course.util;

import com.wish.www.pojo.Product;
import com.wish.www.pojo.ProductVariation;

import net.sf.json.JSONObject;

public class ProductUtil {
	
	/**
	 * Retrieve the details about a product which exists on the Wish platform. You must have the unique product Id that was returned upon product creation.
	 * @param productId id
	 * @param apiKey apiKey
	 * @return JSONObject
	 */
	public JSONObject retrieveProductJSONObject(String productId,String apiKey){
		String url = PropertiesUtil.getRetrieveProductUrl().replace("product_id", productId).replace("an_example_api_key", apiKey);
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "GET", null);

		if (null != jsonObject) {
			int code = jsonObject.getInt("code");
			if (0 == code) {
				return jsonObject;
			} else {
				JSONObject errorJsonObject = new JSONObject();
				return errorJsonObject.element("message", jsonObject.getString("message"));
			}
		}else{
			return null;
		}
	}
	/**
	 * Retrieve the details about a product which exists on the Wish platform. You must have the unique product Id that was returned upon product creation.
	 * @param productId id
	 * @param apiKey apiKey
	 * @return Boolean
	 */
	public Boolean retrieveProductBoolean(String productId,String apiKey){
		String url = PropertiesUtil.getRetrieveProductUrl().replace("product_id", productId).replace("an_example_api_key", apiKey);
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "GET", null);

		if (null != jsonObject) {
			int code = jsonObject.getInt("code");
			if (0 == code) {
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
	}
	/**
	 * Use the endpoint to create a new product. Each product creation must include at least one variation because each product must have at least 1 variation.
	 * @param product Product Object
	 * @param apiKey apiKey
	 * @return Boolean
	 */
	public Boolean createProductBoolean(Product product,String apiKey){
		String url = PropertiesUtil.getCreateProduct();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", product.createProductObject()+"key="+apiKey);

		if (null != jsonObject) {
			int code = jsonObject.getInt("code");
			if (0 == code) {
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
	}
	/**
	 * Use the endpoint to create a new product. Each product creation must include at least one variation because each product must have at least 1 variation.
	 * @param product Product Object
	 * @param apiKey apiKey
	 * @return JSONObject
	 */
	public JSONObject createProductJSONObject(Product product,String apiKey){
		String url = PropertiesUtil.getCreateProduct();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", product.createProductObject()+"key="+apiKey);

		if (null != jsonObject) {
				return jsonObject;
			} else {
				return null;
			}
	}
	/**
	 * Updates the specified product with the parameters passed in the request. 
	 * Any attribute not provided will be left unchanged. 
	 * For example, if you pass the name parameter we will update the name of the product and leave everything else unchanged.
	 * This request can only update attributes specific to products and cannot be used to update anything to do with the product variations of a product.
	 * @param product Product
	 * @param apiKey apiKey
	 * @return JSONObject
	 */
	public JSONObject updateProductJSONObject(Product product,String apiKey){
		String url = PropertiesUtil.getUpdateProduct();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", product.updateProductObject()+"key="+apiKey);

		if (null != jsonObject) {
				return jsonObject;
			} else {
				return null;
			}
	}
	
	/**
	 * Updates the specified product with the parameters passed in the request. 
	 * Any attribute not provided will be left unchanged. 
	 * For example, if you pass the name parameter we will update the name of the product and leave everything else unchanged.
	 * This request can only update attributes specific to products and cannot be used to update anything to do with the product variations of a product.
	 * @param product Product
	 * @param apiKey apiKey
	 * @return Boolean
	 */
	public Boolean updateProductBoolean(Product product,String apiKey){
		String url = PropertiesUtil.getUpdateProduct();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", product.updateProductObject()+"key="+apiKey);

		if (null != jsonObject) {
			int code = jsonObject.getInt("code");
			if (0 == code) {
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**
	 * Enable a product and all of its product variations. 
	 * This marks the product available for sale.
	 * @param product Product
	 * @param apiKey apiKey
	 * @return JSONObject
	 */
	public JSONObject enableProductJSONObject(Product product,String apiKey){
		String url = PropertiesUtil.getEnableProduct();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", product.enableProductObject()+"key="+apiKey);

		if (null != jsonObject) {
				return jsonObject;
			} else {
				return null;
			}
	}
	
	/**
	 * Enable a product and all of its product variations. 
	 * This marks the product available for sale.
	 * @param product Product
	 * @param apiKey apiKey
	 * @return Boolean
	 */
	public Boolean enableProductBoolean(Product product,String apiKey){
		String url = PropertiesUtil.getEnableProduct();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", product.enableProductObject()+"key="+apiKey);

		if (null != jsonObject) {
			int code = jsonObject.getInt("code");
			if (0 == code) {
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**
	 * Disable a product and all of its product variations. 
	 * This marks the product available for sale.
	 * @param product Product
	 * @param apiKey apiKey
	 * @return JSONObject
	 */
	public JSONObject disableProductJSONObject(Product product,String apiKey){
		String url = PropertiesUtil.getDisableProduct();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", product.disableProductObject()+"key="+apiKey);

		if (null != jsonObject) {
				return jsonObject;
			} else {
				return null;
			}
	}
	
	/**
	 * Disable a product and all of its product variations. 
	 * This marks the product available for sale.
	 * @param product Product
	 * @param apiKey apiKey
	 * @return Boolean
	 */
	public Boolean disableProductBoolean(Product product,String apiKey){
		String url = PropertiesUtil.getDisableProduct();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", product.disableProductObject()+"key="+apiKey);

		if (null != jsonObject) {
			int code = jsonObject.getInt("code");
			if (0 == code) {
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**
	 * Returns a list of all your products currently on the Wish platform. 
	 * If you have a high number of products the response will be paginated. 
	 * The response will contain the URL for fetching the next page of products.
	 * @param start optional An offset into the list of returned items. 
	 * 				Use 0 to start at the beginning. 
	 * 				The API will return the requested number of items starting at this offset. 
	 * 				Default to 0 if not supplied
	 * @param limit A limit on the number of products that can be returned. 
	 * 				Limit can range from 1 to 500 items and the default is 50
	 * @param apiKey apiKey
	 * @return JSONObject
	 */
	public JSONObject ListAllProductsJSONObject(String start,String limit,String apiKey){
		String url = PropertiesUtil.getListallProducts();
		
		StringBuffer buffer = new StringBuffer();
		if (!start.equals("")) {
			buffer.append("start="+start+"&");
		}
		if (!limit.equals("")) {
			buffer.append("limit="+limit+"&");
		}
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", buffer.toString()+"key="+apiKey);

		if (null != jsonObject) {
				return jsonObject;
			} else {
				return null;
			}
	}
	/**
	 * Use the endpoint to create a new product. Each product creation must include at least one variation because each product must have at least 1 variation.
	 * @param product Product
	 * @param variation ProductVariation
	 * @param apiKey apiKey
	 * @return Boolean
	 */
	public Boolean createProductWithVariationBoolean(Product product,ProductVariation variation,String apiKey){
		
		ProductUtil productUtil = new ProductUtil();
		
		Boolean createProductBoolean = productUtil.createProductBoolean(product, apiKey);
		System.out.println("createProductBoolean========="+createProductBoolean);
		if (createProductBoolean) {
			
			ProductVariationUtil variationUtil = new ProductVariationUtil();
			
			Boolean variationBoolean = variationUtil.createProductVariationBoolean(variation, apiKey);
			System.out.println("variationBoolean========="+variationBoolean);
			return variationBoolean;
		}else{
			return createProductBoolean;
		}
	}
	
}
