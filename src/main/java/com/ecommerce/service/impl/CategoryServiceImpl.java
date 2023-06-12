package com.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Category;
import com.ecommerce.model.request.creator.CategoryRequest;
import com.ecommerce.model.request.update.CategoryUpdate;
import com.ecommerce.model.request.update.LeafCategory;
import com.ecommerce.model.response.creator.CategoryResponse;
import com.ecommerce.model.response.detail.ICategoryDetail;
import com.ecommerce.model.response.list.ICategoryList;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public ICategoryDetail getDetailById(Long categoryId) {
		return categoryRepository.findByIdDTO(categoryId);
	}
	
	

	@Override
	public List<ICategoryList> getLevel1Category(int level) {
//		Pageable pageable = PageRequest.of(page, SIZE, Sort.by("name").descending());
		List<ICategoryList> response = categoryRepository.getLevel1Category(level);
		return response;
	}

	@Override
	public CategoryResponse save(CategoryRequest categoryRequest) {
		String parentKey = categoryRequest.getParentKey();
		Category parentCategory = categoryRepository.findByUrlKey(parentKey);
		Category category = categoryRequest.convertDTOToEntity(parentCategory);
		Category result = categoryRepository.save(category);
		CategoryResponse categoryResponse = new CategoryResponse().convertEntityToResponse(result);
		return categoryResponse;
	}

	@Override
	public CategoryResponse update(CategoryUpdate categoryUpdate) {
		Category category = categoryUpdate.convertUpdateToEntity();
		Category result = categoryRepository.save(category);
		CategoryResponse categoryResponse = new CategoryResponse().convertEntityToResponse(result);
		return categoryResponse;
	}

	@Override
	public List<ICategoryList> getAll() {
		return categoryRepository.getAll();
	}

	@Override
	public List<ICategoryList> getSubCategory(Long parentId) {
		if(parentId == 0l) {
			return categoryRepository.findByNullParentId();
		}
		return categoryRepository.findByParentId(parentId);
	}

	@Override
	public CategoryResponse setLeaf(LeafCategory leafCategory) {
		String urlKey = leafCategory.getUrlKey();
		Category category = categoryRepository.findByUrlKey(urlKey);
		if(category != null) {
			category.setLeaf(true);
			Category result = categoryRepository.save(category);
			CategoryResponse categoryResponse = new CategoryResponse().convertEntityToResponse(result);
			return categoryResponse;
		}
		System.out.println("cannot find urlKey + " + urlKey);
		return new CategoryResponse();
	}

}
