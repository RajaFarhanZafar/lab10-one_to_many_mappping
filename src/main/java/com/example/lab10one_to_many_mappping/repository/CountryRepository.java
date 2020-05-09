package com.example.lab10one_to_many_mappping.repository;

import com.example.lab10one_to_many_mappping.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
}
