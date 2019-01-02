package com.wewe.designpattern.abstractFactoryPattern.factory;

import com.wewe.designpattern.abstractFactoryPattern.dao.product.IProductDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.product.OracleProductDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.role.IRoleDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.role.OracleRoleDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.user.IUserDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.user.OracleUserDao;

public class OracleDaoFactory implements IDaoFactory {

	@Override
	public IUserDao createUserDao() {
		return new OracleUserDao();
	}

	@Override
	public IRoleDao createRoleDao() {
		return new OracleRoleDao();
	}

	@Override
	public IProductDao createProductDao() {
		return new OracleProductDao();
	}

}
