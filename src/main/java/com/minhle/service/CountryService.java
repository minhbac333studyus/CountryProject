package com.minhle.service;

import com.minhle.model.Country;
import com.minhle.repo.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

 
@Service
public class CountryService {

	@Autowired 
	CountryRepo countryRepo;
	
	public List<Country> getAllCountries(){
		return countryRepo.findAll();
	}
	public void addCountries(Country country) {
		countryRepo.save(country);
	}

	public void deleteCountryById(int i) {
		countryRepo.deleteById(i);
	}
	public Country  getCountryById(int i) {
		return countryRepo.getById(i);
	}
	public void saveCountry(Country country) {
		// TODO Auto-generated method stub
		countryRepo.save(country);

	}
}
