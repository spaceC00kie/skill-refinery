package com.spacec00kie.requestmappingbackend;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.UnifiedJedis;

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
    void setUp() {
        r.select(1);
    }

    @AfterEach
    void tearDown() {
        r.select(0);
    }

    @Test
    void proof() {
        String itWorks = pokemonController.proof();
        assertEquals("bar", itWorks);
    }

    @Test
    void list() {
    }

    @Test
    void add() {
    }

    @Test
    void delete() {
    }

    @Test
    void patch() {
    }
}