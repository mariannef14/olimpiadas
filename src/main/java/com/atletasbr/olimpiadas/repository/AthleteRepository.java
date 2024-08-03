package com.atletasbr.olimpiadas.repository;

import com.atletasbr.olimpiadas.model.AthleteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;
import java.util.UUID;


public interface AthleteRepository extends JpaRepository<AthleteModel, UUID> {

    boolean existsByRegistrationNumber(Integer number);

    @Query(nativeQuery = true,
           value =  "SELECT * " +
                    "FROM athlete " +
                    "WHERE name like %:name%")
    Set<AthleteModel> findByName(String name);

}