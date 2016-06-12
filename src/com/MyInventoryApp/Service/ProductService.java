package com.MyInventoryApp.Service;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.MyInventoryApp.DAO.IProductDAO;
import com.MyInventoryApp.DTO.Product;

@Named
public class ProductService implements IProductService {

	@Inject
	IProductDAO productDAO;
	
	@Override
	public void save(Product product) throws Exception {
		if (product.getProduct_ID() == 0) {
			throw new Exception("Product_ID is empty.  Must have a unique,"
					+ " nonzero Product_ID");
		} else if (product.getProduct_Name() == null || 
				product.getProduct_Name().isEmpty())
		{
			throw new Exception("Product_Name is empty.  Must have a name.");
		} else if (product.getQuantity() < 0) {
			throw new Exception("Quantity is negative.  Quantity must be zero or positive.");
		} else if (product.getUnits().isEmpty()){
			throw new Exception("No units are listed.  Please provide units of quantity.");
		} else if (product.getProduct_Status().isEmpty()) {
			throw new Exception("Product_Status is empty.  Must have a status.");
		}
		productDAO.insertProduct(product);
	}

	@Override
	public void update(Product product) throws Exception {
		productDAO.update(product);
		return;
	}
	
	@Override
	public List<Product> fetchProduct() throws Exception {
		List<Product> products = productDAO.fetchProduct();
		return products;
	}
	
	@Override
	public List<Product> fetchProduct(Product product) throws Exception {
		List<Product> products = productDAO.fetchProduct(product);
		return products;
	}

	@Override
	public void delete(Product product) throws Exception {
		productDAO.delete(product);
		return;
	}

}