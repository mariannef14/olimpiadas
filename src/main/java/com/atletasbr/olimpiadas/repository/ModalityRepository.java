package com.atletasbr.olimpiadas.repository;

import com.atletasbr.olimpiadas.model.ModalityModel;
import com.atletasbr.olimpiadas.model.enums.EventTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ModalityRepository extends JpaRepository<ModalityModel, UUID> {

    boolean existsByEventType(EventTypeEnum eventyType);

    @Query(nativeQuery = true,
            value = "SELECT * " +
                    "FROM modality " +
                    "WHERE name like %:name% ")
    List<ModalityModel> findByName(String name);

    Optional<ModalityModel> findByNameAndEventType(String name, EventTypeEnum eventType);

}