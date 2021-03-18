package com.eugenioamn.vaccineapplicationcontrol.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vaccine_table")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "vaccination_date")
    private LocalDate vaccinationDate;

    public Vaccine(String name, User user, LocalDate vaccinationDate) {
        this.name = name;
        this.user = user;
        this.vaccinationDate = vaccinationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }
}
