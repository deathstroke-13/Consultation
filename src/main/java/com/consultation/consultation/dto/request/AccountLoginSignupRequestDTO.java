package com.consultation.consultation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class AccountLoginSignupRequestDTO implements Serializable {

    @Schema(example = "fhjdasdasdasdasdasdaf")
    public String firebaseKey;
}
