package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.request.creator.CategoryRequest;
import com.ecommerce.model.request.update.CategoryUpdate;
import com.ecommerce.model.request.update.LeafCategory;
import com.ecommerce.model.response.creator.CategoryResponse;
import com.ecommerce.model.response.detail.ICategoryDetail;
import com.ecommerce.model.response.list.ICategoryList;

public interface CategoryService {


	
	public ICategoryDetail getDetailById(Long categoryId);

	public List<ICategoryList> getAll();
	
	public List<ICategoryList> getLevel1Category(int level);
	
	public List<ICategoryList> getSubCategory(Long parentId);

	public CategoryResponse save(CategoryRequest categoryRequest);

	public CategoryResponse update(CategoryUpdate categoryUpdate);
	
	public CategoryResponse setLeaf(LeafCategory leafCategory);
}
