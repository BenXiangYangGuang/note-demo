package com.wewe.designpattern.abstractFactoryPattern.factory;


import com.wewe.designpattern.abstractFactoryPattern.dao.product.IProductDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.product.MySQLProductDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.role.IRoleDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.role.MySQLRoleDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.user.IUserDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.user.MySQLUserDao;

public class MySQLDaoFactory implements IDaoFactory {

	@Override
	public IUserDao createUserDao() {
		return new MySQLUserDao();
	}

	@Override
	public IRoleDao createRoleDao() {
		return new MySQLRoleDao();
	}

	@Override
	public IProductDao createProductDao() {
		return new MySQLProductDao();
	}

}
