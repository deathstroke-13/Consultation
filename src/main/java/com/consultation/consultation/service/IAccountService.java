package com.consultation.consultation.service;

import com.consultation.consultation.dto.request.AccountLoginEmailRequestDTO;
import com.consultation.consultation.dto.request.AccountRequestDTO;
import com.consultation.consultation.dto.response.AccountResponseDTO;
import com.consultation.consultation.dto.response.ConsultationResponseDTO;
import com.consultation.consultation.entity.Account;

import java.util.List;


public interface IAccountService {

    Account getAccount(Long id);

    AccountResponseDTO saveAccount(AccountRequestDTO dto);

    AccountResponseDTO updateAccount(AccountRequestDTO request);

    List<ConsultationResponseDTO> historyConsult(Long id);

    AccountResponseDTO loginAccount(String key);

    String loginAccountByEmail(AccountLoginEmailRequestDTO request);
}
