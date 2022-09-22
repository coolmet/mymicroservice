package org.mymicroservice.msaccounting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsAccountingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsAccountingApplication.class, args);
    }

}
