package com.MyInventoryApp.DAO;


import java.util.Collections;
import java.util.List;

import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.MyInventoryApp.DTO.Product;

@Named
public class ProductHbmDAO implements IProductDAO {

	@Override
	public void insertProduct(Product product) throws Exception {
		// Save the product to the database
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(product);
		
		session.getTransaction().commit();
	}

	@Override
	public void update(Product product) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			//Gather a product from the database that matches the Product_ID
			//supplied by the user, and assign it to p1.
			Product p1 = (Product) session.load(Product.class, product.getProduct_ID());
			//Change all of p1's attributes to match the input from the user.
			p1.setProduct_Name(product.getProduct_Name());
			p1.setQuantity(product.getQuantity());
			p1.setUnits(product.getUnits());
			p1.setProduct_Status(product.getProduct_Status());
			//Flush the session, changing the product's attributes in the database.
			session.flush();
			
		} catch(Exception e) {
			throw e;
		}
		finally {
			session.close();
		}
	}

	@Override
	public void delete(Product product) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("delete Product where product_ID = :ID");
		query.setParameter("ID", product.getProduct_ID());
		query.executeUpdate();
		return;
	}

	@Override
	public List<Product> fetchProduct() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Product");
		@SuppressWarnings("rawtypes")
		List list = query.list();
		List<Product> products = Collections.checkedList(list, Product.class);
		return products;
	}
	
	@Override
	public List<Product> fetchProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Product where Product_Name = :Product_Name");
		query.setProperties(product);
		@SuppressWarnings("rawtypes")
		List list = query.list();
		List<Product> products = Collections.checkedList(list, Product.class);
		return products;
	}

}