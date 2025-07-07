package com.myproject.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.dscommerce.entities.OrderItem;
import com.myproject.dscommerce.entities.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
