package com.example.consultation.dao.repository;

import com.example.consultation.dao.entity.YourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YourRepository extends JpaRepository<YourEntity, Long> {
    // Özel sorguları eklemek için gerektiğinde metodlar ekleyebilirsiniz
}

