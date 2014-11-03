package org.liufeng.course.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	/**
	 * ��������
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
	 * ��ȡBaseUrl
	 * @return BaseUrl value
	 */
	public static String getBaseUrl(){
		String baseurl = getProperties("baseurl");
		return baseurl;
	}
	/**
	 * ��ȡAuthTestUrl
	 * @return AuthTestUrl value
	 */
	public static String getAuthTest(){
		String authtest = getProperties("authtest");
		return authtest;
	}
	/**
	 * ��ȡCreateProduct
	 * @return CreateProductBaseUrl value
	 */
	public static String getCreateProduct(){
		String createproduct = getProperties("createproduct");
		return createproduct;
	}
	
	/**
	 * ��ȡCreateProducturl
	 * @return CreateProductUrl value
	 */
	public static String getCreateProductUrl(){
		String createproduct = getProperties("createproducturl");
		return createproduct;
	}
	
	
	/**
	 * ��ȡRetrieveProduct
	 * @return RetrieveProductBaseUrl value
	 */
	public static String getRetrieveProduct(){
		String retrieveproduct = getProperties("retrieveproduct");
		return retrieveproduct;
	}
	
	/**
	 * ��ȡRetrieveProductUrl
	 * @return RetrieveProductUrl value
	 */
	public static String getRetrieveProductUrl(){
		String retrieveproducturl = getProperties("retrieveproducturl");
		return retrieveproducturl;
	}
	/**
	 * ��ȡUpdateProduct
	 * @return UpdateProductUrl value
	 */
	public static String getUpdateProduct(){
		String updateproduct = getProperties("updateproduct");
		return updateproduct;
	}
	/**
	 * ��ȡEnableProduct
	 * @return EnableProductUrl value
	 */
	public static String getEnableProduct(){
		String enableproduct = getProperties("enableproduct");
		return enableproduct;
	}
	/**
	 * ��ȡDisableProduct
	 * @return DisableProductUrl value
	 */
	public static String getDisableProduct(){
		String disableproduct = getProperties("disableproduct");
		return disableproduct;
	}
	/**
	 * ��ȡListallProducts
	 * @return ListallProductsUrl value
	 */
	public static String getListallProducts(){
		String listallproducts = getProperties("listallproducts");
		return listallproducts;
	}
	/**
	 * ��ȡCreateProductVariation
	 * @return CreateProductVariationbaseUrl value
	 */
	public static String getCreateProductVariation(){
		String createproductvariation = getProperties("createproductvariation");
		return createproductvariation;
	}
	/**
	 * ��ȡCreateProductVariationurl
	 * @return CreateProductVariationUrl value
	 */
	public static String getCreateProductVariationUrl(){
		String createproductvariationurl = getProperties("createproductvariationurl");
		return createproductvariationurl;
	}
	
	/**
	 * ��ȡRetrieveProductVariation
	 * @return RetrieveProductVariationUrl value
	 */
	public static String getRetrieveProductVariation(){
		String retrieveproductvariation = getProperties("retrieveproductvariation");
		return retrieveproductvariation;
	}
	/**
	 * ��ȡUpdateProductVariation
	 * @return UpdateProductVariationUrl value
	 */
	public static String getUpdateProductVariation(){
		String updateproductvariation = getProperties("updateproductvariation");
		return updateproductvariation;
	}
	/**
	 * ��ȡEnableProductVariation
	 * @return EnableProductVariationUrl value
	 */
	public static String getEnableProductVariation(){
		String enableproductvariation = getProperties("enableproductvariation");
		return enableproductvariation;
	}
	/**
	 * ��ȡDisableProductVariation
	 * @return DisableProductVariationUrl value
	 */
	public static String getDisableProductVariation(){
		String disableproductvariation = getProperties("disableproductvariation");
		return disableproductvariation;
	}
	/**
	 * ��ȡUpdateInventory
	 * @return UpdateInventoryUrl value
	 */
	public static String getUpdateInventory(){
		String updateinventory = getProperties("updateinventory");
		return updateinventory;
	}
	/**
	 * ��ȡListallProductVariations
	 * @return ListallProductVariationsUrl value
	 */
	public static String getListallProductVariations(){
		String listallproductvariations = getProperties("listallproductvariations");
		return listallproductvariations;
	}
	/**
	 * ��ȡRetrieveOrder
	 * @return RetrieveOrderUrl value
	 */
	public static String getRetrieveOrder(){
		String retrieveorder = getProperties("retrieveorder");
		return retrieveorder;
	}
	/**
	 * ��ȡRetrieveRecentlyChangedOrders
	 * @return RetrieveRecentlyChangedOrdersUrl value
	 */
	public static String getRetrieveRecentlyChangedOrders(){
		String retrieverecentlychangedorders = getProperties("retrieverecentlychangedorders");
		return retrieverecentlychangedorders;
	}
	/**
	 * ��ȡRetrieveUnfulfilledOrders
	 * @return RetrieveUnfulfilledOrdersUrl value
	 */
	public static String getRetrieveUnfulfilledOrders(){
		String retrieveunfulfilledorders = getProperties("retrieveunfulfilledorders");
		return retrieveunfulfilledorders;
	}
	/**
	 * ��ȡFulfillOrder
	 * @return FulfillOrderUrl value
	 */
	public static String getFulfillOrder(){
		String fulfillorder = getProperties("fulfillorder");
		return fulfillorder;
	}
	/**
	 * ��ȡCancelOrder
	 * @return CancelOrderUrl value
	 */
	public static String getCancelOrder(){
		String cancelorder = getProperties("cancelorder");
		return cancelorder;
	}
	/**
	 * ��ȡRefundOrder
	 * @return RefundOrderUrl value
	 */
	public static String getRefundOrder(){
		String refundorder = getProperties("refundorder");
		return refundorder;
	}
	/**
	 * ��ȡModifyTrackingShippedOrder
	 * @return ModifyTrackingShippedOrderUrl value
	 */
	public static String getModifyTrackingShippedOrder(){
		String modifytrackingshippedorder = getProperties("modifytrackingshippedorder");
		return modifytrackingshippedorder;
	}
	
	/**
	 * ��ȡprojectUrl
	 * @return projectUrl value
	 */
	public static String getProjectUrl(){
		String projectUrl = getProperties("projecturl");
		return projectUrl;
	}

	/**
	 * ��ȡapiKey
	 * @return apiKey value
	 */
	public static String getApiKey(){
		String apiKey = getProperties("apiKey");
		return apiKey;
	}
}
