package com.consultation.consultation.mapper;

import com.consultation.consultation.dto.request.AccountRequestDTO;
import com.consultation.consultation.dto.response.AccountResponseDTO;
import com.consultation.consultation.dto.response.DomisiliResponseDTO;
import com.consultation.consultation.entity.Account;
import com.consultation.consultation.entity.Domisili;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "domisiliId", ignore = true)
    @Mapping(target = "id", ignore = true)
    Account mapDTOtoEntity(AccountRequestDTO dto);

    @Mapping(target = "domisiliId", ignore = true)
    Account updateDTOtoEntity(AccountRequestDTO dto);

    AccountResponseDTO mapEntitytoDTO(Account entity);

    //Domisili Mapper put Here
    DomisiliResponseDTO mapDomisiliEntityToDTO(Domisili entity);

    List<DomisiliResponseDTO> mapDomisiliEntityToDTO(List<Domisili> entity);
}
