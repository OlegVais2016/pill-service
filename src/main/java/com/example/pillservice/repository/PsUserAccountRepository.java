package com.example.pillservice.repository;

import com.ps.core.model.entity.PsUser;
import com.ps.core.model.entity.PsUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PsUserAccountRepository extends JpaRepository<PsUserInfo, Long> {
//    List<PsUserAccountConfiguration> findByPsUserAccountStatus(PsUserAccountStatus psUserAccountStatus);

    PsUserInfo findByPsUser(PsUser psUser);
}
