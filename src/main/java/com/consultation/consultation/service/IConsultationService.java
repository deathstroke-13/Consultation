package com.consultation.consultation.service;

import com.consultation.consultation.dto.request.ConsultationRequestDTO;
import com.consultation.consultation.dto.response.ConsultationResponseDTO;

public interface IConsultationService {

    ConsultationResponseDTO saveConsultation(ConsultationRequestDTO request);
}
