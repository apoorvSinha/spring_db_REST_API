package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Country;
import com.example.demo.services.CountryService;

@RestController
public class ContryConroller {
	
	//CountryService countryservice = new CountryService(); -instead this use
	//localhost:8080/getCountries
	//localhost:8080/getCountries/1
	//localhost:8080/getCountries/countryName?name=India
	//localhost:8080/addcountry
	//localhost:8080/deletecountry/1
	
	
	
	@Autowired	
	CountryService countryservice;		//dependency injection
	
	
	@GetMapping("/getCountries")
	public List<Country> getCountries(){
		return countryservice.getAllCountries();
	}
	
	
	@GetMapping("/getCountries/{id}")
	public ResponseEntity<Country> getCountryByID(@PathVariable(value="id") int id){
		try {
			Country country =  countryservice.getCountryID(id);			
			return new ResponseEntity<Country>(country, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@GetMapping("/getCountries/countryname")
	public ResponseEntity<Country> getCountryByName(@RequestParam(value="name") String countryName) {
		try {
			Country country =  countryservice.getCountrybyName(countryName);;			
			return new ResponseEntity<Country>(country, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addcountry")
	public Country AddCountry(@RequestBody Country country) {
		return countryservice.addCountry(country);
	}
	
	@PutMapping("/updatecountry/{id}")
	public ResponseEntity<Country> UpdateCountry(@PathVariable(value="id")int id, @RequestBody Country country) {
		
		try{
			Country existCountry = countryservice.getCountryID(id);
			existCountry.setCountryName(country.getCountryName());
			existCountry.setCountryCapital(country.getCountryCapital());
			Country updatedcountry = countryservice.updateCountry(existCountry);
			return new ResponseEntity<Country>(updatedcountry, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	@DeleteMapping("/deletecountry/{id}")
	public AddResponse DeleteCountry(@PathVariable(value="id") int id) {
		return countryservice.deleteCountry(id);
		
	}
	
	
	
}


/*
@Autowired	
CountryService countryservice;		//dependency injection


@GetMapping("/getCountries")
public List getCountries(){
	return countryservice.getAllCountries();
}


@GetMapping("/getCountries/{id}")
public Country getCountryByID(@PathVariable(value="id") int id){
	return countryservice.getCountryID(id);
}


@GetMapping("/getCountries/countryname")
public Country getCountryByName(@RequestParam(value="name") String countryName) {
	return countryservice.getCountrybyName(countryName);
	
}

@PostMapping("/addcountry")
public Country AddCountry(@RequestBody Country country) {
	return countryservice.addCountry(country);
}

@PutMapping("/updatecountry")
public Country UpdateCountry(@RequestBody Country country) {
	return countryservice.updateCountry(country);
}

@DeleteMapping("/deletecountry/{id}")
public AddResponse DeleteCountry(@PathVariable(value="id") int id) {
	return countryservice.deleteCountry(id);
}

*/