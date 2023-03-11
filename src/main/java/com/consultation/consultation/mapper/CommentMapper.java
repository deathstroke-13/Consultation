package com.consultation.consultation.mapper;

import com.consultation.consultation.dto.request.CommentRequestDTO;
import com.consultation.consultation.dto.response.AccountCommentResponseDTO;
import com.consultation.consultation.dto.response.CommentResponseDTO;
import com.consultation.consultation.entity.Account;
import com.consultation.consultation.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "consultantId", ignore = true)
    @Mapping(target = "userId", ignore = true)
    Comment mapDTOtoEntity(CommentRequestDTO dto);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "consultantId", source = "consultantId.id")
    CommentResponseDTO mapCommentEntityToDTO(Comment entity);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "consultantId", source = "consultantId.id")
    List<CommentResponseDTO> mapListCommentEntitiesToDTO(List<Comment> entities);

    AccountCommentResponseDTO mapCommentAccounttoDTO(Account account);
}
