package com.consultation.consultation.service;

import com.consultation.consultation.dto.request.CommentRequestDTO;
import com.consultation.consultation.dto.response.CommentResponseDTO;

public interface ICommentService {

    CommentResponseDTO saveComment(CommentRequestDTO dto);
}
