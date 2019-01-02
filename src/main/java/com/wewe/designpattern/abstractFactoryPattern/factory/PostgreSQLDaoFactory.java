package com.wewe.designpattern.abstractFactoryPattern.factory;

import com.wewe.designpattern.abstractFactoryPattern.dao.product.IProductDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.product.PostgreSQLProductDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.role.IRoleDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.role.PostgreSQLRoleDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.user.IUserDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.user.PostgreSQLUserDao;

public class PostgreSQLDaoFactory implements IDaoFactory {

	@Override
	public IUserDao createUserDao() {
		return new PostgreSQLUserDao();
	}

	@Override
	public IRoleDao createRoleDao() {
		return new PostgreSQLRoleDao();
	}

	@Override
	public IProductDao createProductDao() {
		return new PostgreSQLProductDao();
	}

}
