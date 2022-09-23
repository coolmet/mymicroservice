package org.mymicroservice.agaccounting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AgAccountingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgAccountingApplication.class, args);
    }

}
