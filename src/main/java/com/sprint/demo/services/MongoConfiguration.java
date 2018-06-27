package com.sprint.demo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@EnableMongoRepositories
public class MongoConfiguration {
	 @Value("${spring.data.mongodb.host}")
	    protected String mongoHost;
	   
	    @Value("${spring.data.mongodb.port}")
	    protected Integer mongoPort;
	    
	    @Value("${spring.data.mongodb.database}")
	    protected String mongoDB;
	    
	    @Bean
		public MongoTemplate mongoTemplate() throws Exception {
			return new MongoTemplate(new MongoClient(mongoHost,mongoPort.intValue()),mongoDB);
		}
	    
	    @Bean
	    public PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
	          return new PropertySourcesPlaceholderConfigurer();
	    }
}
