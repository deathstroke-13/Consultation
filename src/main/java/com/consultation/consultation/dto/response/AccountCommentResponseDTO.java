package com.consultation.consultation.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountCommentResponseDTO implements Serializable {

    public Long id;

    public String accountName;

    public Long urlPhotoId;
}
