package com.consultation.consultation.service.impl;

import com.consultation.consultation.dto.response.DomisiliResponseDTO;
import com.consultation.consultation.mapper.AccountMapper;
import com.consultation.consultation.repository.DomisiliRepository;
import com.consultation.consultation.service.IDomisiliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomisiliService implements IDomisiliService {


    @Autowired
    DomisiliRepository domisiliRepo;

    @Autowired
    AccountMapper mapper;

    @Override
    public List<DomisiliResponseDTO> viewAllDomicile() {
        return mapper.mapDomisiliEntityToDTO(domisiliRepo.findAll());
    }
}
