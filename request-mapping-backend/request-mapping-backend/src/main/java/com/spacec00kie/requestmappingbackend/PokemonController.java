package com.spacec00kie.requestmappingbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.UnifiedJedis;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    PokemonService PokemonService;
    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/proof")
    public String proof(){
        return pokemonService.proofRedisWorks();
    }

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
