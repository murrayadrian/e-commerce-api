package com.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Role;
import com.ecommerce.model.request.creator.RoleCreatorRequest;
import com.ecommerce.model.request.update.RoleUpdateRequest;
import com.ecommerce.model.response.creator.RoleCreatorResponse;
import com.ecommerce.model.response.detail.IRoleDetail;
import com.ecommerce.model.response.exception.BadRequestException;
import com.ecommerce.model.response.list.IRoleList;
import com.ecommerce.model.response.update.RoleUpdateResponse;
import com.ecommerce.repository.RoleRepository;
import com.ecommerce.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public IRoleDetail getDetailById(Long roleId) {
		return roleRepository.findByIdDTO(roleId);
	}

	@Override
	public List<IRoleList> getAllRole() {
		return roleRepository.findAllDTO();
	}

	@Override
	public RoleCreatorResponse save(RoleCreatorRequest roleCreator) {
		if (roleRepository.existsByName(roleCreator.getName())) {
			throw new BadRequestException("Role is already taken!");
		}
		Role roleRequest = roleCreator.convertModelToEntity();
		Role result = roleRepository.save(roleRequest);
		RoleCreatorResponse roleResponse = new RoleCreatorResponse().convertEntityToModel(result);
		return roleResponse;
	}

	@Override
	public RoleUpdateResponse update(RoleUpdateRequest roleUpdate) {
		boolean isExistRole = roleRepository.isExistRoleUpdate(roleUpdate.getId(), roleUpdate.getName());
		if (isExistRole) {
			throw new BadRequestException("Role is already taken!");
		}
		Role role = roleUpdate.convertToEntity();
		Role result = roleRepository.save(role);
		RoleUpdateResponse roleResponse = new RoleUpdateResponse().convertEntityToModel(result);
		return roleResponse;

	}

}
