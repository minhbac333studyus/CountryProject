package com.minhle.controller;

import com.minhle.model.Country;
import com.minhle.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class HomeController {
	@Autowired
	CountryService countryService;

	@RequestMapping ("/countriesList") //the link was hyperlinked in index.html - when we open the link, we call this function
	public String listAllCountries(Model model) {
		List<Country> countries = countryService.getAllCountries();
		System.out.println(countries);
		model.addAttribute("keyContries", countries);
		return "list_countries" ;//this is the view name list_countries.html
	}
	
	@RequestMapping("/")
	public String welcome() {
		return "index";
	}
	@RequestMapping("/delete/{idhere}") 
	public String deleteCountry(@PathVariable (name = "idhere") int id) {
		countryService.deleteCountryById(id);
		return "redirect:/countriesList";
	}
	@RequestMapping("/getCountry/{id}")
	public String getCountryById(@PathVariable (name = "id") int id, Model model) {
		model.addAttribute("countryKey", countryService.getCountryById(id));
		return "countryInfo"; 
	}
	@RequestMapping("/countriesListHL")
	public String getListCountryHyperLink(Model model) {
		List<Country> countries = countryService.getAllCountries();
 
		model.addAttribute("keyContries", countries);
		return "list_countriesHL" ;//this is the view name list_countries.html
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCountryPage(@PathVariable (name = "id" ) int id) {
		ModelAndView modelAndView = new ModelAndView("edit_country");
		Country countryNeedChange = countryService.getCountryById(id);
		modelAndView.addObject("countryMAV", countryNeedChange);
		return modelAndView;
		
	}

	@PostMapping("/create")
	public String createCountry(   Country country, BindingResult result, Model model){
		if(result.hasErrors()){
			return "create_country";
		}
		countryService.saveCountry(country);
		return "redirect:/countriesList";


	}

	@GetMapping("/showCreateCountryForm")
	public String showCreateCountryForm(Country country){
		return "create_country";
	}

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCountry(@ModelAttribute("countryAtrribute") Country country) {
		countryService.saveCountry(country);
		return "redirect:/countriesList";
	}


	
	
}
