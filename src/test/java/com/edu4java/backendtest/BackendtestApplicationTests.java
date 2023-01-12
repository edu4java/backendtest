package com.edu4java.backendtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.edu4java.backendtest.model.PvpResponse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BackendtestApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

	@Test
	void test_14_10() {
		PvpResponse r = restTemplate.getForObject("/pvp/1/35455/2020-06-14-10.00.00", PvpResponse.class);
		assertEquals(r.getPriceList(), 1);
		assertEquals(r.getBrandId(), 1);
		assertEquals(r.getProductId(), 35455);
		assertEquals(formatter.format(r.getStartDate()), "2020-06-14-00.00.00");
		assertEquals(formatter.format(r.getEndDate()), "2020-12-31-23.59.59");
		assertEquals(r.getPrice(), 35.5);
		assertEquals(r.getCurrency(), "EUR");
	}
	
	@Test
	void test_14_16() {
		PvpResponse r = restTemplate.getForObject("/pvp/1/35455/2020-06-14-16.00.00", PvpResponse.class);
		assertEquals(r.getPriceList(), 2);
		assertEquals(r.getBrandId(), 1);
		assertEquals(r.getProductId(), 35455);
		assertEquals(formatter.format(r.getStartDate()), "2020-06-14-15.00.00");
		assertEquals(formatter.format(r.getEndDate()), "2020-06-14-18.30.00");
		assertEquals(r.getPrice(),25.45);
		assertEquals(r.getCurrency(), "EUR");
	}
	
	@Test
	void test_14_21() {
		PvpResponse r = restTemplate.getForObject("/pvp/1/35455/2020-06-14-21.00.00", PvpResponse.class);
		assertEquals(r.getPriceList(), 1);
		assertEquals(r.getBrandId(), 1);
		assertEquals(r.getProductId(), 35455);
		assertEquals(formatter.format(r.getStartDate()), "2020-06-14-00.00.00");
		assertEquals(formatter.format(r.getEndDate()), "2020-12-31-23.59.59");
		assertEquals(r.getPrice(), 35.5);
		assertEquals(r.getCurrency(), "EUR");
	}

	@Test
	void test_15_10() {
		PvpResponse r = restTemplate.getForObject("/pvp/1/35455/2020-06-15-10.00.00", PvpResponse.class);
		assertEquals(r.getPriceList(), 3);
		assertEquals(r.getBrandId(), 1);
		assertEquals(r.getProductId(), 35455);
		assertEquals(formatter.format(r.getStartDate()), "2020-06-15-00.00.00");
		assertEquals(formatter.format(r.getEndDate()), "2020-06-15-11.00.00");
		assertEquals(r.getPrice(), 30.5);
		assertEquals(r.getCurrency(), "EUR");
	}

	@Test
	void test_16_21() {
		PvpResponse r = restTemplate.getForObject("/pvp/1/35455/2020-06-16-21.00.00", PvpResponse.class);
		assertEquals(r.getPriceList(), 4);
		assertEquals(r.getBrandId(), 1);
		assertEquals(r.getProductId(), 35455);
		assertEquals(formatter.format(r.getStartDate()), "2020-06-15-16.00.00");
		assertEquals(formatter.format(r.getEndDate()), "2020-12-31-23.59.59");
		assertEquals(r.getPrice(), 38.95);
		assertEquals(r.getCurrency(), "EUR");
	}

}
