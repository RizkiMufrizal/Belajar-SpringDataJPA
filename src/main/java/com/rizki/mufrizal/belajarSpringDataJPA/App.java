package com.rizki.mufrizal.belajarSpringDataJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by rizki on 06/09/15.
 */

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = {"com.rizki.mufrizal.belajarSpringDataJPA.domain"})
@EnableJpaRepositories(basePackages = {"com.rizki.mufrizal.belajarSpringDataJPA.repository"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
