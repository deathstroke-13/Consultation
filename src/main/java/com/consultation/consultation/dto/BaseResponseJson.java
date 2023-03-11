package com.consultation.consultation.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponseJson implements Serializable {

    public String message;

    public Object data;
}
