package com.breiner.handleexception.exception;

import com.breiner.handleexception.dto.PokemonError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //to manage exceptions which come to RestControllers
public class HandleException {

    @ExceptionHandler(PokemonNotFound.class)
    public ResponseEntity<PokemonError> handlePokemonNotFound(PokemonNotFound e) { //Catch PokemonNotFound
        PokemonError pokemonError = new PokemonError(e.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(pokemonError, pokemonError.getHttpStatus());
    }

}
