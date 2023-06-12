package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.request.creator.ProductCreator;
import com.ecommerce.model.request.update.ProducInfoUpdate;
import com.ecommerce.model.response.creator.ProductResponse;
import com.ecommerce.model.response.creator.ProductSaveResponse;
import com.ecommerce.model.response.detail.IProductDetail;


public interface ProductService {
	public IProductDetail getDetailById(Long productId);

	public List<ProductResponse> getAll(int pageNumber, int limit);
	
	public List<IProductDetail> getAllByCategoryId(Long id);

	public ProductSaveResponse save(ProductCreator productcreator);

	public void updateInfo(ProducInfoUpdate producInfoUpdate);
	
//	public void markDown(ProductMarkDownUpdate productMarkDownUpdate);
	
//	public void updateQty(ProductQtyUpdate productQtyUpdate);
	
}
