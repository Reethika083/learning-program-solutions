package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List; // ✅ This import was missing!

public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findByNameContaining(String name);

    List<Country> findByNameContainingOrderByNameAsc(String name);

    List<Country> findByNameStartingWith(String prefix);
}
