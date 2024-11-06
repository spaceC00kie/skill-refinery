package com.spacec00kie.requestmappingbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.UnifiedJedis;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    private final UnifiedJedis j;

    @Autowired
    public PokemonService(UnifiedJedis jedis) {
        this.j = jedis;
    }

    List<Pokemon> pokemonList = new ArrayList<>(List.of(new Pokemon(1, "Bulbasaur", "green")));

    public String proofRedisWorks() {
        String bar = j.get("foo");
        return bar;
    }


}
