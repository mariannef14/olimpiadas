package com.atletasbr.olimpiadas.model;

import com.atletasbr.olimpiadas.model.enums.EventTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "paris_olympic_games")
public class ParisOlympicGamesModel extends BaseEntity{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "athlete_id")
    private AthleteModel athlete;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "modality_id")
    private ModalityModel modality;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "event_id")
    private EventTypeEnum eventId;

    private LocalDate dateParticipation;

    private int position;

}