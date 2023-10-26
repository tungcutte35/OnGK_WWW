package com.example.demo;

import com.example.demo.enums.Roles;
import com.example.demo.models.Candidate;
import com.example.demo.models.Experience;
import com.example.demo.responsitories.CandidateRepository;
import com.example.demo.responsitories.ExperienceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static CandidateRepository candidateRepository;
    private static ExperienceRepository experienceResponsitory;
    public static void main(String[] args) {

        candidateRepository = new CandidateRepository();
        experienceResponsitory = new ExperienceRepository();

        for (int i = 0; i < 3; i++) {
            Candidate candidate = new Candidate("email" + i, "full_name" + i, "0" + i + i + i + i, new ArrayList<>());

            int random = new Random().nextInt(Roles.values().length);
            for (int j = i; j < i + 3; j++) {
                Experience experience = new Experience( "company" + j, LocalDate.now(), Roles.values()[random], LocalDate.now(), "work_desc" + j, candidate);
                candidate.getExperiences().add(experience);
                experienceResponsitory.save(experience);

            }

            candidateRepository.save(candidate);
        }
    }


}