package com.spaceC00kie.request_mapping_backend;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/pokemon")
public class Controller {
    List<Pokemon> pokemonList = new ArrayList<>(List.of(new Pokemon(1, "Bulbasaur", "green")));

    @GetMapping("/list")
    public List<Pokemon> list() {
        return pokemonList;
    }

    @PostMapping("/add")
    public List<Pokemon> add(@RequestBody Pokemon pokemon) {
        pokemonList.add(pokemon);
        return pokemonList;
    }

    @DeleteMapping("/delete")
    public List<Pokemon> delete(@RequestBody Pokemon pokemon) {
        pokemonList.remove(pokemon);
        return pokemonList;
    }
}
