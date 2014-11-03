package org.liufeng.course.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	/**
	 * 基础方法
	 * @param name properties name
	 * @return properties value
	 */
	public static String getProperties(String name){
		Properties prop = new Properties();
//		InputStream in = Object.class.getResourceAsStream("/wish2url.properties"); 
		InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("wish2url.properties"); 
		 try {   
	            prop.load(in);   
	            String value = prop.getProperty(name).trim();
	            System.out.println("getProperties=========="+value);
	            return value;
	        } catch (IOException e) {   
	            e.printStackTrace();  
	            return null;
	        }
	}
	
	/**
	 * 获取BaseUrl
	 * @return BaseUrl value
	 */
	public static String getBaseUrl(){
		String baseurl = getProperties("baseurl");
		return baseurl;
	}
	/**
	 * 获取AuthTestUrl
	 * @return AuthTestUrl value
	 */
	public static String getAuthTest(){
		String authtest = getProperties("authtest");
		return authtest;
	}
	/**
	 * 获取CreateProduct
	 * @return CreateProductBaseUrl value
	 */
	public static String getCreateProduct(){
		String createproduct = getProperties("createproduct");
		return createproduct;
	}
	
	/**
	 * 获取CreateProducturl
	 * @return CreateProductUrl value
	 */
	public static String getCreateProductUrl(){
		String createproduct = getProperties("createproducturl");
		return createproduct;
	}
	
	
	/**
	 * 获取RetrieveProduct
	 * @return RetrieveProductBaseUrl value
	 */
	public static String getRetrieveProduct(){
		String retrieveproduct = getProperties("retrieveproduct");
		return retrieveproduct;
	}
	
	/**
	 * 获取RetrieveProductUrl
	 * @return RetrieveProductUrl value
	 */
	public static String getRetrieveProductUrl(){
		String retrieveproducturl = getProperties("retrieveproducturl");
		return retrieveproducturl;
	}
	/**
	 * 获取UpdateProduct
	 * @return UpdateProductUrl value
	 */
	public static String getUpdateProduct(){
		String updateproduct = getProperties("updateproduct");
		return updateproduct;
	}
	/**
	 * 获取EnableProduct
	 * @return EnableProductUrl value
	 */
	public static String getEnableProduct(){
		String enableproduct = getProperties("enableproduct");
		return enableproduct;
	}
	/**
	 * 获取DisableProduct
	 * @return DisableProductUrl value
	 */
	public static String getDisableProduct(){
		String disableproduct = getProperties("disableproduct");
		return disableproduct;
	}
	/**
	 * 获取ListallProducts
	 * @return ListallProductsUrl value
	 */
	public static String getListallProducts(){
		String listallproducts = getProperties("listallproducts");
		return listallproducts;
	}
	/**
	 * 获取CreateProductVariation
	 * @return CreateProductVariationbaseUrl value
	 */
	public static String getCreateProductVariation(){
		String createproductvariation = getProperties("createproductvariation");
		return createproductvariation;
	}
	/**
	 * 获取CreateProductVariationurl
	 * @return CreateProductVariationUrl value
	 */
	public static String getCreateProductVariationUrl(){
		String createproductvariationurl = getProperties("createproductvariationurl");
		return createproductvariationurl;
	}
	
	/**
	 * 获取RetrieveProductVariation
	 * @return RetrieveProductVariationUrl value
	 */
	public static String getRetrieveProductVariation(){
		String retrieveproductvariation = getProperties("retrieveproductvariation");
		return retrieveproductvariation;
	}
	/**
	 * 获取UpdateProductVariation
	 * @return UpdateProductVariationUrl value
	 */
	public static String getUpdateProductVariation(){
		String updateproductvariation = getProperties("updateproductvariation");
		return updateproductvariation;
	}
	/**
	 * 获取EnableProductVariation
	 * @return EnableProductVariationUrl value
	 */
	public static String getEnableProductVariation(){
		String enableproductvariation = getProperties("enableproductvariation");
		return enableproductvariation;
	}
	/**
	 * 获取DisableProductVariation
	 * @return DisableProductVariationUrl value
	 */
	public static String getDisableProductVariation(){
		String disableproductvariation = getProperties("disableproductvariation");
		return disableproductvariation;
	}
	/**
	 * 获取UpdateInventory
	 * @return UpdateInventoryUrl value
	 */
	public static String getUpdateInventory(){
		String updateinventory = getProperties("updateinventory");
		return updateinventory;
	}
	/**
	 * 获取ListallProductVariations
	 * @return ListallProductVariationsUrl value
	 */
	public static String getListallProductVariations(){
		String listallproductvariations = getProperties("listallproductvariations");
		return listallproductvariations;
	}
	/**
	 * 获取RetrieveOrder
	 * @return RetrieveOrderUrl value
	 */
	public static String getRetrieveOrder(){
		String retrieveorder = getProperties("retrieveorder");
		return retrieveorder;
	}
	/**
	 * 获取RetrieveRecentlyChangedOrders
	 * @return RetrieveRecentlyChangedOrdersUrl value
	 */
	public static String getRetrieveRecentlyChangedOrders(){
		String retrieverecentlychangedorders = getProperties("retrieverecentlychangedorders");
		return retrieverecentlychangedorders;
	}
	/**
	 * 获取RetrieveUnfulfilledOrders
	 * @return RetrieveUnfulfilledOrdersUrl value
	 */
	public static String getRetrieveUnfulfilledOrders(){
		String retrieveunfulfilledorders = getProperties("retrieveunfulfilledorders");
		return retrieveunfulfilledorders;
	}
	/**
	 * 获取FulfillOrder
	 * @return FulfillOrderUrl value
	 */
	public static String getFulfillOrder(){
		String fulfillorder = getProperties("fulfillorder");
		return fulfillorder;
	}
	/**
	 * 获取CancelOrder
	 * @return CancelOrderUrl value
	 */
	public static String getCancelOrder(){
		String cancelorder = getProperties("cancelorder");
		return cancelorder;
	}
	/**
	 * 获取RefundOrder
	 * @return RefundOrderUrl value
	 */
	public static String getRefundOrder(){
		String refundorder = getProperties("refundorder");
		return refundorder;
	}
	/**
	 * 获取ModifyTrackingShippedOrder
	 * @return ModifyTrackingShippedOrderUrl value
	 */
	public static String getModifyTrackingShippedOrder(){
		String modifytrackingshippedorder = getProperties("modifytrackingshippedorder");
		return modifytrackingshippedorder;
	}
	
	/**
	 * 获取projectUrl
	 * @return projectUrl value
	 */
	public static String getProjectUrl(){
		String projectUrl = getProperties("projecturl");
		return projectUrl;
	}

	/**
	 * 获取apiKey
	 * @return apiKey value
	 */
	public static String getApiKey(){
		String apiKey = getProperties("apiKey");
		return apiKey;
	}
}
