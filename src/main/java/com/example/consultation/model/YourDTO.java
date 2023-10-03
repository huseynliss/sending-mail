package com.example.consultation.model;

import lombok.Data;

import java.util.Date;

@Data
public class YourDTO {

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
