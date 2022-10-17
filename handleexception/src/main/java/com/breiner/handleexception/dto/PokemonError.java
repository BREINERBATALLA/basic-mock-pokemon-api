package com.breiner.handleexception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PokemonError {
    private String message;
    private HttpStatus httpStatus;
}
