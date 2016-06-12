package com.MyInventoryApp.UI;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.MyInventoryApp.DTO.Product;
import com.MyInventoryApp.Service.IProductService;

@Named
@ManagedBean
@Scope("session")
public class UpdateProduct {
	
	@Inject
	private Product product;
	
	@Inject
	private IProductService productService;
	
	public void execute() {
		try {
			productService.update(product);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}