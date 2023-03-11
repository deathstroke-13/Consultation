package com.consultation.consultation.dto.request;

import com.consultation.consultation.constant.GlobalConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class CommentRequestDTO implements Serializable {

    @Schema(description = "ID Comment isi 0 untuk penambahan", example = "0")
    public Long id;

    @Schema(description = "ID User", example = "1")
    public Long userId;

    @Schema(description = "ID Consultant", example = "2")
    public Long consultantId;

    @Schema(description = "Rating saat memberikan Comment (Max. 5)", example = "5")
    public Double rating;

    @Schema(description = "Komentar yang diberikan", example = "Consultant tanggap dan cepat dalam melayani keluhan")
    public String comment;

    @Schema(description = "Jenis Komentar (Dari USER ke CONSULTANT / Dari CONSULTANT ke USER)", example = "USERTOCONS")
    public String typeComment;
}
