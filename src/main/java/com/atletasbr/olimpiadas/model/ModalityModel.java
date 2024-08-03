package com.atletasbr.olimpiadas.model;

import com.atletasbr.olimpiadas.model.enums.EventTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "modality")
public class ModalityModel extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private EventTypeEnum eventType;

}