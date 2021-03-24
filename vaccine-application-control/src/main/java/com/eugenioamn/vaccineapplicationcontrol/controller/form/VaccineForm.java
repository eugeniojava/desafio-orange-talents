package com.eugenioamn.vaccineapplicationcontrol.controller.form;

import com.eugenioamn.vaccineapplicationcontrol.model.User;
import com.eugenioamn.vaccineapplicationcontrol.model.Vaccine;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class VaccineForm {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private LocalDate vaccinationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public Vaccine toEntity(User user) {
        return new Vaccine(name, user, vaccinationDate);
    }
}
