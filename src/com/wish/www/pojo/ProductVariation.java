package com.wish.www.pojo;

public class ProductVariation {

	/**
	 * Must provide either id or parent_sku Wish's unique identifier for the product you would like to update
	 */
	private String id="";
	/**
	 * The unique identifier that your system uses to recognize this product
	 */
	private String sku="";
	/**
	 * optional The color of the product. Example: red, blue, green
	 */
	private String color="";
	/**
	 * optional The size of the product. Example: Large, Medium, Small, 5, 6, 7.5
	 */
	private String size="";
	/**
	 * The physical quantities you have for this product
	 */
	private String inventory="";
	/**
	 * The price of the product when the user purchases one
	 */
	private String price="";
	/**
	 * The shipping of the product when the user purchases one
	 */
	private String shipping="";
	/**
	 * optional Manufacturer's Suggested Retail Price. 
	 * This field is recommended as it will show as a strikethrough
	 * price on Wish and appears above the selling price for the product.
	 */
	private String msrp="";
	/**
	 * Whether or not this product variation is enabled for purchase
	 */
	private String enabled = "";
	/**
	 * optional The amount of time it takes for the shipment to reach the buyer. 
	 * Please also factor in the time it will take to fulfill and ship the item. 
	 * Provide a time range in number of days. Lower bound cannot be less than 2 days. 
	 * Example: 15-20
	 */
	private String shipping_time="";
	/**
	 * URL of a photo of your product. 
	 * Link directly to the image, not the page where it is located.
	 * We accept JPEG, PNG or GIF format. 
	 * Images should be at least 100 x 100 pixels in size.
	 */
	private String main_image="";
	/**
	 * optional When defining a variant of a product we must know which product to attach the variation to. 
	 * parent_sku is the unique id of the product that you can use later when using the add product variation API.
	 */
	private String parent_sku="";
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getInventory() {
		return inventory;
	}
	public void setInventory(String inventory) {
		this.inventory = inventory;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public String getMsrp() {
		return msrp;
	}
	public void setMsrp(String msrp) {
		this.msrp = msrp;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getShipping_time() {
		return shipping_time;
	}
	public void setShipping_time(String shipping_time) {
		this.shipping_time = shipping_time;
	}
	public String getMain_image() {
		return main_image;
	}
	public void setMain_image(String main_image) {
		this.main_image = main_image;
	}
	public String getParent_sku() {
		return parent_sku;
	}
	public void setParent_sku(String parent_sku) {
		this.parent_sku = parent_sku;
	}
	
	public String createProductVariationObject(){
		StringBuffer buffer = new StringBuffer();
		if (null != this) {
			if (!this.getParent_sku().equals("")) {
				buffer.append("parent_sku="+this.getParent_sku()+"&");
			}
			if (!this.getSku().equals("")) {
				buffer.append("sku="+this.getSku()+"&");
			}
			if (!this.getColor().equals("")) {
				buffer.append("color="+this.getColor()+"&");
			}
			if (!this.getSize().equals("")) {
				buffer.append("size="+this.getSize()+"&");
			}
			if (!this.getInventory().equals("")) {
				buffer.append("inventory="+this.getInventory()+"&");
			}
			if (!this.getPrice().equals("")) {
				buffer.append("price="+this.getPrice()+"&");
			}
			if (!this.getShipping().equals("")) {
				buffer.append("shipping="+this.getShipping()+"&");
			}
			if (!this.getMsrp().equals("")) {
				buffer.append("msrp="+this.getMsrp()+"&");
			}
			if (!this.getShipping_time().equals("")) {
				buffer.append("shipping_time="+this.getShipping_time()+"&");
			}
			if (!this.getMain_image().equals("")) {
				buffer.append("main_image="+this.getMain_image()+"&");
			}
			
		}
		return buffer.toString();
	}

	public String retrieveProductVariationObject(){
		StringBuffer buffer = new StringBuffer();
		if (null != this) {
			if (!this.getSku().equals("")) {
				buffer.append("sku="+this.getSku()+"&");
			}
		}
		return buffer.toString();
	}
	
	public String updateProductVariationObject(){
		StringBuffer buffer = new StringBuffer();
		if (null != this) {
			if (!this.getSku().equals("")) {
				buffer.append("sku="+this.getSku()+"&");
			}
			if (!this.getInventory().equals("")) {
				buffer.append("inventory="+this.getInventory()+"&");
			}
			if (!this.getPrice().equals("")) {
				buffer.append("price="+this.getPrice()+"&");
			}
			if (!this.getShipping().equals("")) {
				buffer.append("shipping="+this.getShipping()+"&");
			}
			if (!this.getEnabled().equals("")) {
				buffer.append("enabled="+this.getEnabled()+"&");
			}
			if (!this.getSize().equals("")) {
				buffer.append("size="+this.getSize()+"&");
			}
			if (!this.getColor().equals("")) {
				buffer.append("color="+this.getColor()+"&");
			}
			if (!this.getMsrp().equals("")) {
				buffer.append("msrp="+this.getMsrp()+"&");
			}
			if (!this.getShipping_time().equals("")) {
				buffer.append("shipping_time="+this.getShipping_time()+"&");
			}
			if (!this.getMain_image().equals("")) {
				buffer.append("main_image="+this.getMain_image()+"&");
			}
			
		}
		return buffer.toString();
	}
	
	public String enableProductVariationObject(){
		StringBuffer buffer = new StringBuffer();
		if (null != this) {
			if (!this.getSku().equals("")) {
				buffer.append("sku="+this.getSku()+"&");
			}
		}
		return buffer.toString();
	}
	
	public String disableProductVariationObject(){
		StringBuffer buffer = new StringBuffer();
		if (null != this) {
			if (!this.getSku().equals("")) {
				buffer.append("sku="+this.getSku()+"&");
			}
		}
		return buffer.toString();
	}
	
	public String updateInventoryObject(){
		StringBuffer buffer = new StringBuffer();
		if (null != this) {
			if (!this.getSku().equals("")) {
				buffer.append("sku="+this.getSku()+"&");
			}
			if (!this.getInventory().equals("")) {
				buffer.append("inventory="+this.getInventory()+"&");
			}
		}
		return buffer.toString();
	}
	
	public String ListProductVariationsObject(String start,String limit){
		StringBuffer buffer = new StringBuffer();
		if (null != this) {
			if (!start.equals("")) {
				buffer.append("start="+start+"&");
			}
			if (!limit.equals("")) {
				buffer.append("limit="+limit+"&");
			}
		}
		return buffer.toString();
	}
}
