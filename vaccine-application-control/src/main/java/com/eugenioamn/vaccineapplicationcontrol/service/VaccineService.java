package com.eugenioamn.vaccineapplicationcontrol.service;

import com.eugenioamn.vaccineapplicationcontrol.controller.dto.VaccineDto;
import com.eugenioamn.vaccineapplicationcontrol.controller.form.VaccineForm;
import com.eugenioamn.vaccineapplicationcontrol.controller.validation.ValidationError;
import com.eugenioamn.vaccineapplicationcontrol.model.User;
import com.eugenioamn.vaccineapplicationcontrol.model.Vaccine;
import com.eugenioamn.vaccineapplicationcontrol.repository.UserRepository;
import com.eugenioamn.vaccineapplicationcontrol.repository.VaccineRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VaccineService {

    private final VaccineRepository vaccineRepository;
    private final UserRepository userRepository;

    public VaccineService(VaccineRepository vaccineRepository,
                          UserRepository userRepository) {
        this.vaccineRepository = vaccineRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> create(VaccineForm vaccineForm) {
        User user = userRepository.findByEmail(
                vaccineForm.getEmail()).orElse(null);

        if (user != null) {
            Vaccine vaccine = vaccineRepository.save(
                    vaccineForm.toEntity(user));
            VaccineDto vaccineDto = new VaccineDto(vaccine);

            return new ResponseEntity<>(vaccineDto, HttpStatus.CREATED);
        }
        ValidationError validationError = new ValidationError(
                "email", "email not registered");

        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
    }
}
