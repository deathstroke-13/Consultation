package com.consultation.consultation.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommentResponseDTO implements Serializable {

    public Long id;

    public AccountCommentResponseDTO userId;

    public Long consultantId;

    public Double rating;

    public String comment;

    public String typeComment;
}
