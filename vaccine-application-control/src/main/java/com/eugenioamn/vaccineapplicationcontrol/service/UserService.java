package com.eugenioamn.vaccineapplicationcontrol.service;

import com.eugenioamn.vaccineapplicationcontrol.controller.validation.ValidationError;
import com.eugenioamn.vaccineapplicationcontrol.model.User;
import com.eugenioamn.vaccineapplicationcontrol.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> create(User user) {
        boolean emailAlreadyExists =
                userRepository.findByEmail(user.getEmail()).isPresent();
        boolean cpfAlreadyExists =
                userRepository.findByCpf(user.getCpf()).isPresent();

        if (emailAlreadyExists && cpfAlreadyExists) {
            List<ValidationError> validationErrors = new ArrayList<>();

            validationErrors.add(new ValidationError(
                    "email", "email already registered"));
            validationErrors.add(new ValidationError(
                    "cpf", "cpf already registered"));

            return new ResponseEntity<>(
                    validationErrors, HttpStatus.BAD_REQUEST);
        } else if (emailAlreadyExists) {
            ValidationError validationError = new ValidationError(
                    "email", "email already registered");

            return new ResponseEntity<>(
                    validationError, HttpStatus.BAD_REQUEST);
        } else if (cpfAlreadyExists) {
            ValidationError validationError = new ValidationError(
                    "cpf", "cpf already registered");

            return new ResponseEntity<>(
                    validationError, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(userRepository.save(user),
                    HttpStatus.CREATED);
        }
    }
}
