package com.wccwin.doc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@EnableEurekaClient
@EnableDiscoveryClient
@Configuration
@ComponentScan("com")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class DocApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
