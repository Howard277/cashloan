package com.ms.cashloan.config;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by wuketao on 2017/10/13.
 */
//@Configuration
public class MongodbConfig {
    @Value("${mongo.host}")
    String host;
    @Value("${mongo.port}")
    Integer port;
    @Value("${mongo.databaseName}")
    String databaseName;

    /**
     * 创建mongo
     *
     * @return
     */
    private Mongo getMongo() {
        Mongo mongo = new Mongo(host, port);
        return mongo;
    }

    /**
     * mongo模板对象
     *
     * @return
     */
    @Bean
    public MongoTemplate mongoTemplate() {
        MongoTemplate template = new MongoTemplate(getMongo(), databaseName);
        return template;
    }
}
