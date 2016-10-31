package com.bancker.ergosoft.persistence.service;

import com.bancker.ergosoft.converters.PatientConverter;
import com.bancker.ergosoft.model.v0.PatientModel;
import com.bancker.ergosoft.persistence.entity.Patient;
import com.bancker.ergosoft.persistence.entity.User;
import com.bancker.ergosoft.persistence.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> findByUser(final User user){
        final Iterable<Patient> completePatientList = patientRepository.findAll();
        List<Patient> patientList=new ArrayList<>();
        for(Patient patient: completePatientList) {
            if (patient.getUserList().contains(user)){
                patientList.add(patient);
            }
        }
        return patientList;
    }

    public Patient findByEmail(String email){
        return patientRepository.findByEmail(email);
    }

    public Patient addPatient(final PatientModel patientModel, final User user){
        Patient patient= PatientConverter.convertPatientModelToPatient(patientModel);
        List<User> userList=new ArrayList<>();
        userList.add(user);
        patient.setUserList(userList);
        return patientRepository.save(patient);
    }

    public void removePatient(final String email) throws Exception {
        Patient patientToDelete=findByEmail(email);
        if(patientToDelete!=null){
            patientRepository.delete(patientToDelete);
        }
        else{
            throw new Exception("No patient found for this email !");
        }
    }

    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }
}
