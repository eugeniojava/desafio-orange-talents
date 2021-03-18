package com.eugenioamn.vaccineapplicationcontrol.service;

import com.eugenioamn.vaccineapplicationcontrol.model.User;
import com.eugenioamn.vaccineapplicationcontrol.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> create(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent() ||
                userRepository.findByCpf(user.getCpf()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userRepository.save(user),
                HttpStatus.CREATED);
    }
}
