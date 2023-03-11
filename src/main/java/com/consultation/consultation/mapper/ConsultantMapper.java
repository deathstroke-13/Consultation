package com.consultation.consultation.mapper;

import com.consultation.consultation.dto.request.ConsultantRequestDTO;
import com.consultation.consultation.dto.response.ConsultantResponseDTO;
import com.consultation.consultation.entity.Consultant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConsultantMapper {

    Consultant mapDTOtoEntity(ConsultantRequestDTO dto);

    @Mapping(target = "rating", ignore = true)
    ConsultantResponseDTO mapEntityToDTO(Consultant entity);

    @Mapping(target = "rating", ignore = true)
    List<ConsultantResponseDTO> mapListEntityToDTO(List<Consultant> entities);

}
