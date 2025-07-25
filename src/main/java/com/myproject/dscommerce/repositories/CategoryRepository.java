package com.myproject.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.dscommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
