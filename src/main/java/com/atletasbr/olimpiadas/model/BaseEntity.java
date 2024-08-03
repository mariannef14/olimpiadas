package com.atletasbr.olimpiadas.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;


@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:MM:ss")
    private LocalDateTime createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:MM:ss")
    private LocalDateTime updatedAt;


    @PrePersist
    void prePersit(){

        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

    }

    @PreUpdate
    void preUpdate(){

        this.updatedAt = LocalDateTime.now();

    }

}
