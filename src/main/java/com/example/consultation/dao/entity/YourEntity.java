package com.example.consultation.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "your_entity")
public class YourEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String contactNumber;
    private String interestOfUser;
    private String reasonForInterest;
    private String reasonForChoosingUs;
    private String typeOfConsultation;
    private Date consultationDate;
    private String customerRemark;
    private String email;



}

