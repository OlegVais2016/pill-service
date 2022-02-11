package com.example.pillservice.service.impl;

import com.ps.core.model.entity.HcUserSession;
import com.ps.core.model.entity.PsUser;
import com.ps.core.model.entity.type.HcType;
import com.ps.core.repository.HcUserSessionRepository;
import com.ps.core.service.HcUserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HcUserSessionServiceImpl implements HcUserSessionService {

    @Autowired
    private HcUserSessionRepository userSessionRepository;

    @Override
    public HcUserSession findByPsUser(PsUser user) {
        return userSessionRepository.findByUser(user);
    }

    @Override
    public HcUserSession saveOrUpdate(HcUserSession userSession) {
        return userSessionRepository.save(userSession);
    }

    @Override
    public HcUserSession saveOrUpdate(PsUser user, String sessionId, HcType hcType) {
        HcUserSession userSession = userSessionRepository.findByUser_Id(user.getId());

        userSessionRepository.findByUser(user);
        if (userSession == null) {
            userSession = HcUserSession.builder()
                    .user(user)
                    .hcType(HcType.DEMO)
                    .build();

        }

        userSession.setSessionId(sessionId);

        return userSessionRepository.save(userSession);
    }

    @Override
    public void delete(PsUser user) {
        HcUserSession userSession = userSessionRepository.findByUser_Id(user.getId());
        if (userSession != null) {
            userSessionRepository.delete(userSession);
        }
    }
}
