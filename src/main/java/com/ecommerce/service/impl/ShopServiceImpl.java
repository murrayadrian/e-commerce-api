package com.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Shop;
import com.ecommerce.model.request.creator.ShopCreatorRequest;
import com.ecommerce.model.request.update.ShopUpdateRequest;
import com.ecommerce.model.response.creator.ShopCreatorResponse;
import com.ecommerce.model.response.detail.IShopDetail;
import com.ecommerce.model.response.exception.BadRequestException;
import com.ecommerce.model.response.list.IShopList;
import com.ecommerce.model.response.update.ShopUpdateResponse;
import com.ecommerce.repository.ShopRepository;
import com.ecommerce.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopRepository shopRepository;

	@Override
	public IShopDetail getDetailById(Long shopId) {
		return shopRepository.findByIdDTO(shopId);
	}

	@Override
	public List<IShopList> getAllShop() {
		return shopRepository.findAllDTO();
	}

	@Override
	public ShopCreatorResponse save(ShopCreatorRequest shopCreator) {
		if (shopRepository.existsByName(shopCreator.getName())) {
			throw new BadRequestException("Shop is already taken!");
		}
		Shop shopRequest = shopCreator.convertModelToEntity();
		Shop result = shopRepository.save(shopRequest);
		ShopCreatorResponse shopResponse = new ShopCreatorResponse().convertEntityToModel(result);
		return shopResponse;
	}

	@Override
	public ShopUpdateResponse update(ShopUpdateRequest shopUpdate) {
		boolean isExistShop = shopRepository.isExistNameUpdate(shopUpdate.getId(), shopUpdate.getName());
		if (isExistShop) {
			throw new BadRequestException("Shop is already taken!");
		}
		Shop shop = shopUpdate.convertModelToEntity();
		Shop result = shopRepository.save(shop);
		ShopUpdateResponse shopResponse = new ShopUpdateResponse().convertEntityToModel(result);
		return shopResponse;
	}

}
