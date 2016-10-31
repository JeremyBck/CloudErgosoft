package com.bancker.ergosoft.persistence.repository;


import com.bancker.ergosoft.persistence.entity.Therapist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TherapistRepository extends CrudRepository<Therapist, Long> {

}