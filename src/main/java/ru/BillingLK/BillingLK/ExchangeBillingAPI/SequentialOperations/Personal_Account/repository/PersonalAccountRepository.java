package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.repository;

import org.springframework.data.repository.CrudRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.entity.PersonalAccount;

public interface PersonalAccountRepository extends CrudRepository<PersonalAccount, String> {

    //public PersonalAccount GetOpenPersonalAccount();
    //public PersonalAccount GetActiveMeteringPoint();

}
