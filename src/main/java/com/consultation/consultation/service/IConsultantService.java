package com.consultation.consultation.service;

import com.consultation.consultation.dto.request.ConsultantRequestDTO;
import com.consultation.consultation.dto.request.PagingBaseRequestDTO;
import com.consultation.consultation.dto.response.ConsultantResponseDTO;
import com.consultation.consultation.entity.Consultant;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IConsultantService {

    ConsultantResponseDTO viewConsultant(Long id);

    ConsultantResponseDTO saveConsultant(ConsultantRequestDTO request);

    ConsultantResponseDTO updateConsultant(ConsultantRequestDTO request);

    List<ConsultantResponseDTO> viewAllConsultant();

    Page<Consultant> viewPaging(PagingBaseRequestDTO request);
}

