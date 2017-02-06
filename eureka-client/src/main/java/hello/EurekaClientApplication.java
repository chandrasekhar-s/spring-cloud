package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}

@RestController
class ServiceInstanceRestController {

//    @Autowired
//    private DiscoveryClient discoveryClient;
	
	@Value("${server.port}")
    private int serverPort;

    
    @RequestMapping("/hello")
    public String home() {
        return "Hello world from "+serverPort;
    }

//    @RequestMapping("/service-instances/{applicationName}")
//    public List<ServiceInstance> serviceInstancesByApplicationName(
//            @PathVariable String applicationName) {
//    	discoveryClient.getInstances("a-client-app").forEach((ServiceInstance s) -> {
//            System.out.println(ToStringBuilder.reflectionToString(s));
//        });
//        return this.discoveryClient.getInstances(applicationName);
//    }
}
