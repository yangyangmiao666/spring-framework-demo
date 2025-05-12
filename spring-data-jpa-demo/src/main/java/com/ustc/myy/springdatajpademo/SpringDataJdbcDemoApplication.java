package com.ustc.myy.springdatajpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringDataJdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcDemoApplication.class, args);
    }

}
