package com.edu4java.backendtest.model;

import java.time.LocalDateTime;

public class PvpResponse {
	private Long priceList;
	private Long brandId;
	private Long productId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Double price;
	private String currency;

	public PvpResponse(Long priceList, Long brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate,
			Double price, String currency) {
		this.priceList = priceList;
		this.brandId = brandId;
		this.productId = productId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.currency = currency;
	}

	public Long getPriceList() {
		return priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
