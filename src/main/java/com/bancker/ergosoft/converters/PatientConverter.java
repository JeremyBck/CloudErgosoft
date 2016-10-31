package com.bancker.ergosoft.converters;

import com.bancker.ergosoft.model.v0.PatientModel;
import com.bancker.ergosoft.persistence.entity.Patient;

public interface PatientConverter {

    static Patient convertPatientModelToPatient(final PatientModel patientModel){
        return new Patient(
                null,
                patientModel.getSurname(),
                patientModel.getFirstName(),
                patientModel.getEmail(),
                patientModel.getJob(),
                patientModel.getBirthDate(),
                patientModel.getFollowUp(),
                patientModel.getAddress(),
                patientModel.getPostCode(),
                patientModel.getCity(),
                null,
                null,
                null,
                null);
    }
}
