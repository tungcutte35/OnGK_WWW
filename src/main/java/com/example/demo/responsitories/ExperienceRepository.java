package com.example.demo.responsitories;

import com.example.demo.models.Experience;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ExperienceRepository {
    private final EntityManager entityManager;
    private EntityTransaction transaction;
    public ExperienceRepository(){
        this.entityManager = Persistence.createEntityManagerFactory("demo").createEntityManager();
        this.transaction= entityManager.getTransaction();
    }

    public void save(Experience experience){
        try {
            transaction.begin();
            entityManager.persist(experience);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
}

