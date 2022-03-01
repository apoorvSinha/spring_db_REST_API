package com.example.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Country;
import com.example.demo.controllers.AddResponse;
import com.example.demo.repositories.CountryRepository;

@Component
@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryrep;
	public List<Country> getAllCountries() {
		return countryrep.findAll();
	}

	public Country getCountryID(int id) {
		return countryrep.findById(id).get();
	}
	public Country getCountrybyName(String countryName) {
		List<Country> countries = countryrep.findAll();
		Country country=null;
		for(Country con: countries) {
			if(con.getCountryName().equalsIgnoreCase(countryName)) {
				country = con;
			}
		}
		return country;
	}
	public Country addCountry(Country country) {
		country.setId(getMaxId());
		countryrep.save(country);
		return country;
	}
	public int getMaxId() {
		return countryrep.findAll().size()+1;
	}
	public Country updateCountry(Country country) {
		countryrep.save(country);
		return country;
	}
	public AddResponse deleteCountry(int id) {
		countryrep.deleteById(id);
		AddResponse  res = new AddResponse();
		res.setMsg("Country deleted");
		res.setId(id);
		return res;
	}

}














/*
static HashMap<Integer, Country> countryIdMap;
public CountryService() {
	countryIdMap = new HashMap<Integer, Country>();
	Country indiaCountry = new Country(1, "India", "Delhi");
	Country usaCountry = new Country(2, "USA", "Washington");
	Country ukCountry = new Country(3, "UK", "London");
	
	countryIdMap.put(1, indiaCountry);
	countryIdMap.put(2, usaCountry);
	countryIdMap.put(3, ukCountry);
}
public List getAllCountries() {
	@SuppressWarnings("unchecked")
	List countries = new ArrayList(countryIdMap.values());
	return countries;
}

public Country getCountryID(int id) {
	Country country = countryIdMap.get(id);	//will return whole country object
	return country;
}
public Country getCountrybyName(String countryName) {
	//from id get object and from object get country name
	Country country = null;
	for(int i: countryIdMap.keySet()) {
		if(countryIdMap.get(i).getCountryName().equals(countryName)) {
			country = countryIdMap.get(i);
		}
	}
	return country;
}
public Country addCountry(Country country) {
		//id should be auto generate
	country.setId(getMaxId());
	countryIdMap.put(country.getId(), country);
	return country;
}
public static int getMaxId() {
	int max = 0;
	max = countryIdMap.keySet().size() +1;
	return max;
}
public Country updateCountry(Country country) {
	if(country.getId()>0) {
		countryIdMap.put(country.getId(), country);
	}
	return country;
}
public AddResponse deleteCountry(int id) {
	countryIdMap.remove(id);
	AddResponse res = new AddResponse();
	res.setMsg("COUNTRY DELETED");
	res.setId(id);
	
	return res;
}
*/
