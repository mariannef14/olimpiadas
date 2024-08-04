package com.atletasbr.olimpiadas.config.exception.handlers;


public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(){
        super("Dado(s) não encontrado");
    }


    public DataNotFoundException(String message){
        super(message);
    }

}
