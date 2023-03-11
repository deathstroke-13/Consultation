package com.consultation.consultation.service.impl;

import com.consultation.consultation.dto.request.ConsultationRequestDTO;
import com.consultation.consultation.dto.response.ConsultationResponseDTO;
import com.consultation.consultation.entity.Consultation;
import com.consultation.consultation.exception.ResourceNotFoundException;
import com.consultation.consultation.mapper.ConsultationMapper;
import com.consultation.consultation.repository.AccountRepository;
import com.consultation.consultation.repository.ConsultantRepository;
import com.consultation.consultation.repository.ConsultationRepository;
import com.consultation.consultation.service.IConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConsultationService implements IConsultationService {

    @Autowired
    ConsultationMapper consultationMapper;
    @Autowired
    ConsultationRepository consultationRepo;
    @Autowired
    AccountRepository accountRepo;
    @Autowired
    ConsultantRepository consultantRepo;

    @Override
    public ConsultationResponseDTO saveConsultation(ConsultationRequestDTO request) {

        Consultation consultation = consultationMapper.mapDTOtoEntity(request);
        consultation.setId(0L);
        consultation.setUserId(accountRepo.findById(request.getUserId()).orElseThrow(() -> new ResourceNotFoundException("ID User tidak ditemukan")));
        consultation.setConsultantId(consultantRepo.findById(request.getConsultantId()).orElseThrow(() -> new ResourceNotFoundException("ID Consultant tidak ditemukan")));

        String codeConsult = "C-"+consultation.getUserId().getId().toString()+"-"+consultation.getConsultantId().getId().toString()+"-"+ LocalDateTime.now();
        consultation.setConsultCode(codeConsult);


        return consultationMapper.mapEntitytoDTO(consultationRepo.save(consultation));
    }
}
