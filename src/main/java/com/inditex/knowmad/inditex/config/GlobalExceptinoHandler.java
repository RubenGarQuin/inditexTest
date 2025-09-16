package com.inditex.knowmad.inditex.config;


import com.inditex.knowmad.inditex.domain.exception.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


import java.util.Map;


/**
 * Manejador global de excepciones
 */
@ControllerAdvice
public class GlobalExceptinoHandler {


    /**
     * Manejo de excepcion propia de la capa de dominio
     */
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handlePriceNotFoundException(PriceNotFoundException ex){
        Map<String, Object> error = Map.of(
                "Error", ex.getMessage(),
                "code", HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Manejo de excepciones relacionadas con los parametros de entrada.
     */
    @ExceptionHandler({
            IllegalArgumentException.class,
            MissingServletRequestParameterException.class,
            MethodArgumentTypeMismatchException.class
    })
    public ResponseEntity<Map<String,Object>> handleMissingRequestParam(Exception ex){
        Map<String, Object> error = Map.of(
                "Error", ex.getMessage(),
                "code", HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Manejador para el resto de excepciones no valoradas en los anteriores exceptionHandler.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> allException(Exception ex){
        Map<String, Object> error = Map.of(
                "Error", ex.getMessage(),
                "code", HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
