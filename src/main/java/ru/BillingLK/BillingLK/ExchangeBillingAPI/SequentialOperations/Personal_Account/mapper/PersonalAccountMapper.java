package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.dto.DifferentiationsMeteringDeviceDTO;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.entity.DifferentiationsMeteringDevice;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.dto.OpeningPersonalAccountdto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.entity.PersonalAccount;

@Mapper
public interface PersonalAccountMapper {

    @Mapping(source = "dto.personalAccountID",target = "id")
    @Mapping(source = "dto.personalAccount",target = "number")
    PersonalAccount ToModel(OpeningPersonalAccountdto dto);
}
