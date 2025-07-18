package com.myproject.dscommerce.dto;

import com.myproject.dscommerce.entities.Product;

public class ProductMinDTO {

	private Long id;
	private String name;
	private Double price;
	private String imgUrl;
	
	public ProductMinDTO() {
		
	}
	
	public ProductMinDTO(Long id, String name, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	public ProductMinDTO(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.price = entity.getPrice();
		this.imgUrl = entity.getImgUrl();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}
	
	
	
	
}
