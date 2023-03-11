package com.consultation.consultation.controller;

import com.consultation.consultation.dto.BaseResponseJson;
import com.consultation.consultation.dto.request.ConsultationRequestDTO;
import com.consultation.consultation.service.IConsultationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.consultation.consultation.constant.GlobalConstant.SUKSES_SIMPAN;

@RestController(value = "Consultation Controller")
@RequestMapping("/consultation/")
public class ConsultationController {

    @Autowired
    IConsultationService consultationService;

    @PostMapping("/add-consult")
    @Operation(tags = "Consultation")
    public ResponseEntity<BaseResponseJson> addComment(@RequestBody ConsultationRequestDTO request) {
        BaseResponseJson base = new BaseResponseJson();
        base.setMessage(SUKSES_SIMPAN);
        base.setData(consultationService.saveConsultation(request));
        return ResponseEntity.ok().body(base);
    }
}
