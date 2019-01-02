package com.wewe.designpattern.factoryMethodPattern.factory;


import com.wewe.designpattern.factoryMethodPattern.dao.IUserDao;
import com.wewe.designpattern.factoryMethodPattern.dao.IUserDao;

public interface IDaoFactory {

	IUserDao createUserDao();

}
