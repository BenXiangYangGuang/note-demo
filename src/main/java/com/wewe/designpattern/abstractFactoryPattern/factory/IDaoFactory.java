package com.wewe.designpattern.abstractFactoryPattern.factory;


import com.wewe.designpattern.abstractFactoryPattern.dao.product.IProductDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.role.IRoleDao;
import com.wewe.designpattern.abstractFactoryPattern.dao.user.IUserDao;

public interface IDaoFactory {

	IUserDao createUserDao();
	IRoleDao createRoleDao();
	IProductDao createProductDao();

}
