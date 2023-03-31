package com.shubham.ecom.dao;

import java.util.List;

import com.shubham.ecom.pojo.Product;


public interface IProductDao {
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(int productId);
	Product getProductById(int productId);
	List<Product>getAllProduct();

}
