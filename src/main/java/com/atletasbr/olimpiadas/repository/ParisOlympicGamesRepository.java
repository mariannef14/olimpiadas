package com.atletasbr.olimpiadas.repository;

import com.atletasbr.olimpiadas.model.ParisOlympicGamesModel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;


public interface ParisOlympicGamesRepository extends JpaRepository<ParisOlympicGamesModel, UUID>, JpaSpecificationExecutor<ParisOlympicGamesModel> {

     List<ParisOlympicGamesModel> findAll(Specification<ParisOlympicGamesModel> olympics);

}