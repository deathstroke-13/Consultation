package com.consultation.consultation.mapper;

import com.consultation.consultation.dto.request.ConsultationRequestDTO;
import com.consultation.consultation.dto.response.ConsultationResponseDTO;
import com.consultation.consultation.entity.Consultation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConsultationMapper {

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "consultantId", ignore = true)
    Consultation mapDTOtoEntity(ConsultationRequestDTO dto);

    @Mapping(target = "userId", source = "userId.id")
    @Mapping(target = "consultantId", source = "consultantId.id")
    ConsultationResponseDTO mapEntitytoDTO(Consultation entity);

    @Mapping(target = "userId", source = "userId.id")
    @Mapping(target = "consultantId", source = "consultantId.id")
    List<ConsultationResponseDTO> mapEntitiestoDTO(List<Consultation> entity);
}
