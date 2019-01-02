package com.wewe.designpattern.factoryMethodPattern.dao;


import com.wewe.designpattern.factoryMethodPattern.bean.User;

public interface IUserDao {
	
	void addUser(User user);
	void removeUser(User user);
	User getUser(String username);

}
