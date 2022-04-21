package com.github.bvigentas.jcontractor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class JContractorApplication {

    public static void main(String[] args) {
        SpringApplication.run(JContractorApplication.class, args);
    }

}
