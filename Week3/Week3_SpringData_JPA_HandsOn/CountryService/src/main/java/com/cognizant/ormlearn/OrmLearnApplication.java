package com.cognizant.ormlearn;

import com.cognizant.ormlearn.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.repository.StockRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static StockRepository stockRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        stockRepository = context.getBean(StockRepository.class);

        try {
            testAddCountry(); // Hands-on 7
            testUpdateCountry(); // Hands-on 8
            testDeleteCountry(); // Hands-on 9

            // ✅ Hands-on 2 stock queries
            testFacebookSept2019();
            testGoogleAbove1250();
            testTop3Volume();
            testLowestNetflix();

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

    private static void testFacebookSept2019() {
        LOGGER.info("Start testFacebookSept2019");
        List<Stock> stocks = stockRepository.findByCodeAndDateBetween("FB",
                LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30));
        stocks.forEach(s -> LOGGER.debug("{}", s));
        LOGGER.info("End testFacebookSept2019");
    }

    private static void testGoogleAbove1250() {
        LOGGER.info("Start testGoogleAbove1250");
        List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
        stocks.forEach(s -> LOGGER.debug("{}", s));
        LOGGER.info("End testGoogleAbove1250");
    }

    private static void testTop3Volume() {
        LOGGER.info("Start testTop3Volume");
        List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
        stocks.forEach(s -> LOGGER.debug("{}", s));
        LOGGER.info("End testTop3Volume");
    }

    private static void testLowestNetflix() {
        LOGGER.info("Start testLowestNetflix");
        List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        stocks.forEach(s -> LOGGER.debug("{}", s));
        LOGGER.info("End testLowestNetflix");
    }
}
