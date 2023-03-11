package com.consultation.consultation.service.impl;

import com.consultation.consultation.dto.request.CommentRequestDTO;
import com.consultation.consultation.dto.response.CommentResponseDTO;
import com.consultation.consultation.entity.Account;
import com.consultation.consultation.entity.Comment;
import com.consultation.consultation.entity.Consultant;
import com.consultation.consultation.exception.ResourceNotFoundException;
import com.consultation.consultation.mapper.CommentMapper;
import com.consultation.consultation.repository.AccountRepository;
import com.consultation.consultation.repository.CommentRepository;
import com.consultation.consultation.repository.ConsultantRepository;
import com.consultation.consultation.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private AccountRepository accountRepo;

    @Autowired
    private ConsultantRepository consultantRepo;

    @Override
    public CommentResponseDTO saveComment(CommentRequestDTO dto) {

        Account userId = accountRepo.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User ID tidak ditemukan"));

        Consultant consultantId = consultantRepo.findById(dto.getConsultantId())
                .orElseThrow(() -> new ResourceNotFoundException("Consultant ID tidak ditemukan"));

        Comment comment = commentMapper.mapDTOtoEntity(dto);
        comment.setUserId(userId);
        comment.setConsultantId(consultantId);

        Comment commentAccepted = commentRepo.save(comment);

        return commentMapper.mapCommentEntityToDTO(commentAccepted);
    }
}
