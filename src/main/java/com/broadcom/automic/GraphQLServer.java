package com.broadcom.automic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphQLServer implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(GraphQLServer.class);

    public static void main(String[] args) {
        SpringApplication.run(GraphQLServer.class, args);
    }

    @Override
    public void run(String... args) {

    }
}