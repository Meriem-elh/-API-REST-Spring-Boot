package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.example.demo.entities.Livre;
import com.example.demo.repos.LivreRepo;
import com.example.demo.entities.*;
@EnableAutoConfiguration

@EntityScan(basePackages = {"com.example.demo.entities"})
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private LivreRepo repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		
	}

}
