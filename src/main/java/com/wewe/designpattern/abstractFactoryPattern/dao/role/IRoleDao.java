package com.wewe.designpattern.abstractFactoryPattern.dao.role;


import com.wewe.designpattern.abstractFactoryPattern.bean.Role;

public interface IRoleDao {
	
	void addRole(Role role);
	void removeRole(Role role);
	Role getRole(String rolename);

}
