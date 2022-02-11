package com.example.pillservice.repository;

import com.ps.core.model.entity.PsUser;
import com.ps.core.model.entity.PsUserSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsUserSessionRepository extends JpaRepository<PsUserSession, Long> {

    PsUserSession findBySessionId(String sessionId);

    PsUserSession findByUserAndIsValidTrue(PsUser user);

    PsUserSession findBySessionIdAndIsValidTrue(String sessionId);
}
