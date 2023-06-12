package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.request.creator.RoleCreatorRequest;
import com.ecommerce.model.request.update.RoleUpdateRequest;
import com.ecommerce.model.response.creator.RoleCreatorResponse;
import com.ecommerce.model.response.detail.IRoleDetail;
import com.ecommerce.model.response.list.IRoleList;
import com.ecommerce.model.response.update.RoleUpdateResponse;

public interface RoleService {

	public IRoleDetail getDetailById(Long roleId);

	public List<IRoleList> getAllRole();

	public RoleCreatorResponse save(RoleCreatorRequest roleCreator);

	public RoleUpdateResponse update(RoleUpdateRequest roleUpdate);
}
