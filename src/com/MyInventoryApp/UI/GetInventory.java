package com.MyInventoryApp.UI;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.MyInventoryApp.DTO.Product;
import com.MyInventoryApp.Service.IProductService;

@Named
@ManagedBean
@Scope("session")
public class GetInventory {

	@Inject
	private IProductService productService;
	@Inject
	private List<Product> products;
	
	public List<Product> getProducts() {
		try {
			setProducts(productService.fetchProduct());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public IProductService getProductService() {
		return productService;
	}
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	
	
}