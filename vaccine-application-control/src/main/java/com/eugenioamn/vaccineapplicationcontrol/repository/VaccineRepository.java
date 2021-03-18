package com.eugenioamn.vaccineapplicationcontrol.repository;

import com.eugenioamn.vaccineapplicationcontrol.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
}
