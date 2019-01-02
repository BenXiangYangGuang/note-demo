package com.wewe.designpattern.abstractFactoryPattern.dao.user;

import com.wewe.designpattern.abstractFactoryPattern.bean.User;

public interface IUserDao {
	
	void addUser(User user);
	void removeUser(User user);
	User getUser(String username);

}
