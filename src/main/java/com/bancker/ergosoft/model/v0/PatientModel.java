package com.bancker.ergosoft.model.v0;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientModel {

    private String surname;

    private String firstName;

    private String email;

    private String job;

    private Date birthDate;

    private String followUp;

    private String address;

    private int postCode;

    private String city;

}
