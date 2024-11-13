package com.spacec00kie.requestmappingbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    PokemonService pokemonService;

    @GetMapping("/proof")
    public String proof() {
        return pokemonService.proofRedisWorks();
    }

    @GetMapping("/list")
    public List<Pokemon> list() throws IOException {
        return pokemonService.getPokemonList();
    }

    @PostMapping("/add")
    public List<Pokemon> add(@RequestBody Pokemon pokemon) throws IOException {
        return pokemonService.addPokemon(pokemon);
    }

    @DeleteMapping("/delete")
    public List<Pokemon> delete(@RequestBody Pokemon pokemon) throws IOException {
        return pokemonService.deletePokemon(pokemon);
    }

    @PatchMapping("/patch")
    public List<Pokemon> patch(@RequestBody Pokemon pokemon) throws IOException {
        return pokemonService.addPokemon(pokemon);
    }
}
