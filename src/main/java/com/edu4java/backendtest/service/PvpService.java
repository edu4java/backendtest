package com.edu4java.backendtest.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu4java.backendtest.model.Price;
import com.edu4java.backendtest.model.PvpResponse;
import com.edu4java.backendtest.repo.PriceRepository;

@Service
public class PvpService {

	@Autowired
	private PriceRepository priceRepository;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

	public PvpResponse getPvp(Long brandId, Long productId, String date) {
		List<Price> prices = priceRepository.findByBrandProductAndDate(brandId, productId, LocalDateTime.parse(date, formatter));
		if (!prices.isEmpty()) {
			Price p = prices.stream().max(Comparator.comparing(x -> x.getPriority())).get();
			return new PvpResponse(p.getPriceList(),p.getBrand().getId(),p.getProductId(),p.getStartDate(),p.getEndDate(),p.getPrice(),p.getCurr());
		}
		return null;
	}
}
