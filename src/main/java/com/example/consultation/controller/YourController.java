package com.example.consultation.controller;

import com.example.consultation.model.YourDTO;
import com.example.consultation.service.EmailService;
import com.example.consultation.service.YourService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class YourController {

    private final YourService yourService;




    public YourController(YourService yourService, EmailService emailService, ModelMapper modelMapper) {
        this.yourService = yourService;

    }

    @PostMapping("/saveData")
    public ResponseEntity<String> postData(@RequestBody YourDTO yourDTO) {
        try {

            yourService.saveData(yourDTO);


            return ResponseEntity.ok("Veri başarıyla işlendi ve e-posta gönderildi");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Veri işleme hatası: " + e.getMessage());
        }
    }

    @GetMapping("/getAllData")
    public ResponseEntity<?> getAllData(){
       return ResponseEntity.ok(yourService.getAllData());
    }



}
