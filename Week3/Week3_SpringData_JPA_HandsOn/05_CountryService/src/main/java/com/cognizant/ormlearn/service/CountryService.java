package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public Country findCountryByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    public void updateCountry(String code, String newName) {
        Optional<Country> optional = countryRepository.findById(code);
        if (optional.isPresent()) {
            Country country = optional.get();
            country.setName(newName);
            countryRepository.save(country);
        }
    }

    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    public List<Country> findCountriesByPartialName(String partial) {
        return countryRepository.findByNameContainingIgnoreCase(partial);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
