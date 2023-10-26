package com.example.demo.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long id;
    private String email;
    private String full_name;
    private String phone;

    @OneToMany (mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Experience> experiences;

    public Candidate() {
    }
    public Candidate(Long id, String fullName, String email, String phone) {
        this.id = id;
        this.full_name = fullName;
        this.email = email;
        this.phone = phone;
    }
    public Candidate(String email, String full_name, String phone, List<Experience> experiences) {
        this.email = email;
        this.full_name = full_name;
        this.phone = phone;
        this.experiences = experiences;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", full_name='" + full_name + '\'' +
                ", phone='" + phone + '\'' +
                ", experiences=" + experiences +
                '}';
    }
}
