package com.inditex.knowmad.inditex.config;

import lombok.Getter;


/**
 * Enum que almacena los mensajes de los errores funcionales
 */
@Getter
public enum ExceptionMessages {
    PRICE_NOT_FOUND("No se ha encontrado precio para el producto %s de la marca %s en la fecha correspondiente (%s)");

    private final String message;
    ExceptionMessages(String message){
        this.message = message;
    }

    public String format(Object... args){
        return String.format(this.message,args);
    }
}
