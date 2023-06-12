package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.request.creator.UserCreatorRequest;
import com.ecommerce.model.request.update.UserUpdateRequest;
import com.ecommerce.model.response.creator.UserCreatorResponse;
import com.ecommerce.model.response.detail.IUserDetail;
import com.ecommerce.model.response.list.IUserList;
import com.ecommerce.model.response.update.UserUpdateResponse;

public interface UserService {
	
	public IUserDetail getDetailById(Long userId);

	public List<IUserList> getAllUser();

	public UserCreatorResponse save(UserCreatorRequest userCreator);

	public UserUpdateResponse update(UserUpdateRequest userUpdate);
}
