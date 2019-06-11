package com.blume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.blume.core.common.AbstractUserOperation;
import com.blume.core.deserialize.InstanceDeserializer;

@SpringBootApplication
@ComponentScan("com.blume")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Blumecoreapi extends SpringBootServletInitializer {

	@Autowired
	private InstanceDeserializer instanceDeserializer;
	
	public static void main(String[] args) {
		SpringApplication.run(Blumecoreapi.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Blumecoreapi.class);
	}
	
	@Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
	    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	    builder.deserializerByType(AbstractUserOperation.class,instanceDeserializer);
	    return builder;
	}

}
