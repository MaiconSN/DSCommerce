package com.myproject.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.dscommerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	
	
}
