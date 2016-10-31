package com.bancker.ergosoft.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Therapist {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String firstName;

    private String email;

    @Column(nullable = false)
    private String job;

    @Column(nullable = false)
    private String city;

    @OneToMany
    private List<Patient> patientList;

}
