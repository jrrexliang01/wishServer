package com.wish.www.server.pojo;

public class ProductVariation {

	private Integer id;
	
	private Integer product_id;
	
	private String sku;
	
	private String color;
	
	private String size;
	
	private String inventory;
	
	private String price;
	
	private String shipping;
	
	private String msrp;
	
	private String enabled;
	
	private String shipping_time;
	
	private String main_image;

	private String wish_id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
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

	public String getWish_id() {
		return wish_id;
	}

	public void setWish_id(String wish_id) {
		this.wish_id = wish_id;
	}

}
