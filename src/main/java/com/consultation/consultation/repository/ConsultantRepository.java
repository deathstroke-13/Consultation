package com.consultation.consultation.repository;

import com.consultation.consultation.entity.Consultant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant, Long> {

    Optional<Consultant> findByConsultantCode(String consultantCode);

    Optional<Consultant> findByConsultantCodeAndIdIsNot(String consultantCode, Long id);

    Page<Consultant> findAll(Pageable pageable);
}
