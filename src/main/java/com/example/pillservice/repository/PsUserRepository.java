package com.example.pillservice.repository;

import com.ps.core.model.entity.PsUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsUserRepository extends JpaRepository<PsUser, Long> {
    PsUser findByEmail(String email);
}
