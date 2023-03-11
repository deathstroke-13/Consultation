package com.consultation.consultation.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ConsultationResponseDTO implements Serializable {

    public Long id;

    public String consultCode;

    public String consultType;

    public String consultVia;

    public Date dateRequest;

    public Date dateAppoint;

    public Long userId;

    public Long consultantId;

    public Boolean isPaid;


}
