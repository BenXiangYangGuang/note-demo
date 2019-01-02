package com.wewe.designpattern.abstractFactoryPattern.dao.role;

import com.wewe.designpattern.abstractFactoryPattern.bean.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostgreSQLRoleDao implements IRoleDao {

	private static final Logger LOG = LoggerFactory.getLogger(PostgreSQLRoleDao.class);

	@Override
	public void addRole(Role role) {
		LOG.info("PostgreSQL added Role {}", role);
	}

	@Override
	public void removeRole(Role role) {
		LOG.info("PostgreSQL removed Role {}", role);
	}

	@Override
	public Role getRole(String rolename) {
		Role role = new Role();
		role.setRolename(rolename);
		return role;
	}

}
