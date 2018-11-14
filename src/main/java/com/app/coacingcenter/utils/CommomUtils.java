package com.app.coacingcenter.utils;

import com.app.coacingcenter.entity.Role;

public class CommomUtils {

	public static Role getAdminRole() {

		Role role = new Role();
		role.setRoleId(1);
		role.setRoleName("ADMIN");
		return role;
	}

	public static Role getCenterHeadRole() {

		Role role = new Role();
		role.setRoleId(2);
		role.setRoleName("CENTER HEAD");
		return role;
	}

	public static Role getCounsellorRole() {

		Role role = new Role();
		role.setRoleId(3);
		role.setRoleName("COUNSELOR");
		return role;
	}

}
