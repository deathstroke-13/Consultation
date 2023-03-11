package com.consultation.consultation.repository;

import com.consultation.consultation.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    List<Consultation> findAllByUserId_IdOrderByDateRequestDesc(Long id);
}
