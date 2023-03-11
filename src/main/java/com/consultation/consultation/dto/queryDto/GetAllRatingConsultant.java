package com.consultation.consultation.dto.queryDto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetAllRatingConsultant implements Serializable {

    public Long consultantId;

    public Double ratings;

    public GetAllRatingConsultant(Long consultantId, Double ratings) {
        this.consultantId = consultantId;
        this.ratings = ratings;
    }
}
