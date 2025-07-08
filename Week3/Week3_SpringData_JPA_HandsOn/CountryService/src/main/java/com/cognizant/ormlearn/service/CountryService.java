package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.exception.CountryNotFoundException;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // ✅ Hands-on 7: Add Country
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    // ✅ Hands-on 8: Find Country
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found: " + countryCode);
        }
        return result.get();
    }

    // ✅ Hands-on 8: Update Country
    @Transactional
    public void updateCountry(String code, String newName) throws CountryNotFoundException {
        Country country = findCountryByCode(code);
        country.setName(newName);
        countryRepository.save(country);
    }

    // ✅ Hands-on 9: Delete Country
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    // ✅ Hands-on 1A: Find by containing text
    @Transactional
    public List<Country> findByNameContaining(String name) {
        return countryRepository.findByNameContaining(name);
    }

    // ✅ Hands-on 1B: Containing + sorted
    @Transactional
    public List<Country> findByNameContainingSorted(String name) {
        return countryRepository.findByNameContainingOrderByNameAsc(name);
    }

    // ✅ Hands-on 1C: Starting with letter
    @Transactional
    public List<Country> findByStartingLetter(String letter) {
        return countryRepository.findByNameStartingWith(letter);
    }
}
