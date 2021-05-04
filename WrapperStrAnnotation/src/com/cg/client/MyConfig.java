package com.cg.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com")
@PropertySource("classpath:cg.properties")
public class MyConfig {
	
	@Bean
	public PropertySourcesPlaceholderConfigurer getPlaceholder()
	{
		PropertySourcesPlaceholderConfigurer holder= new PropertySourcesPlaceholderConfigurer();
		//holder.setLocation(new ClassPathResource("cg.properties"));
		return holder;
	}
}
