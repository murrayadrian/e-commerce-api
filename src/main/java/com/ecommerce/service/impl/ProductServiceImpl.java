package com.ecommerce.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductItem;
import com.ecommerce.entity.Shop;
import com.ecommerce.model.request.creator.ProductCreator;
import com.ecommerce.model.request.update.ProducInfoUpdate;
import com.ecommerce.model.response.creator.ProductResponse;
import com.ecommerce.model.response.creator.ProductSaveResponse;
import com.ecommerce.model.response.detail.IProductDetail;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.repository.ProductItemRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.ShopRepository;
import com.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductItemRepository productItemRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ShopRepository shopRepository;

	@Override
	public IProductDetail getDetailById(Long productId) {
		return productRepository.findByIdDTO(productId);
	}

	@Override
	public List<ProductResponse> getAll(int pageNumber, int limit) {
		PageRequest page = PageRequest.of(pageNumber - 1, limit);
		Page<Product> products = productRepository.findAll(page);
		List<ProductResponse> response = new ArrayList<>();
		for(Product product : products) {
			ProductItem productItem = productItemRepository.findTop1ByProductOrderByPrice(product);
			double cheeppestPrice = productItem.getPrice();
			int qtySold = productItem.getQtySold();
			int discountRate = productItem.getDiscountRate();
			String image = productItem.getImage();
			response.add(new ProductResponse(product,cheeppestPrice, qtySold, discountRate, image));
		}
		return response;
	}

	@Override
	public ProductSaveResponse save(ProductCreator productCreator) {
		Category category = categoryRepository.findById(productCreator.getCategoryId()).get();
		Shop shop = shopRepository.findById(productCreator.getShopId()).get();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateTime = now.format(formatter);
		
		Product product = productCreator.convertDTOToEntity(category, shop, formatDateTime);
		Product result = productRepository.save(product);
		ProductSaveResponse response = new ProductSaveResponse(result);
		return response;
	}

	@Override
	public void updateInfo(ProducInfoUpdate producInfoUpdate) {
		Category category = categoryRepository.findById(producInfoUpdate.getCategoryId()).get();
		Product product = producInfoUpdate.convertToEntity(category);
		productRepository.save(product);
	}

	@Override
	public List<IProductDetail> getAllByCategoryId(Long id) {
		return productRepository.findAllByCategoryId(id);
	}
}
