package com.spacec00kie.requestmappingbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    PokemonService pokemonService;

    @GetMapping("/proof")
    public String proof(){
        return pokemonService.proofRedisWorks();
    }

    @GetMapping("/list")
    public List<Pokemon> list() {
        return pokemonService.pokemonList;
    }

    @PostMapping("/add")
    public List<Pokemon> add(@RequestBody Pokemon pokemon) {
        pokemonService.pokemonList.add(pokemon);
        return pokemonService.pokemonList;
    }

    @DeleteMapping("/delete")
    public List<Pokemon> delete(@RequestBody Pokemon pokemon) {
        pokemonService.pokemonList.remove(pokemon);
        return pokemonService.pokemonList;
    }

    @PatchMapping("/patch")
    public List<Pokemon> patch(@RequestBody Pokemon newPokemon) {
        pokemonService.pokemonList = pokemonService.pokemonList.parallelStream()
                .map((oldPokemon) -> oldPokemon.id() == newPokemon.id() ? newPokemon : oldPokemon)
                .collect(Collectors.toList());
        return pokemonService.pokemonList;
    }
}
