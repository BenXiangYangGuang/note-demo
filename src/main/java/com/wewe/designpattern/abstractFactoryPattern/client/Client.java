package com.wewe.designpattern.abstractFactoryPattern.client;

import com.wewe.designpattern.abstractFactoryPattern.factory.IDaoFactory;
import com.wewe.designpattern.abstractFactoryPattern.factory.MySQLDaoFactory;
import com.wewe.designpattern.abstractFactoryPattern.bean.Product;
import com.wewe.designpattern.abstractFactoryPattern.bean.User;
import com.wewe.designpattern.abstractFactoryPattern.dao.product.IProductDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.role.IRoleDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.user.IUserDao;
import com.wewe.designpattern.abstractFactoryPattern.factory.IDaoFactory;
import com.wewe.designpattern.abstractFactoryPattern.factory.MySQLDaoFactory;

public class Client {

	public static void main(String[] args) {
		IDaoFactory factory = new MySQLDaoFactory();
		
		IUserDao userDao = factory.createUserDao();
		User user = new User();
		user.setUsername("demo");
		user.setPassword("demo".toCharArray());
		userDao.addUser(user);
		
		IRoleDao roleDao = factory.createRoleDao();
		roleDao.getRole("admin");
		
		IProductDao productDao = factory.createProductDao();
		Product product = new Product();
		productDao.removeProduct(product);

	}

}
