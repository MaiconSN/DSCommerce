package com.myproject.dscommerce.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myproject.dscommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("SELECT new com.myproject.dscommerce.entities.Product(obj.id, obj.name, obj.description, obj.price, obj.imgUrl) "
			+ "FROM Product obj "
			+ "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%',:name, '%')) ")
	Page<Product> searchByName(String name, Pageable pageable);
	
	@Query("SELECT obj FROM Product obj JOIN FETCH obj.categories WHERE obj.id = :id")
	Optional<Product> findByIdWithCategories(@Param("id") Long id);
	
}
