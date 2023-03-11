package com.consultation.consultation.controller;

import com.consultation.consultation.dto.BaseResponseJson;
import com.consultation.consultation.dto.request.*;
import com.consultation.consultation.entity.Consultant;
import com.consultation.consultation.service.IAccountService;
import com.consultation.consultation.service.IConsultantService;
import com.consultation.consultation.service.IConsultationService;
import com.consultation.consultation.service.IDomisiliService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.consultation.consultation.constant.GlobalConstant.*;

@RestController(value = "Account Controller")
@RequestMapping("/account/")
public class AccountController {

    @Autowired
    IAccountService accountService;

    @Autowired
    IConsultantService consultantService;

    @Autowired
    IDomisiliService domisiliService;


    @GetMapping(value = "/user/view/$id", name = "Account User")
    @Operation(tags = "User")
    public ResponseEntity<BaseResponseJson> getAccountById(@RequestParam Long id) {
        BaseResponseJson base = new BaseResponseJson();
        base.setMessage(SUKSES_TAMPIL);
        base.setData(accountService.getAccount(id));
        return ResponseEntity.ok().body(base);
    }

    @GetMapping(value = "/user/consult-history/$id")
    @Operation(tags = "User")
    public ResponseEntity<BaseResponseJson> viewAccountHistory(@RequestParam Long id) {
        BaseResponseJson base = new BaseResponseJson();
        base.setMessage(SUKSES_TAMPIL);
        base.setData(accountService.historyConsult(id));
        return ResponseEntity.ok().body(base);
    }

    @PostMapping("/user/registration")
    @Operation(tags = "User")
    public ResponseEntity<BaseResponseJson> saveAccount(@RequestBody AccountRequestDTO request) {
        BaseResponseJson base = new BaseResponseJson();
        base.setMessage(SUKSES_SIMPAN);
        base.setData(accountService.saveAccount(request));
        return ResponseEntity.ok().body(base);
    }

    @PostMapping("/user/edituser")
    @Operation(tags = "User")
    public ResponseEntity<BaseResponseJson> editAccount(@RequestBody AccountRequestDTO request) {
        BaseResponseJson base = new BaseResponseJson();
        base.setMessage(SUKSES_EDIT);
        base.setData(accountService.updateAccount(request));
        return ResponseEntity.ok().body(base);
    }

    @PostMapping("/user/loginorsignup")
    @Operation(tags = "User")
    public ResponseEntity<BaseResponseJson> loginAccount(@RequestBody AccountLoginSignupRequestDTO request) {
        BaseResponseJson base = new BaseResponseJson();
        base.setMessage(SUKSES_TAMPIL);
        base.setData(accountService.loginAccount(request.getFirebaseKey()));
        return ResponseEntity.ok().body(base);
    }

    @PostMapping("/user/email-login")
    @Operation(tags = "User")
    public ResponseEntity<BaseResponseJson> loginAccountByEmail(@RequestBody AccountLoginEmailRequestDTO request) {
        BaseResponseJson base = new BaseResponseJson();
        base.setMessage(SUKSES_TAMPIL);
        base.setData(accountService.loginAccountByEmail(request));
        return ResponseEntity.ok().body(base);
    }

    @GetMapping(value = "/consultant/view/$id", name = "Account Consultant")
    @Operation(tags = "Consultant")
    public ResponseEntity<BaseResponseJson> getConsultantById(@RequestParam Long id) {
        BaseResponseJson base = new BaseResponseJson();
        base.setMessage(SUKSES_TAMPIL);
        base.setData(consultantService.viewConsultant(id));
        return ResponseEntity.ok().body(base);
    }

    @PostMapping("/consultant/registration")
    @Operation(tags = "Consultant")
    public ResponseEntity<BaseResponseJson> saveConsultant(@RequestBody ConsultantRequestDTO request) {
        BaseResponseJson base = new BaseResponseJson();
        base.setMessage(SUKSES_SIMPAN);
        base.setData(consultantService.saveConsultant(request));
        return ResponseEntity.ok().body(base);
    }

    @PostMapping("/consultant/edit")
    @Operation(tags = "Consultant")
    public ResponseEntity<BaseResponseJson> editConsultant(@RequestBody ConsultantRequestDTO request) {
        BaseResponseJson base = new BaseResponseJson();
        base.setMessage(SUKSES_EDIT);
        base.setData(consultantService.updateConsultant(request));
        return ResponseEntity.ok().body(base);
    }

    @GetMapping("/consultant/view-list-all")
    @Operation(tags = "Consultant")
    public ResponseEntity<BaseResponseJson> viewListAllConsultant(){
        BaseResponseJson base = new BaseResponseJson();
        base.setMessage(SUKSES_TAMPIL);
        base.setData(consultantService.viewAllConsultant());
        return ResponseEntity.ok().body(base);
    }

    @GetMapping("/domisili/view-all")
    @Operation(tags = "Domisili")
    public ResponseEntity<BaseResponseJson> viewAllDomicile(){
        BaseResponseJson base = new BaseResponseJson();
        base.setMessage(SUKSES_TAMPIL);
        base.setData(domisiliService.viewAllDomicile());
        return ResponseEntity.ok().body(base);
    }

    @PostMapping("/consultant/view-list")
    @Operation(tags = "Consultant")
    public ResponseEntity<BaseResponseJson> viewPagingConsultant(@RequestBody PagingBaseRequestDTO request){
        BaseResponseJson base = new BaseResponseJson();
        base.setMessage(SUKSES_TAMPIL);
        base.setData(consultantService.viewPaging(request));
        return ResponseEntity.ok().body(base);
    }

}