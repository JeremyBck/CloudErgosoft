package com.bancker.ergosoft.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Data
@Entity
@Transactional
@NoArgsConstructor
@AllArgsConstructor
public class Timeslot {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String type;

    //TODO: convert into sql date ?
    private long start;

    //TODO: convert into sql date ?
    private long end;

    private long price;

    private boolean paid;

    private Long payDate;

    @OneToOne
    private Patient patient;

    @OneToOne
    private User user;

}
