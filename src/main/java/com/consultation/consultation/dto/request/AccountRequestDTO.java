package com.consultation.consultation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Date;

@Data
public class AccountRequestDTO {

    @Schema(description = "Gunakan 0 untuk Registrasi", example = "0")
    public Long id;

    @Schema(description = "Nama User", example = "Mutiara")
    private String accountName;

    @Schema(description = "Email User", example = "mutiaraemail@gmail.com")
    public String email;

    @Schema(description = "No Handphone User", example = "0855555555")
    public String handphone;

    @Schema(description = "Isi dengan Gender (L/P)", example = "P")
    public String gender;

    @Schema(description = "Tanggal Lahir User", example = "1990-01-01")
    public Date tglLahir;

    @Schema(description = "ID Photo Sementara", example = "1")
    public Long urlPhotoId;

    @Schema(description = "Kegunaan untuk firebase", example = "fhjdskafhu3827346yfghdshjaf")
    public String firebaseKey;

    @Schema(description = "ID Domisili yang ada di DB", example = "1")
    public Long domisiliId;

}
