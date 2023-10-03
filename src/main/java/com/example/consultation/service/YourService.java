package com.example.consultation.service;

import com.example.consultation.dao.entity.YourEntity;
import com.example.consultation.dao.repository.YourRepository;
import com.example.consultation.model.YourDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YourService {

    private final YourRepository yourRepository;

    private final ModelMapper modelMapper;

    private final EmailService emailService;


    public YourService(YourRepository yourRepository, ModelMapper modelMapper, EmailService emailService) {
        this.yourRepository = yourRepository;
        this.modelMapper = modelMapper;
        this.emailService = emailService;
    }

    public void saveData(YourDTO yourDTO) {
        YourEntity yourEntity = modelMapper.map(yourDTO, YourEntity.class);
        emailService.sendMail(yourEntity.getEmail(), yourEntity.getName(), yourEntity.getSurname());

       yourRepository.save(yourEntity);
    }

    public List<YourDTO> getAllData(){
        List<YourEntity> yourEntityList = yourRepository.findAll();
        List<YourDTO> yourDTOList = yourEntityList.stream().map(yourEntity -> modelMapper.map(yourEntity, YourDTO.class)).toList();
        return yourDTOList;
    }

}
