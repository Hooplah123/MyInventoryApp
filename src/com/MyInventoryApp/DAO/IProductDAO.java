package com.MyInventoryApp.DAO;

import java.util.List;

import com.MyInventoryApp.DTO.Product;

public interface IProductDAO {

	public void insertProduct(Product product) throws Exception;

	public void update(Product product) throws Exception;

	public void delete(Product product) throws Exception;

	/**
	 * 
	 * @param product
	 * @return list of products that match parameter product
	 */
	public List<Product> fetchProduct(Product product);

	/**
	 * 
	 * @return a list of all plants
	 */
	public List<Product> fetchProduct();
	
}