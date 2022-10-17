
package com.breiner.handleexception.web;

import com.breiner.handleexception.dto.PokemonDTO;
import com.breiner.handleexception.exception.PokemonNotFound;
import com.breiner.handleexception.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Predicate;

@AllArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class PokemonController {

    private PokemonService pokemonService;

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDTO> getPokemon(@PathVariable("id") Integer id) {
        Predicate<PokemonDTO> predicate = pokemonDTO -> pokemonDTO.getId() == id;

        PokemonDTO pokemonfound = pokemonService.getAll().stream().filter(predicate).findAny().
                orElseThrow((() -> new PokemonNotFound(String.format("Pokemon %s wasn't found", id))));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("id resource in", String.format("http://localhost:8080/api/v1/%s", id));

        return new ResponseEntity<>(pokemonfound, httpHeaders, HttpStatus.OK);
    }


}
