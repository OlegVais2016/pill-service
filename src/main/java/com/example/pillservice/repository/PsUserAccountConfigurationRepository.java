package com.example.pillservice.repository;


import com.ps.core.model.entity.PsUser;
import com.ps.core.model.entity.PsUserAccountConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsUserAccountConfigurationRepository extends JpaRepository<PsUserAccountConfiguration, Long> {

    PsUserAccountConfiguration findByPsUser(PsUser psUser);

}
