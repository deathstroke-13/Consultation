package com.consultation.consultation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class ConsultantRequestDTO implements Serializable {
    @Schema(description = "Use 0 for Registration", example = "0")
    public Long id;

    @Schema(description = "Nama Consultant", example = "Agnes Priscillia")
    public String consultantName;

    @Schema(description = "Kode Consultant", example = "C-AP")
    public String consultantCode;

    @Schema(description = "URL untuk mengambil Photo Profile", example = "www.google.com")
    public String urlPhoto;

    @Schema(description = "Kebutuhan Firebase untuk chat", example = "sdhjkflhjk1234877fhdjsh")
    public String firebaseKey;

    @Schema(description = "Intro Consultant", example = "Specialis di Trauma Masa Lalu, Kecemasan dan Kepribadian")
    public String remarks;
}
