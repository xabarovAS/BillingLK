package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.dto.DifferentiationsMeteringDeviceDTO;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.entity.DifferentiationsMeteringDevice;

@Mapper
public interface DifferentiationsMeteringDeviceMapper {
    //DifferentiationsMeteringDeviceMapper INSTANCE = Mappers.getMapper(DifferentiationsMeteringDeviceMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateEvent", ignore = true)
    @Mapping(source = "dto.meteringDeviceID",target = "meteringDeviceId")
    DifferentiationsMeteringDevice ToModel(DifferentiationsMeteringDeviceDTO dto);

}
