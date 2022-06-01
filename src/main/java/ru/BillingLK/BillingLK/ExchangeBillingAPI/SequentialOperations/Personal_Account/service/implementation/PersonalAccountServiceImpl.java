package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Accounting_Point.service.AccountingPointService;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.dto.BaseOpeningPersonalAccountdto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.dto.OpeningPersonalAccountdto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.entity.PersonalAccount;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.entity.StatePersonalAccount;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.mapper.PersonalAccountMapper;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.mapper.StatePersonalAccountMapper;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.repository.PersonalAccountRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.repository.StatePersonalAccountRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.service.PersonalAccountService;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.dto.response.response;

import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonalAccountServiceImpl implements PersonalAccountService {
    private final PersonalAccountRepository personalAccountRepository;
    private final PersonalAccountMapper personalAccountMapper;
    private final StatePersonalAccountMapper statePersonalAccountMapper;

    private final StatePersonalAccountRepository statePersonalAccountRepository;
    private final AccountingPointService accountingPointService;

    @Transactional
    @Override
    public void RegistrationOpeningPersonalAccount(BaseOpeningPersonalAccountdto baseOpeningPersonalAccountdto) throws Exception {

        var dataBasedto = baseOpeningPersonalAccountdto.getData();
        if (dataBasedto.isEmpty()){
            throw new Exception("No data found for registering a personal account");
        }

        OpeningPersonalAccountdto openingPersonalAccountdto = dataBasedto.get(0);

        PersonalAccount personalAccount = personalAccountMapper.ToModel(openingPersonalAccountdto);
        personalAccountRepository.save(personalAccount);


        StatePersonalAccount statePersonalAccount = statePersonalAccountMapper.ToModelFromEvent(baseOpeningPersonalAccountdto, openingPersonalAccountdto);
        statePersonalAccountRepository.save(statePersonalAccount);

        /*StatePersonalAccount statePersonalAccount = new StatePersonalAccount();
        statePersonalAccount.setId(baseOpeningPersonalAccountdto.getObjectBaseID());
        statePersonalAccount.setPersonalAccountID(openingPersonalAccountdto.getPersonalAccountID());
        statePersonalAccount.setState(openingPersonalAccountdto.isState());
        statePersonalAccount.setDateEvent(baseOpeningPersonalAccountdto.getDate());
        statePersonalAccountRepository.save(statePersonalAccount);*/

    }

    public response RegistrationClosePersonalAccount(OpeningPersonalAccountdto openingPersonalAccountdto){
        PersonalAccount personalAccount = new PersonalAccount();
        personalAccount.setId(openingPersonalAccountdto.getPersonalAccountID());
        personalAccount.setFirstName(openingPersonalAccountdto.getFirstName());
        personalAccount.setSecondName(openingPersonalAccountdto.getSecondName());
        personalAccount.setMiddleName(openingPersonalAccountdto.getMiddleName());

        StatePersonalAccount statePersonalAccount = new StatePersonalAccount();
        statePersonalAccount.setPersonalAccountID(openingPersonalAccountdto.getPersonalAccountID());
        statePersonalAccount.setId(UUID.randomUUID().toString());
        statePersonalAccount.setState(openingPersonalAccountdto.isState());
        //statePersonalAccount.setDateEvent(openingPersonalAccountdto.getDateEvent());
        try {
            personalAccountRepository.save(personalAccount);
            statePersonalAccountRepository.save(statePersonalAccount);
            return response.CreateResponse(true,"");
        }
        catch (Exception exception){
            return response.CreateResponse(false, exception.getMessage());
        }
    }



    @Override
    public void RegistrationClosePersonalAccount() {

    }

    @Override
    public void RegistrationChangeOwnerPremises() {

    }
}
