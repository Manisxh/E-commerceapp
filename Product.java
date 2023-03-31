package com.shubham.ecom.pojo;
/*
 * create table ecom_product(
 * productId int primary key auto_increment,
 * productName varchar(30),
 * productPrice double(15,2),
 * productDescription varchar(30)
 * );
 */

public class Product {
	private int productId;
	private String productName;
	private double productPrice;
	private String productDescription;
	
	public Product() {
		
	}
	
	
	public Product(int productId, String productName, double productPrice, String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
	}


	public Product(String productName, double productPrice, String productDescription) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDescription=" + productDescription + "]";
	}
	
	
	
	

}
