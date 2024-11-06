package com.spacec00kie.requestmappingbackend;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.UnifiedJedis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Configuration
public class RedisConfig {

    private static final Logger log = LoggerFactory.getLogger(RedisConfig.class);
    private UnifiedJedis jedis;

    @PostConstruct
    public void connect() {
        try {
            jedis = new UnifiedJedis("redis://localhost:6379");
            log.info("Successfully connected to Redis");
        } catch (Exception e) {
            log.error("Failed to connect to Redis", e);
        }
    }

    @Bean
    public UnifiedJedis jedisClient() {
        return jedis;
    }
}