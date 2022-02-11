package com.example.pillservice.repository;

import com.ps.core.model.entity.RegistrationConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationConfirmationRepository extends JpaRepository<RegistrationConfirmation,Long> {

    RegistrationConfirmation findByConfirmationLink(String link);
    List<RegistrationConfirmation> findBySendStatusFalse();
}
