package com.eugenioamn.vaccineapplicationcontrol.dto;

import com.eugenioamn.vaccineapplicationcontrol.model.Vaccine;

import java.time.LocalDate;

public class VaccineDto {

    private final Long id;
    private final String name;
    private final String email;
    private final LocalDate vaccinationDate;

    public VaccineDto(Vaccine vaccine) {
        id = vaccine.getId();
        name = vaccine.getName();
        email = vaccine.getUser().getEmail();
        vaccinationDate = vaccine.getVaccinationDate();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }
}
