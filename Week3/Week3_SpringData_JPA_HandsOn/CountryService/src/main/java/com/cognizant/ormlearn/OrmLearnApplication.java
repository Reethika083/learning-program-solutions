package com.cognizant.ormlearn;

import com.cognizant.ormlearn.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        try {
            testAddCountry(); // 🟢 Hands-on 7
            testUpdateCountry(); // 🟢 Hands-on 8
            testDeleteCountry(); // 🟢 Hands-on 9 ✅
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
    }

    private static void testAddCountry() throws CountryNotFoundException {
        LOGGER.info("Start testAddCountry");

        Country newCountry = new Country();
        newCountry.setCode("ZZ");
        newCountry.setName("Zootopia");

        countryService.addCountry(newCountry);

        Country country = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Country: {}", country);

        LOGGER.info("End testAddCountry");
    }

    private static void testUpdateCountry() throws CountryNotFoundException {
        LOGGER.info("Start testUpdateCountry");

        countryService.updateCountry("ZZ", "Zootopia Updated");

        Country updated = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Updated Country: {}", updated);

        LOGGER.info("End testUpdateCountry");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");

        countryService.deleteCountry("ZZ");

        LOGGER.info("Deleted country with code 'ZZ'");
        LOGGER.info("End testDeleteCountry");
    }
}
