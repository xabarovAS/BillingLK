package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.service;

import org.springframework.transaction.annotation.Transactional;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.dto.BaseOpeningPersonalAccountdto;

public interface PersonalAccountService {

    @Transactional
    void RegistrationOpeningPersonalAccount(BaseOpeningPersonalAccountdto baseOpeningPersonalAccountdto) throws Exception;

    void RegistrationClosePersonalAccount();
    void RegistrationChangeOwnerPremises();

}
