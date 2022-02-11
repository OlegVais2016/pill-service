package com.example.pillservice.repository;

import com.ps.core.model.entity.HcUserSession;
import com.ps.core.model.entity.PsUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HcUserSessionRepository extends JpaRepository<HcUserSession, Long> {

    HcUserSession findByUser(PsUser psUser);
    HcUserSession findByUser_Id(Long userId);
}
