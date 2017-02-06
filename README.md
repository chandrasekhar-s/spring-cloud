# spring-cloud
Spring Boot sample projects covering Config Server, Eureka Server and Discovery, Zuul and Ribbob based load balancing

reservation-service, is simple REST service to test the config server
eureka-conusmer, shows how to discovery and consume a service from Eureka server using RESTTemplate and DiscoveryClient

eureka-server , a simple Eureka Server
eureka-client , a REST API that register itself with Eureka Server

zuul-gateway & ribbon-consumer , load balancing sample projects.
Run the "eureka-client" in differnt ports and access the endpoints.
Access "/ribbon" endpoint to see the responses


config-server, A sample config server. To run this you need a git project
Create a folder  and do a "git init" and place you properties file there.
Make sure , you do a "git add" and "git commit", after you change the file.
Config server pick only the files that are comitted.
Do a "curl -d {} http://localhost:8080/refresh"  , to propagate your changes.
