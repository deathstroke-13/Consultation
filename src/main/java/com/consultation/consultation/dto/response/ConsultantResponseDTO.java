package com.consultation.consultation.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ConsultantResponseDTO implements Serializable {

    public Long id;

    public String consultantName;

    public String consultantCode;

    public Double rating;

    public String urlPhoto;

    public String firebaseKey;

    public String remarks;

    public List<CommentResponseDTO> comments;
}
