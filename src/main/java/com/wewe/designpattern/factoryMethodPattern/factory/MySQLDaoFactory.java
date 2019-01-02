package com.wewe.designpattern.factoryMethodPattern.factory;

import com.wewe.designpattern.factoryMethodPattern.dao.IUserDao;
import com.wewe.designpattern.factoryMethodPattern.dao.MySQLUserDao;
import com.wewe.designpattern.factoryMethodPattern.dao.IUserDao;
import com.wewe.designpattern.factoryMethodPattern.dao.MySQLUserDao;

public class MySQLDaoFactory implements IDaoFactory {

	@Override
	public IUserDao createUserDao() {
		return new MySQLUserDao();
	}

}
