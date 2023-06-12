package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.request.creator.ShopCreatorRequest;
import com.ecommerce.model.request.update.ShopUpdateRequest;
import com.ecommerce.model.response.creator.ShopCreatorResponse;
import com.ecommerce.model.response.detail.IShopDetail;
import com.ecommerce.model.response.list.IShopList;
import com.ecommerce.model.response.update.ShopUpdateResponse;

public interface ShopService {

	public IShopDetail getDetailById(Long shopId);

	public List<IShopList> getAllShop();

	public ShopCreatorResponse save(ShopCreatorRequest shopCreator);

	public ShopUpdateResponse update(ShopUpdateRequest shopUpdate);
}
