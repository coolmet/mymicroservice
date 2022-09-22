package org.mymicroservice.nodediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class NodeDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(NodeDiscoveryApplication.class, args);
    }

}
