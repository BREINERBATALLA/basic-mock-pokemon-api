package com.breiner.handleexception.exception;

public class PokemonNotFound extends RuntimeException {
    public PokemonNotFound(String message) {
        super(message);
    }
}
