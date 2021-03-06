package com.example.lab10one_to_many_mappping.service;

import com.example.lab10one_to_many_mappping.entity.Country;
import com.example.lab10one_to_many_mappping.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    public Country addOrUpdate(Country country)
    {
        return countryRepository.save(country);
    }
    public boolean deleteById(int id)
    {
        countryRepository.deleteById(id);
        return true;
    }
    public List<Country> getAll(){
        return countryRepository.findAll();
    }
    public Country getById(int id){
        return countryRepository.findById(id).get();
    }
}
