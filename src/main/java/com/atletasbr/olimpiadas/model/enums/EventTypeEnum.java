package com.atletasbr.olimpiadas.model.enums;


public enum EventTypeEnum {

    STREET_FEMININO("Street Feminino"),
    STREET_MASCULINO("Street Masculino"),
    PARK_FEMININO("Park Feminino"),
    PARK_MASCULINO("Park Masculino"),
    SIMPLES_MASCULINO("Simples Masculino"),
    SIMPLES_FEMININO("Simples Feminino");


    final String name;


    EventTypeEnum(String name){
        this.name = name;
    }

}