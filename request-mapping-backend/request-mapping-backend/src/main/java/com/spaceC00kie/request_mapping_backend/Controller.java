package com.spaceC00kie.request_mapping_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/pokemon")
public class Controller {
    @Autowired
    PokemonService PokemonService;

    @GetMapping("/list")
    public List<Pokemon> list() {
        return PokemonService.pokemonList;
    }

    @PostMapping("/add")
    public List<Pokemon> add(@RequestBody Pokemon pokemon) {
        PokemonService.pokemonList.add(pokemon);
        return PokemonService.pokemonList;
    }

    @DeleteMapping("/delete")
    public List<Pokemon> delete(@RequestBody Pokemon pokemon) {
        PokemonService.pokemonList.remove(pokemon);
        return PokemonService.pokemonList;
    }

    @PatchMapping("/patch")
    public List<Pokemon> patch(@RequestBody Pokemon newPokemon) {
        PokemonService.pokemonList = PokemonService.pokemonList.parallelStream()
                .map((oldPokemon) -> oldPokemon.id() == newPokemon.id() ? newPokemon : oldPokemon)
                .collect(Collectors.toList());
        return PokemonService.pokemonList;
    }
}
