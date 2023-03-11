package com.consultation.consultation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PagingBaseRequestDTO implements Serializable {


    @Schema(description = "Page ke berapa (Start dari 0)", example = "0")
    public Integer pageNo;

    @Schema(description = "Berapa banyak data dalam satu page", example = "10")
    public Integer pageSize;

    @Schema(description = "Sorting ASC atau DESC(ASC/DESC)", example = "DESC")
    public String sort;

    @Schema(description = "Sorting berdasarkan nama column tersebut", example = "")
    public List<String> columnName;

}
