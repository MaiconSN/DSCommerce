package com.myproject.dscommerce.dto;

import com.myproject.dscommerce.entities.User;

public class ClientDTO {
	
	private Long id;
	private String name;
	
	public ClientDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}
	
	public ClientDTO() {
	}
	
	public ClientDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	
	

}
