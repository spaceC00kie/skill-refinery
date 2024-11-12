package com.spacec00kie.requestmappingbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.UnifiedJedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PokemonService {

    private final UnifiedJedis r;

    @Autowired
    public PokemonService(UnifiedJedis jedis) {
        this.r = jedis;
    }

    public String proofRedisWorks() {
        String bar = r.get("foo");
        return bar;
    }

    public List<Pokemon> getPokemonList() throws IOException {
        Map<String, String> serializedData = r.hgetAll("pokemon");
        List<Pokemon> pokemonList = new ArrayList<>();

        for (String json : serializedData.values()) {
            Pokemon pokemon = RedisUtils.deserialize(json, Pokemon.class);
            pokemonList.add(pokemon);
        }

        return pokemonList;
    }

    public List<Pokemon> addPokemon(Pokemon pokemon) throws IOException {
        r.hset("pokemon", String.valueOf(pokemon.id()), RedisUtils.serialize(pokemon));
        return getPokemonList();
    }

    public List<Pokemon> deletePokemon(Pokemon pokemon) throws IOException {
        r.hdel("pokemon", String.valueOf(pokemon.id()));
        return getPokemonList();
    }
}
