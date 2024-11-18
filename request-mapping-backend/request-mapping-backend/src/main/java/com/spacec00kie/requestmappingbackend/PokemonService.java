package com.spacec00kie.requestmappingbackend;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    private final Jedis r;

    @Autowired
    public PokemonService(Jedis jedis) {
        this.r = jedis;
    }

    public String proofRedisWorks() {
        return r.get("foo");
    }

    public List<Pokemon> getPokemonList() {
        Map<String, String> serializedData = r.hgetAll("pokemon");

        return serializedData.values().stream()
                .map(json -> {
                    try {
                        return RedisUtils.deserialize(json, Pokemon.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .sorted(Comparator.comparingInt(Pokemon::id))
                .collect(Collectors.toList());
    }

    public List<Pokemon> addPokemon(Pokemon pokemon) throws IOException {
        r.hset("pokemon", String.valueOf(pokemon.id()), RedisUtils.serialize(pokemon));
        return getPokemonList();
    }

    public List<Pokemon> deletePokemon(Pokemon pokemon) {
        r.hdel("pokemon", String.valueOf(pokemon.id()));
        return getPokemonList();
    }
}
