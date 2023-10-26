package com.example.demo.models;

import com.example.demo.enums.Roles;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "experiences")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long id;
    private String company;
    private LocalDate from_date;
    private Roles role;
    private LocalDate to_date;
    private String work_desc;

    @ManyToOne
    @JoinColumn(name = "can_id",nullable = false)
    private Candidate candidate;

    public Experience() {

    }

    public Experience(String company, LocalDate from_date, Roles role, LocalDate to_date, String work_desc, Candidate candidate) {
        this.company = company;
        this.from_date = from_date;
        this.role = role;
        this.to_date = to_date;
        this.work_desc = work_desc;
        this.candidate = candidate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDate getFrom_date() {
        return from_date;
    }

    public void setFrom_date(LocalDate from_date) {
        this.from_date = from_date;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public LocalDate getTo_date() {
        return to_date;
    }

    public void setTo_date(LocalDate to_date) {
        this.to_date = to_date;
    }

    public String getWork_desc() {
        return work_desc;
    }

    public void setWork_desc(String work_desc) {
        this.work_desc = work_desc;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", from_date=" + from_date +
                ", role=" + role +
                ", to_date=" + to_date +
                ", work_desc='" + work_desc + '\'' +
                ", candidate=" + candidate +
                '}';
    }
}
