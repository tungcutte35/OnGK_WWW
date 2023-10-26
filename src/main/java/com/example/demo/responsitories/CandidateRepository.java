package com.example.demo.responsitories;

import com.example.demo.enums.Roles;
import com.example.demo.models.Candidate;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class CandidateRepository {
    private final EntityManager entityManager;
    private final EntityTransaction transaction;
    public CandidateRepository(){
        entityManager = Persistence.createEntityManagerFactory("demo").createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void save(Candidate candidate){
        try{
            transaction.begin();
            entityManager.persist(candidate);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }

    public List<Candidate> findAll() {
        TypedQuery<Candidate> query = entityManager.createQuery("select c from Candidate c", Candidate.class);
        return query.getResultList();
    }

    public Candidate findById(Long candidateId) {
        TypedQuery<Candidate> query = entityManager.createQuery("from Candidate c where c.id = :id", Candidate.class);
        query.setParameter("id", candidateId);
        return query.getSingleResult();
    }

    public List<Candidate> findByRole(int selectedRole) {
        Query query = entityManager.createQuery(
                "select distinct c.id, c.full_name, c.email, c.phone from Candidate c join Experience e on c.id = e.candidate.id " +
                        "where e.role = :selectedRole");
        query.setParameter("selectedRole", Roles.values()[selectedRole]);

        List<Object[]> results = query.getResultList();
        List<Candidate> candidates = new ArrayList<>();
        for(Object[] curCandidate: results){
            String gmail = "";
            if(curCandidate[2] != null){
                gmail = curCandidate[2].toString();
            }
            Candidate candidate = new Candidate((Long) curCandidate[0],curCandidate[1].toString(), gmail, curCandidate[3].toString());
            candidates.add(candidate);
        }
        return candidates;
    }
}
