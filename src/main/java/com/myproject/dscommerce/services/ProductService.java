package com.myproject.dscommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dscommerce.dto.ProductDTO;
import com.myproject.dscommerce.entities.Product;
import com.myproject.dscommerce.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		
		Product product = repository.findById(id).get();
		return new ProductDTO(product);
	}
	
}
