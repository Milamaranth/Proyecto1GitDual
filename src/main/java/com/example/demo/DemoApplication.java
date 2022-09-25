package com.example.demo;

import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}






	@Bean
	public CommandLineRunner run(Company company, OwnerDao ownerDao) {
		return args -> {
			System.out.println(company.getAddress().getStreet() + " " + company.getAddress().getNumber());
			//Address address = new Address("Palomares", 2);
			//Company company = new Company(address);
			//System.out.println(company);
		};
	}


	
	/**
	 * 
	 */












	/**
	 * Crea una instancia de Pet de tipo 2 (dog) con el nombre, ownerId y birthDate que llegan por parámetro
	 * Guarda el Pet creado en el petRepository (usa petRepository.save(...))
	 */
	protected void creatPerro(PetRepository petRepository, String nombre, int ownerId, Date birthDate) {
		// escribe tu código aquí
		Pet pet = new Pet();
		pet.setName(nombre);
		pet.setBirth_date(birthDate);
		pet.setType_id(2);
		petRepository.save(pet);

	}

}
//Salvador climatizacio ocaña edificio maracristina bloque 3 - 663 51 08 52