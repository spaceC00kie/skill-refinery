package com.spacec00kie.requestmappingbackend;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {
    List<Pokemon> pokemonList = new ArrayList<>(List.of(new Pokemon(1, "Bulbasaur", "green")));
}
