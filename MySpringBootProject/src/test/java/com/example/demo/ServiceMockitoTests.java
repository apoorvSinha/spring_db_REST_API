package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.beans.Country;
import com.example.demo.repositories.CountryRepository;
import com.example.demo.services.CountryService;

@SpringBootTest(classes = {ServiceMockitoTests.class})
public class ServiceMockitoTests {

	
	@Mock
	CountryRepository countryrep;
	
	@InjectMocks
	CountryService countryservice;
	
	public List<Country> mycountries;
	
	@Test
	@Order(1)
	public void test_getAllCountries() {
		mycountries = new ArrayList<Country>();
		mycountries.add(new Country(1,"India","Delhi"));
		mycountries.add(new Country(2,"USA","Washington"));
		
		when(countryrep.findAll()).thenReturn(mycountries);//Mocking 
		assertEquals(2,countryservice.getAllCountries().size());
	}
	
	
}
