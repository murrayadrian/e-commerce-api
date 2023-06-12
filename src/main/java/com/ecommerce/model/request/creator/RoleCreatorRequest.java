package com.ecommerce.model.request.creator;

import com.ecommerce.entity.Role;

public class RoleCreatorRequest {

	private String name;

	public Role convertModelToEntity() {
		Role role = new Role();
		role.setName(this.name);
		return role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
