package com.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Role;
import com.ecommerce.entity.User;
import com.ecommerce.model.request.creator.UserCreatorRequest;
import com.ecommerce.model.request.update.UserUpdateRequest;
import com.ecommerce.model.response.creator.UserCreatorResponse;
import com.ecommerce.model.response.detail.IUserDetail;
import com.ecommerce.model.response.exception.BadRequestException;
import com.ecommerce.model.response.list.IUserList;
import com.ecommerce.model.response.update.UserUpdateResponse;
import com.ecommerce.repository.RoleRepository;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public IUserDetail getDetailById(Long userId) {
		return userRepository.findByIdDTO(userId);
	}

	@Override
	public List<IUserList> getAllUser() {
		return userRepository.findAllDTO();
	}

	@Override
	public UserCreatorResponse save(UserCreatorRequest userCreator) {
		if (userRepository.existsByEmail(userCreator.getEmail())) {
			throw new BadRequestException("Email is already taken!");
		}
		if (userRepository.existsByPhone(userCreator.getPhone())) {
			throw new BadRequestException("Phone is already taken!");
		}
		Role role = roleRepository.findById(userCreator.getRoleId()).get();
		User user = userCreator.convertModelToEntity(role);
		User result = userRepository.save(user);
		UserCreatorResponse userResponse = new UserCreatorResponse().convertEntityToModel(result);
		return userResponse;
	}

	@Override
	public UserUpdateResponse update(UserUpdateRequest userUpdate) {
		boolean isExistEmail = userRepository.isExistEmail(userUpdate.getId(), userUpdate.getEmail());
		if (isExistEmail) {
			throw new BadRequestException("Email is already taken!");
		}
		boolean isExistPhone = userRepository.isExistPhone(userUpdate.getId(), userUpdate.getPhone());
		if (isExistPhone) {
			throw new BadRequestException("Phone is already taken!");
		}
		Role role = roleRepository.findById(userUpdate.getRoleId()).get();
		User user = userUpdate.convertToEntity(role);
		User result = userRepository.save(user);
		UserUpdateResponse userResponse = new UserUpdateResponse().convertEntityToModel(result);
		return userResponse;
	}

}
