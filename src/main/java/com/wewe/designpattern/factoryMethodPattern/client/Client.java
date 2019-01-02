package com.wewe.designpattern.factoryMethodPattern.client;

import com.wewe.designpattern.factoryMethodPattern.dao.IUserDao;
import com.wewe.designpattern.factoryMethodPattern.factory.IDaoFactory;
import com.wewe.designpattern.factoryMethodPattern.dao.IUserDao;
import com.wewe.designpattern.factoryMethodPattern.factory.IDaoFactory;
import com.wewe.designpattern.factoryMethodPattern.factory.MySQLDaoFactory;

public class Client {

	public static void main(String[] args) {
		IDaoFactory factory = new MySQLDaoFactory();
		IUserDao userDao = factory.createUserDao();
		userDao.getUser("admin");

	}

}
