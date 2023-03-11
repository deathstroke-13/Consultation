package com.consultation.consultation.repository;

import com.consultation.consultation.entity.Domisili;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomisiliRepository extends JpaRepository<Domisili, Long> {

}
