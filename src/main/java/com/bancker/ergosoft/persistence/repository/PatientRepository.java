package com.bancker.ergosoft.persistence.repository;

import com.bancker.ergosoft.persistence.entity.Patient;
import com.bancker.ergosoft.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PatientRepository extends CrudRepository<Patient, Long> {

    Patient findByEmail(String email);
}
