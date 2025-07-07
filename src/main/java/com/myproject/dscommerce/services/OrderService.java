package com.myproject.dscommerce.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dscommerce.dto.OrderDTO;
import com.myproject.dscommerce.dto.OrderItemDTO;
import com.myproject.dscommerce.entities.Order;
import com.myproject.dscommerce.entities.OrderItem;
import com.myproject.dscommerce.entities.OrderStatus;
import com.myproject.dscommerce.entities.Product;
import com.myproject.dscommerce.entities.User;
import com.myproject.dscommerce.repositories.OrderItemRepository;
import com.myproject.dscommerce.repositories.OrderRepository;
import com.myproject.dscommerce.repositories.ProductRepository;
import com.myproject.dscommerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {

		Order order = orderRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new OrderDTO(order);

	}

	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order();
		
		order.setMoment(Instant.now());
		order.setStatus(OrderStatus.WAITING_PAYMENT);
		
		User user = userService.authenticated();
		order.setClient(user);
		
		for(OrderItemDTO itemDto : dto.getItems()) {
			Product product = productRepository.getReferenceById(itemDto.getProductId());
			OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
			order.getItems().add(item);
		}
		
		orderRepository.save(order);
		orderItemRepository.saveAll(order.getItems());
		
		return new OrderDTO(order);
		
	}
	
}
