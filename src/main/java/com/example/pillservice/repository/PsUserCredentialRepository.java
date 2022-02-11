package com.example.pillservice.repository;

import com.ps.core.model.entity.PsUser;
import com.ps.core.model.entity.PsUserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsUserCredentialRepository extends JpaRepository<PsUserCredential, Long> {
    PsUserCredential findByUser(PsUser user);
}
