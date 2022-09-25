package com.example.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class OwnerDao {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Owner> findAll(){

        // SQL: SELECT * FROM owners;
        // JPQL: SELECT * FROM Owner;
        Query consulta = entityManager.createQuery("SELECT o FROM Owner o");
        return consulta.getResultList();
    }

    @Transactional
    public Owner guardar(Owner owner){
        entityManager.persist(owner);
        for (Pet pet : owner.getPets()) {
            pet.setOwner(owner);
            entityManager.persist(pet);
        }
        return owner;
    }

    public void delete(Pet pet){
        entityManager.remove(pet);
    }

    public Owner findByName(String firstName, String lastName){
        //String query = "SELECT o FROM Owner o WHERE o.first_name = '" + firstName + "' AND o.last_name = '" + lastName + "'";
        //Query consulta = entityManager.createQuery(query);
        Query consulta = entityManager.createQuery(
            "SELECT o FROM Owner o WHERE o.first_name = :firstName AND o.last_name = :lastName");
        consulta.setParameter("firstName", firstName);
        consulta.setParameter("lastName", lastName);

        List resultado = consulta.getResultList();
        if (resultado.isEmpty()) {
            System.out.println("No hay dueños");
            return null;
        } else {
            return (Owner) resultado.get(0);
        }
    }
}
