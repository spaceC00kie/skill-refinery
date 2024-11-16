package com.spacec00kie.requestmappingbackend;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PokemonControllerTest {

    @Autowired
    PokemonController pokemonController;

    private final Jedis r;

    @Autowired
    public PokemonControllerTest(Jedis jedis) {
        this.r = jedis;
    }

    @BeforeEach
    void setUp() throws JsonProcessingException {
        r.select(1);
        r.flushDB();
        Pokemon pokemon = new Pokemon(1, "Bulbasaur", "green");
        r.hset("pokemon", String.valueOf(pokemon.id()), RedisUtils.serialize(pokemon));
    }

    @AfterEach
    void tearDown() {
        r.flushDB();
    }

    @Test
    void proof() {
        String itWorks = pokemonController.proof();
        assertEquals("bar", itWorks);
    }

    @Test
    void list() throws IOException {
        List<Pokemon> actual = pokemonController.list();
        Pokemon pokemon = new Pokemon(1, "Bulbasaur", "green");
        List<Pokemon> expected = new ArrayList<>();
        expected.add(pokemon);

        assertEquals(expected, actual);
    }

    @Test
    void add() throws IOException {
        Pokemon bulbasaur = new Pokemon(1, "Bulbasaur", "green");
        Pokemon ivysaur = new Pokemon(2, "Ivysaur", "teal");

        List<Pokemon> actual = pokemonController.add(ivysaur);

        List<Pokemon> expected = new ArrayList<>();
        expected.add(ivysaur);
        expected.add(bulbasaur);

        assertEquals(expected, actual);
    }

    @Test
    void delete() {
    }

    @Test
    void patch() {
    }
}