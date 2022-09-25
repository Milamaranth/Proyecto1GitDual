package com.example.demo;

import java.sql.Date;
import java.util.Calendar;
import java.util.Set;

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
	public CommandLineRunner run(OwnerRepository ownerRepository, PetRepository petRepository) {
		return args -> {
			Owner diego = new Owner();
			diego.setFirst_name("Diego");
			diego.setLast_name("Pedraza");
			diego.setAddress("Godofredo");
			diego.setCity("Badajoz");
			diego.setTelephone("6168336163");

			Pet pet = new Pet();
			pet.setType_id(2);
			pet.setName("Copito");

			// diego.setPets(Set.of(pet));

			diego = ownerRepository.save(diego);
			pet.setOwner(diego);
			petRepository.save(pet);

			System.out.println(ownerRepository.findAll().get(0));
		};
	}

	/**
	 * Crea una instancia de Pet de tipo 2 (dog) con el nombre, ownerId y birthDate que llegan por parámetro
	 * Guarda el Pet creado en el petRepository (usa petRepository.save(...))
	 */
	private void creatPerro(PetRepository petRepository, String nombre, int ownerId, Date birthDate) {
		// escribe tu código aquí
		Pet pet = new Pet();
		pet.setName(nombre);
		pet.setBirth_date(birthDate);
		pet.setType_id(2);
		petRepository.save(pet);

	}

}
//Salvador climatizacio ocaña edificio maracristina bloque 3 - 663 51 08 52