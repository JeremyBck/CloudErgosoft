package com.bancker.ergosoft.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String email;

    private String job;

    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false)
    private String followUp;

    /*Address information*/
    private String address;

    private int postCode;

    private String city;

    @OneToMany
    private List<Therapist> therapistList;

    @OneToMany
    private List<User> userList;

    @OneToMany
    private List<Document> documentList;

    @OneToMany
    private List<Timeslot> timeslotList;

}