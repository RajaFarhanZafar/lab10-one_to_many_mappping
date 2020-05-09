package com.example.lab10one_to_many_mappping.repository;

import com.example.lab10one_to_many_mappping.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository {
    ApplicationUser findByUsername(String username);
}
