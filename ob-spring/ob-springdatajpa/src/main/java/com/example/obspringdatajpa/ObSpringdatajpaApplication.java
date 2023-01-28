package com.example.obspringdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class ObSpringdatajpaApplication {

	public static void main(String[] args) {

	ApplicationContext context	= SpringApplication.run(ObSpringdatajpaApplication.class, args);

	CocheRepository repository = context.getBean(CocheRepository.class);

		System.out.println("find");
		System.out.println("el num de coches es: "+repository.count());

		//Crear y almacenar un coche en base de datos

		Coche bwm = new Coche(null, "BMW","Primer",2015);
		repository.save(bwm);

		//recuperar un coche por id
		System.out.println(repository.findAll());
	}


}
