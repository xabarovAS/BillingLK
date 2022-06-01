package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.dto.BaseOpeningPersonalAccountdto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.dto.OpeningPersonalAccountdto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.entity.PersonalAccount;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.entity.StatePersonalAccount;

@Mapper
public interface StatePersonalAccountMapper {

    @Mapping(source = "baseEventDTO.objectBaseID",target = "id")
    @Mapping(source = "baseEventDTO.date",target = "dateEvent")
    @Mapping(source = "PersonalAccountDTO.personalAccountID",target = "personalAccountID")
    @Mapping(target = "state", expression = "java(PersonalAccountDTO.isState())")
    StatePersonalAccount ToModelFromEvent(BaseOpeningPersonalAccountdto baseEventDTO, OpeningPersonalAccountdto PersonalAccountDTO);

}
