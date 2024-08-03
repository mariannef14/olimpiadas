package com.atletasbr.olimpiadas.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "athlete")
public class AthleteModel extends BaseEntity {

    private int age;

    private LocalDate dateBirth;

    private char sex;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "modality_id")
    private ModalityModel modality;

    private int totalMedals;

    private Integer registrationNumber;

}