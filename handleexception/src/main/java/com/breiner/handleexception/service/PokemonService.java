package com.breiner.handleexception.service;

import com.breiner.handleexception.dto.PokemonDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service
public class PokemonService {
    private RestTemplate restTemplate;

    public List<PokemonDTO> getAll() {
        String endPoint = "https://634ccaf3acb391d34a8c1867.mockapi.io/api/v1/pokemons";
        PokemonDTO[] pokemonDTOS = restTemplate.getForObject(endPoint, PokemonDTO[].class);
        List<PokemonDTO> pokemonDTOList = Arrays.asList(pokemonDTOS);

        return pokemonDTOList;
    }
}
