package com.example.pillservice.service;

import com.ps.core.model.entity.PsUser;
import com.ps.core.model.web.account.GetAccountResponse;
import com.ps.core.model.web.account.UpdateAccountRequest;
import com.ps.core.model.web.account.UpdateAccountResponse;

public interface UserAccountService {

    UpdateAccountResponse updateAccount
            (UpdateAccountRequest updateAccountRequest,
             PsUser psUser);
    GetAccountResponse getAccount(PsUser psUser);
}
