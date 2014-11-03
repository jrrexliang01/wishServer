package com.wish.www.pojo;

import java.nio.Buffer;

/**
 * The product entity represents an item that is for sale on Wish. 
 * Each product can have multiple variations comprised of different sizes and colors. 
 * Each product has at least one product variation. Product variations, not products, are purchased by users. 
 * Each product contains multiple related SKUs.
 * @author Taka
 *
 */
public class Product {
	
	/**
	 * Must provide either id or parent_sku Wish's unique identifier for the product you would like to update
	 */
	private String id="";
	/**
	 * Name of the product as shown to users on Wish
	 */
	private String name="";
	/**
	 * Description of the product. Should not contain HTML. If you want a new line use "\n".
	 */
	private String description="";
	/**
	 * Comma separated list of strings that describe the product. Only 10 are allowed. Any tags past 10 will be ignored.
	 */
	private String tags="";
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
	/**
	 * optional Brand or manufacturer of your product
	 */
	private String brand="";
	/**
	 * optional URL on your website containing the product details
	 */
	private String landing_page_url="";
	/**
	 * optional 12-digit Universal Product Codes (UPC)-contains no letters or other characters
	 */
	private String upc="";
	/**
	 * optional URL of extra photos of your product. 
	 * Link directly to the image, not the page where it is located. 
	 * Same rules apply as main_image. 
	 * You can specify one or more additional images separated by the character '|'
	 */
	private String extra_images="";
	/**
	 * Number of sales this product has received
	 */
	private String num_sold="";
	/**
	 * Number of times this product has been added to users' wishlists
	 */
	private String num_saves="";
	/**
	 * A list of Product Variation entities
	 */
	private String variants="";
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getLanding_page_url() {
		return landing_page_url;
	}
	public void setLanding_page_url(String landing_page_url) {
		this.landing_page_url = landing_page_url;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getExtra_images() {
		return extra_images;
	}
	public void setExtra_images(String extra_images) {
		this.extra_images = extra_images;
	}
	public String getNum_sold() {
		return num_sold;
	}
	public void setNum_sold(String num_sold) {
		this.num_sold = num_sold;
	}
	public String getNum_saves() {
		return num_saves;
	}
	public void setNum_saves(String num_saves) {
		this.num_saves = num_saves;
	}
	public String getVariants() {
		return variants;
	}
	public void setVariants(String variants) {
		this.variants = variants;
	}

	public String createProductObject(){
		StringBuffer buffer = new StringBuffer();
		if (null != this) {
			if (!this.getName().equals("")) {
				buffer.append("name="+this.getName()+"&");
			}
			if (!this.getDescription().equals("")) {
				buffer.append("description="+this.getDescription()+"&");
			}
			if (!this.getTags().equals("")) {
				buffer.append("tags="+this.getTags()+"&");
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
			if (!this.getParent_sku().equals("")) {
				buffer.append("parent_sku="+this.getParent_sku()+"&");
			}
			if (!this.getBrand().equals("")) {
				buffer.append("brand="+this.getBrand()+"&");
			}
			if (!this.getLanding_page_url().equals("")) {
				buffer.append("landing_page_url="+this.getLanding_page_url()+"&");
			}
			if (!this.getUpc().equals("")) {
				buffer.append("upc="+this.getUpc()+"&");
			}
			if (!this.getExtra_images().equals("")) {
				buffer.append("extra_images="+this.getExtra_images()+"&");
			}
		}
		return buffer.toString();
	}
	
	public String updateProductObject(){
		StringBuffer buffer = new StringBuffer();
		if (null != this) {
			if (!this.getId().equals("")) {
				buffer.append("id="+this.getId()+"&");
			}
			if (!this.getParent_sku().equals("")) {
				buffer.append("parent_sku="+this.getParent_sku()+"&");
			}
			if (!this.getName().equals("")) {
				buffer.append("name="+this.getName()+"&");
			}
			if (!this.getDescription().equals("")) {
				buffer.append("description="+this.getDescription()+"&");
			}
			if (!this.getTags().equals("")) {
				buffer.append("tags="+this.getTags()+"&");
			}
			if (!this.getBrand().equals("")) {
				buffer.append("brand="+this.getBrand()+"&");
			}
			if (!this.getLanding_page_url().equals("")) {
				buffer.append("landing_page_url="+this.getLanding_page_url()+"&");
			}
			if (!this.getUpc().equals("")) {
				buffer.append("upc="+this.getUpc()+"&");
			}
			if (!this.getMain_image().equals("")) {
				buffer.append("main_image="+this.getMain_image()+"&");
			}
			if (!this.getExtra_images().equals("")) {
				buffer.append("extra_images="+this.getExtra_images()+"&");
			}
		}
		return buffer.toString();
	}
	
	public String enableProductObject(){
		StringBuffer buffer = new StringBuffer();
		if (null != this) {
			if (!this.getId().equals("")) {
				buffer.append("id="+this.getId()+"&");
			}
			if (!this.getParent_sku().equals("")) {
				buffer.append("parent_sku="+this.getParent_sku()+"&");
			}
		}
		return buffer.toString();
	}
	
	public String disableProductObject(){
		StringBuffer buffer = new StringBuffer();
		if (null != this) {
			if (!this.getId().equals("")) {
				buffer.append("id="+this.getId()+"&");
			}
			if (!this.getParent_sku().equals("")) {
				buffer.append("parent_sku="+this.getParent_sku()+"&");
			}
		}
		return buffer.toString();
	}
	
	public String listProductsObject(String start,String limit){
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
