package com.atletasbr.olimpiadas.config.exception.handlers;


public class DataAlreadyExistsException extends RuntimeException {

    public DataAlreadyExistsException(){
        super("Dado cadastrado já existe");
    }


    public DataAlreadyExistsException(String message){
        super(message);
    }


}
