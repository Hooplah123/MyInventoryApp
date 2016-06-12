package com.MyInventoryApp.DTO;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")
public class Product {

//	private int SQL_ID;					//ID number for SQL table's use
	private int Product_ID;				//Product ID number for our use
	private String Product_Name;
	private int Quantity;
	private String Units;
	private String Product_Status;
	
	public int getProduct_ID() {
		return Product_ID;
	}
	public void setProduct_ID(int product_ID) {
		Product_ID = product_ID;
	}
	public String getProduct_Name() {
		return Product_Name;
	}
	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getUnits() {
		return Units;
	}
	public void setUnits(String units) {
		Units = units;
	}
	public String getProduct_Status() {
		return Product_Status;
	}
	public void setProduct_Status(String product_Status) {
		Product_Status = product_Status;
	}
/*	public int getSQL_ID() {
		return SQL_ID;
	}
	public void setSQL_ID(int sQL_ID) {
		SQL_ID = sQL_ID;
	}
*/
	
}