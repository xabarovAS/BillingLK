package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.dto.request.TariffZonedto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.dto.response.response;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.TariffZone;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.TypeDifferentiation;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Accounting_Point.service.AccountingPointService;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.dto.BaseOpeningPersonalAccountdto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.dto.OpeningPersonalAccountdto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.entity.PersonalAccount;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.entity.StatePersonalAccount;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.repository.PersonalAccountRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.repository.StatePersonalAccountRepository;

import java.sql.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonalAccountService {
    private final PersonalAccountRepository personalAccountRepository;
    private final StatePersonalAccountRepository statePersonalAccountRepository;
    private final AccountingPointService accountingPointService;

    public response RegistrationOpeningPersonalAccount(BaseOpeningPersonalAccountdto baseOpeningPersonalAccountdto){

        var dataBasedto = baseOpeningPersonalAccountdto.getData();
        if (dataBasedto.isEmpty()){
            return response.CreateResponse(false, "Не найденно данных для регистрации лицевого счета");
        }

        OpeningPersonalAccountdto openingPersonalAccountdto = dataBasedto.get(0);

        PersonalAccount personalAccount = new PersonalAccount();
        personalAccount.setId(openingPersonalAccountdto.getPersonalAccountID());
        personalAccount.setNumber(openingPersonalAccountdto.getPersonalAccount());
        personalAccount.setFirstName(openingPersonalAccountdto.getFirstName());
        personalAccount.setSecondName(openingPersonalAccountdto.getSecondName());
        personalAccount.setMiddleName(openingPersonalAccountdto.getMiddleName());
        personalAccount.setAddress(openingPersonalAccountdto.getAddress());

        StatePersonalAccount statePersonalAccount = new StatePersonalAccount();
        statePersonalAccount.setId(baseOpeningPersonalAccountdto.getObjectBaseID());
        statePersonalAccount.setPersonalAccountID(openingPersonalAccountdto.getPersonalAccountID());
        statePersonalAccount.setState(openingPersonalAccountdto.isState());
        statePersonalAccount.setDateEvent(baseOpeningPersonalAccountdto.getDate());
        try {
            personalAccountRepository.save(personalAccount);
            statePersonalAccountRepository.save(statePersonalAccount);
            accountingPointService.ConnectAccountingPoint(
                    baseOpeningPersonalAccountdto.getObjectBaseID(),
                    baseOpeningPersonalAccountdto.getDate(),
                    openingPersonalAccountdto.getPersonalAccountID(),
                    openingPersonalAccountdto.getMeteringPoints());

            return response.CreateResponse(true,"");
        }
        catch (Exception exception){
            return response.CreateResponse(false, exception.getMessage());
        }
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
}