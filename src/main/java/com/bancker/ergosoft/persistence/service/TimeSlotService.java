package com.bancker.ergosoft.persistence.service;

import com.bancker.ergosoft.persistence.entity.Timeslot;
import com.bancker.ergosoft.persistence.entity.User;
import com.bancker.ergosoft.persistence.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeSlotService {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    /*public List<Timeslot> findByStartDateAndEndDate(User user, long startDate, long endDate){
        Iterable<Timeslot> timeSlotList=timeSlotRepository.findAll();

        List<Timeslot> userTimeslotList =new ArrayList<>();

        timeSlotList.forEach(timeSlot -> {
            if(timeSlot.getUser().equals(user)){
                userTimeslotList.add(timeSlot);
            }
        });

        List<Timeslot> resultTimeslotList = userTimeslotList
                .stream()
                .filter(timeSlot -> timeSlot.getStart()>=startDate&&timeSlot.getEnd()<=endDate)
                .collect(Collectors.toList());

        return resultTimeslotList;
    }*/

    public Timeslot addTimeSlot(Timeslot timeslotToCreate){
        return timeSlotRepository.save(timeslotToCreate);
    }

    public void removeTimeSlot(Timeslot timeslotToDelete){
        timeSlotRepository.delete(timeslotToDelete);
    }

}
