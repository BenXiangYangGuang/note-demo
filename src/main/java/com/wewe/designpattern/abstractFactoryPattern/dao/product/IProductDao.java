package com.wewe.designpattern.abstractFactoryPattern.dao.product;


import com.wewe.designpattern.abstractFactoryPattern.bean.Product;

public interface IProductDao {
	
	void addProduct(Product product);
	void removeProduct(Product product);
	Product getProduct(String productname);

}
