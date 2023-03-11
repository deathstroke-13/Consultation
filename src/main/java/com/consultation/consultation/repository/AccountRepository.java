package com.consultation.consultation.repository;

import com.consultation.consultation.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findById(Long id);

    Optional<Account> findByFirebaseKey(String firebaseKey);

    Optional<Account> findByEmailIgnoreCase(String email);
}
