package com.spaceC00kie.request_mapping_backend;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {
    List<Pokemon> pokemonList = new ArrayList<>(List.of(new Pokemon(1, "Bulbasaur", "green")));
}
