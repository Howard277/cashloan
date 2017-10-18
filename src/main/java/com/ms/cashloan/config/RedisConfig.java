package com.ms.cashloan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by wuketao on 2017/10/13.
 */
//@Configuration
public class RedisConfig {
    @Value("${redis.maxActive}")
    Integer maxActive;
    @Value("${redis.maxIdle}")
    Integer maxIdle;
    @Value("${redis.maxWait}")
    Integer maxWait;
    @Value("${redis.default.db}")
    Integer db;
    @Value("${redis.host}")
    String host;
    @Value("${redis.port}")
    Integer port;
    @Value("${redis.password}")
    String password;
    @Value("${redis.timeout}")
    Integer timeout;

    private JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMaxTotal(maxActive);
        config.setMaxWaitMillis(maxWait);
        return config;
    }

    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory(getJedisPoolConfig());
        factory.setDatabase(db);
        factory.setHostName(host);
        factory.setPort(port);
        //    factory.setPassword(password)
        factory.setTimeout(timeout);
        factory.setUsePool(true);

        return factory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }
}
