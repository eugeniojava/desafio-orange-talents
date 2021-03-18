package com.eugenioamn.vaccineapplicationcontrol.controller;

import com.eugenioamn.vaccineapplicationcontrol.dto.VaccineDto;
import com.eugenioamn.vaccineapplicationcontrol.form.VaccineForm;
import com.eugenioamn.vaccineapplicationcontrol.service.VaccineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/vaccines")
public class VaccineController {

    private final VaccineService vaccineService;

    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @PostMapping
    public ResponseEntity<VaccineDto> create(
            @Valid @RequestBody VaccineForm vaccineForm) {
        return vaccineService.create(vaccineForm);
    }
}
