package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
public class EurekaConsumer {

		public static void main(String[] args) {
		 SpringApplication.run(EurekaConsumer.class, args);
	}
	
	@Component
	class DiscoveryClientExample implements CommandLineRunner {

	    @Autowired
	    private DiscoveryClient discoveryClient;

	    @Override
	    public void run(String... strings) throws Exception {
	    	discoveryClient.getInstances("a-client-app").forEach((ServiceInstance s) -> {
	            System.out.println(s.getUri());
	        });
	    }
	}
	
	
	@Configuration
	public class PublicAPIConfiguration {
	    @LoadBalanced
	    @Bean
	    RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	}
	
	/**
	 * @author chandra
	 *
	 */
	@Component
	class RestTemplateExample implements CommandLineRunner {
	      	
		@Autowired
	    private RestTemplate restTemplate;

	    
	    @Override
	    public void run(String... strings) throws Exception {
	        String exchange =
	                restTemplate.getForObject("http://a-client-app/hello", String.class);
	        System.out.println(exchange);
	    }
	    

//	    @Override
//	    public void run(String... strings) throws Exception {
//	    	    discoveryClient.getInstances("a-client-app").forEach((ServiceInstance s) -> {
//	            System.out.println(s.getUri());
//	            String exchange =
//		                restTemplate().getForObject(s.getUri()+"/hello", String.class);
//	            System.out.println(exchange);
//	        });
	    }

	}



 
