package com.sprint.demo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@EnableMongoRepositories
public class MongoConfiguration {
	 @Value("${spring.mongodb.host}")
	    protected String mongoHost;
	   
	    @Value("${spring.mongodb.port}")
	    protected int mongoPort;
	    
	    @Value("${spring.mongodb.db}")
	    protected String mongoDB;
	    
	    @Bean
		public MongoTemplate mongoTemplate() throws Exception {
			return new MongoTemplate(new MongoClient(mongoHost,mongoPort),mongoDB);
		}
}
