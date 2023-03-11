package com.consultation.consultation.service.impl;

import com.consultation.consultation.dto.request.AccountLoginEmailRequestDTO;
import com.consultation.consultation.dto.request.AccountRequestDTO;
import com.consultation.consultation.dto.response.AccountResponseDTO;
import com.consultation.consultation.dto.response.ConsultationResponseDTO;
import com.consultation.consultation.entity.Account;
import com.consultation.consultation.entity.Consultation;
import com.consultation.consultation.entity.Domisili;
import com.consultation.consultation.exception.ResourceNotAcceptableException;
import com.consultation.consultation.exception.ResourceNotFoundException;
import com.consultation.consultation.mapper.AccountMapper;
import com.consultation.consultation.mapper.ConsultationMapper;
import com.consultation.consultation.repository.AccountRepository;
import com.consultation.consultation.repository.ConsultationRepository;
import com.consultation.consultation.repository.DomisiliRepository;
import com.consultation.consultation.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountService implements IAccountService {

    @Autowired
    public AccountRepository accountRepo;

    @Autowired
    public AccountMapper accountMapper;

    @Autowired
    public DomisiliRepository domisiliRepo;

    @Autowired
    public ConsultationRepository consultationRepo;

    @Autowired
    public ConsultationMapper consultationMapper;

    @Override
    public Account getAccount(Long id) {
        return accountRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID Not Found"));
    }

    @Override
    public AccountResponseDTO saveAccount(AccountRequestDTO dto) {
        Account account = accountMapper.mapDTOtoEntity(dto);
        account.setId(0L);
        Domisili domisili = domisiliRepo.findById(dto.getDomisiliId()).orElse(null);
        account.setDomisiliId(domisili);

        return accountMapper.mapEntitytoDTO(accountRepo.save(account));
    }

    @Override
    public AccountResponseDTO updateAccount(AccountRequestDTO request) {

        if(request.getId().equals(0L)){
            throw new ResourceNotAcceptableException("Dont use 0 as ID, use the primary ID from DB");
        }

        accountRepo.findById(request.getId()).orElseThrow(() -> new ResourceNotFoundException("ID Not Found"));

        Account account = accountMapper.updateDTOtoEntity(request);
        account.setDomisiliId(domisiliRepo.findById(request.getDomisiliId()).orElseThrow(() -> new ResourceNotFoundException("Domisili Tidak Ditemukan")));

        return accountMapper.mapEntitytoDTO(accountRepo.save(account));
    }

    @Override
    public List<ConsultationResponseDTO> historyConsult(Long id) {
        accountRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID Not Found"));

        List<Consultation> consultations = consultationRepo.findAllByUserId_IdOrderByDateRequestDesc(id);

        return consultationMapper.mapEntitiestoDTO(consultations);
    }

    @Override
    public AccountResponseDTO loginAccount(String key) {

        Account account = accountRepo.findByFirebaseKey(key).orElseThrow(() -> new ResourceNotFoundException("ID tidak ditemukan"));
        return accountMapper.mapEntitytoDTO(account);
    }

    @Override
    public String loginAccountByEmail(AccountLoginEmailRequestDTO request) {
        Account account = accountRepo.findByEmailIgnoreCase(request.getEmail()).orElseThrow(() -> new ResourceNotFoundException("ID tidak ditemukan"));
        return account.getHandphone();
    }

}
