package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("All countries:");
        List<Country> countries = countryService.getAllCountries();
        countries.forEach(System.out::println);

        System.out.println("\nFind by code 'IN':");
        System.out.println(countryService.findCountryByCode("IN"));

        System.out.println("\nFind countries with 'land':");
        countryService.findCountriesByPartialName("land").forEach(System.out::println);

        System.out.println("\nAdding new country...");
        countryService.addCountry(new Country() {
            {
                setCode("ZZ");
                setName("Zootopia");
            }
        });

        System.out.println("\nUpdating 'ZZ' to 'Zoolandia'");
        countryService.updateCountry("ZZ", "Zoolandia");

        System.out.println("\nAfter update:");
        System.out.println(countryService.findCountryByCode("ZZ"));

        System.out.println("\nDeleting 'ZZ'...");
        countryService.deleteCountry("ZZ");
    }
}
