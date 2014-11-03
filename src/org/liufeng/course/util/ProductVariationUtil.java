package org.liufeng.course.util;

import net.sf.json.JSONObject;

import com.wish.www.pojo.ProductVariation;

public class ProductVariationUtil {

	/**
	 * Retrieve the details about a product which exists on the Wish platform. You must have the unique product Id that was returned upon product creation.
	 * @param productId id
	 * @param apiKey apiKey
	 * @return JSONObject
	 */
	public JSONObject retrieveProductVariationJSONObject(String productId,String apiKey){
		String url = PropertiesUtil.getRetrieveProductVariation().replace("product_id", productId).replace("an_example_api_key", apiKey);
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
	public Boolean retrieveProductVariationBoolean(String productId,String apiKey){
		String url = PropertiesUtil.getRetrieveProductVariation().replace("product_id", productId).replace("an_example_api_key", apiKey);
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
	public Boolean createProductVariationBoolean(ProductVariation productVariation,String apiKey){
		String url = PropertiesUtil.getCreateProductVariation();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", productVariation.createProductVariationObject()+"key="+apiKey);

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
	public JSONObject createProductVariationJSONObject(ProductVariation productVariation,String apiKey){
		String url = PropertiesUtil.getCreateProductVariation();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", productVariation.createProductVariationObject()+"key="+apiKey);

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
	public JSONObject updateProductVariationJSONObject(ProductVariation productVariation,String apiKey){
		String url = PropertiesUtil.getUpdateProductVariation();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", productVariation.updateProductVariationObject()+"key="+apiKey);

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
	public Boolean updateProductVariationBoolean(ProductVariation productVariation,String apiKey){
		String url = PropertiesUtil.getUpdateProductVariation();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", productVariation.updateProductVariationObject()+"key="+apiKey);

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
	public JSONObject enableProductVariationJSONObject(ProductVariation productVariation,String apiKey){
		String url = PropertiesUtil.getEnableProductVariation();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", productVariation.enableProductVariationObject()+"key="+apiKey);

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
	public Boolean enableProductVariationBoolean(ProductVariation productVariation,String apiKey){
		String url = PropertiesUtil.getEnableProductVariation();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", productVariation.enableProductVariationObject()+"key="+apiKey);

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
	public JSONObject disableProductVariationJSONObject(ProductVariation productVariation,String apiKey){
		String url = PropertiesUtil.getDisableProductVariation();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", productVariation.disableProductVariationObject()+"key="+apiKey);

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
	public Boolean disableProductVariationBoolean(ProductVariation productVariation,String apiKey){
		String url = PropertiesUtil.getDisableProductVariation();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", productVariation.disableProductVariationObject()+"key="+apiKey);

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
	 * Update inventory for a product variation.
	 * @param productVariation ProductVariation
	 * @param apiKey apiKey
	 * @return JSONObject
	 */
	public JSONObject updateInventoryJSONObject(ProductVariation productVariation,String apiKey){
		String url = PropertiesUtil.getUpdateInventory();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", productVariation.updateInventoryObject()+"key="+apiKey);

		if (null != jsonObject) {
				return jsonObject;
			} else {
				return null;
			}
	}
	/**
	 * Update inventory for a product variation.
	 * @param productVariation ProductVariation
	 * @param apiKey apiKey
	 * @return Boolean
	 */
	public Boolean updateInventoryBoolean(ProductVariation productVariation,String apiKey){
		String url = PropertiesUtil.getUpdateInventory();
		// 发起POST请求
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", productVariation.updateInventoryObject()+"key="+apiKey);

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
	public JSONObject ListAllProductsVariationJSONObject(String start,String limit,String apiKey){
		String url = PropertiesUtil.getListallProductVariations();
		
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
}
