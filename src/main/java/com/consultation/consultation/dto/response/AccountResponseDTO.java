package com.consultation.consultation.dto.response;

import jakarta.persistence.Entity;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class AccountResponseDTO implements Serializable {

    public Long id;

    public String accountName;

    public String email;

    public String handphone;

    public String gender;

    public Date tglLahir;

    public Long urlPhotoId;

    public String firebaseKey;
}
