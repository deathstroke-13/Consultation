package com.consultation.consultation.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ConsultationRequestDTO implements Serializable {

    public String consultType;

    public Long userId;

    public Long consultantId;

    public Date dateAppoint;

    public String consultVia;

    public Boolean isPaid;

}
