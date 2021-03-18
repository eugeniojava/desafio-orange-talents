package com.eugenioamn.vaccineapplicationcontrol.service;

import com.eugenioamn.vaccineapplicationcontrol.dto.VaccineDto;
import com.eugenioamn.vaccineapplicationcontrol.form.VaccineForm;
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

    public ResponseEntity<VaccineDto> create(VaccineForm vaccineForm) {
        User user = userRepository.findByEmail(
                vaccineForm.getEmail()).orElse(null);

        if (user != null) {
            Vaccine vaccine = vaccineRepository.save(
                    vaccineForm.toEntity(user));
            VaccineDto vaccineDto = new VaccineDto(vaccine);

            return new ResponseEntity<>(vaccineDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
