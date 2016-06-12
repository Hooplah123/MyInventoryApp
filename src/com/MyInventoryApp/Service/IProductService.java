package com.MyInventoryApp.Service;

import java.util.List;

import com.MyInventoryApp.DTO.Product;

/**
 * IProductService contains all business-related functions for a Product
 * @author Andrew Freeman
 */
public interface IProductService {
	
	/**
	 * Add a new product to a database.  Also performs checks to ensure that
	 * all of the data fields of a new product have values, and that values are
	 * in the correct range if applicable.
	 * @param product- the product that we want to add to the database
	 */
	public void save(Product product) throws Exception;
	
	public void update(Product product) throws Exception;
	
	public List<Product> fetchProduct() throws Exception;
	
	public List<Product> fetchProduct(Product product) throws Exception;
	
	public void delete(Product product) throws Exception;
}