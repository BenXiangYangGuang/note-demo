package com.wewe.designpattern.abstractFactoryPattern.dao.product;

import com.wewe.designpattern.abstractFactoryPattern.bean.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySQLProductDao implements IProductDao {

	private static final Logger LOG = LoggerFactory.getLogger(MySQLProductDao.class);

	@Override
	public void addProduct(Product product) {
		LOG.info("MySQL added Product {}", product);
	}

	@Override
	public void removeProduct(Product product) {
		LOG.info("MySQL removed Product {}", product);
	}

	@Override
	public Product getProduct(String productname) {
		Product product = new Product();
		product.setProductname(productname);
		return product;
	}

}
