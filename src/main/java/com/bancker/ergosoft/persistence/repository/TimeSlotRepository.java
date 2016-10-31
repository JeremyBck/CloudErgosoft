package com.bancker.ergosoft.persistence.repository;

import com.bancker.ergosoft.persistence.entity.Timeslot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TimeSlotRepository extends CrudRepository<Timeslot, Long> {

    Timeslot findById(Long id);
}