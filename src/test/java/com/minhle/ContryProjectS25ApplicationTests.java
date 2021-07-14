package com.minhle;

import com.minhle.model.Country;
import com.minhle.service.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ContryProjectS25ApplicationTests {
	@Autowired
	CountryService countryService;
	@Test
	void contextLoads() {
	}
	
	@Test
	void testSaveCountry() {
		countryService.addCountries(new Country("Vietnam",1000));
		countryService.addCountries(new Country("USA",2000));
		countryService.addCountries(new Country("China",3000));
		countryService.addCountries(new Country("Japan",4000));
		countryService.addCountries(new Country("ThaiLan", 400002));
	}
	@Test
	void listAllCountries(){
		System.out.println(countryService.getAllCountries());
	}
}
