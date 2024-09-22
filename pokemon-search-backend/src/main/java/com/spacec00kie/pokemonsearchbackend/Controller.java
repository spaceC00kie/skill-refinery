package com.spacec00kie.pokemonsearchbackend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class Controller {
    @GetMapping("/pokemon")
    public ResponseEntity<Map<String, Object>> getPokemonData() {
        Map<String, Object> response = new HashMap<>();

        List<Map<String, Object>> pokemonList = new ArrayList<>();

        pokemonList.add(createPokemon(1, "Bulbasaur", List.of("Grass", "Poison"), 45, 49, 49, 45,
                List.of(createAttack("Vine Whip", "Grass", 45), createAttack("Tackle", "Normal", 40))));

        pokemonList.add(createPokemon(4, "Charmander", List.of("Fire"), 39, 43, 52, 65,
                List.of(createAttack("Flamethrower", "Fire", 90), createAttack("Scratch", "Normal", 40))));

        pokemonList.add(createPokemon(7, "Squirtle", List.of("Water"), 44, 65, 48, 43,
                List.of(createAttack("Water Gun", "Water", 40), createAttack("Tackle", "Normal", 40))));

        pokemonList.add(createPokemon(10, "Caterpie", List.of("Bug"), 45, 35, 30, 45,
                List.of(createAttack("Tackle", "Normal", 40), createAttack("String Shot", "Bug", 0))));

        pokemonList.add(createPokemon(12, "Butterfree", List.of("Bug", "Flying"), 60, 50, 45, 70,
                List.of(createAttack("Gust", "Flying", 40), createAttack("Psybeam", "Psychic", 65))));

        pokemonList.add(createPokemon(16, "Pidgey", List.of("Normal", "Flying"), 40, 35, 45, 56,
                List.of(createAttack("Gust", "Flying", 40), createAttack("Quick Attack", "Normal", 40))));

        pokemonList.add(createPokemon(19, "Rattata", List.of("Normal"), 30, 35, 56, 72,
                List.of(createAttack("Tackle", "Normal", 40), createAttack("Bite", "Dark", 60))));

        pokemonList.add(createPokemon(25, "Pikachu", List.of("Electric"), 35, 40, 55, 90,
                List.of(createAttack("Thunderbolt", "Electric", 90), createAttack("Quick Attack", "Normal", 40))));

        pokemonList.add(createPokemon(35, "Clefairy", List.of("Fairy"), 70, 48, 45, 35,
                List.of(createAttack("Pound", "Normal", 40), createAttack("Disarming Voice", "Fairy", 40))));

        pokemonList.add(createPokemon(39, "Jigglypuff", List.of("Normal", "Fairy"), 115, 20, 45, 20,
                List.of(createAttack("Pound", "Normal", 40), createAttack("Play Rough", "Fairy", 90))));

        pokemonList.add(createPokemon(50, "Diglett", List.of("Ground"), 10, 25, 55, 95,
                List.of(createAttack("Scratch", "Normal", 40), createAttack("Mud-Slap", "Ground", 20))));

        pokemonList.add(createPokemon(54, "Psyduck", List.of("Water"), 50, 48, 52, 55,
                List.of(createAttack("Water Gun", "Water", 40), createAttack("Confusion", "Psychic", 50))));

        pokemonList.add(createPokemon(66, "Machop", List.of("Fighting"), 70, 50, 80, 35,
                List.of(createAttack("Karate Chop", "Fighting", 50), createAttack("Low Kick", "Fighting", 50))));

        pokemonList.add(createPokemon(74, "Geodude", List.of("Rock", "Ground"), 40, 100, 80, 20,
                List.of(createAttack("Rock Throw", "Rock", 50), createAttack("Tackle", "Normal", 40))));

        pokemonList.add(createPokemon(150, "Mewtwo", List.of("Psychic"), 106, 90, 110, 130,
                List.of(createAttack("Psychic", "Psychic", 90), createAttack("Shadow Ball", "Ghost", 80))));

        response.put("pokemon", pokemonList);

        return ResponseEntity.ok(response);
    }

    private Map<String, Object> createPokemon(int id, String name, List<String> types, int hp, int defense, int attack, int speed, List<Map<String, Object>> attacks) {
        Map<String, Object> pokemon = new HashMap<>();
        pokemon.put("id", id);
        pokemon.put("name", name);
        pokemon.put("types", types);
        pokemon.put("hp", hp);
        pokemon.put("defense", defense);
        pokemon.put("attack", attack);
        pokemon.put("speed", speed);
        pokemon.put("attacks", attacks);
        return pokemon;
    }

    private Map<String, Object> createAttack(String name, String type, int power) {
        Map<String, Object> attack = new HashMap<>();
        attack.put("name", name);
        attack.put("type", type);
        attack.put("power", power);
        return attack;
    }
}
