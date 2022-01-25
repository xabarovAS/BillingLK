package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.dto.DifferentiationsMeteringDeviceDTO;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.dto.InstalMeteringDeviceDTO;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.entity.MeteringDevice;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.entity.StateMeteringDevice;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.repository.MeteringDeviceRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.repository.StateMeteringDeviceRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MeteringDeviceService {
    private final MeteringDeviceRepository meteringDeviceRepository;
    private final StateMeteringDeviceRepository stateMeteringDeviceRepository;
    private final DifferentiationsMeteringDeviceService differentiationsMeteringDeviceService;

    public void InstalMeteringDevice(String objectBaseID, Date dateEvent, String accountingPointID, InstalMeteringDeviceDTO instalMeteringDeviceDTO) throws Exception {
        MeteringDevice meteringDevice = new MeteringDevice();
        meteringDevice.setId(instalMeteringDeviceDTO.getMeteringDeviceID());
        meteringDevice.setFactoryNumber(instalMeteringDeviceDTO.getFactoryNumber());
        meteringDevice.setChannelTypeID(instalMeteringDeviceDTO.getChannelTypeID());
        meteringDevice.setMeteringDeviceTypeName(instalMeteringDeviceDTO.getMeteringDeviceTypeName());
        meteringDevice.setAccountingPointID(accountingPointID);
        meteringDeviceRepository.save(meteringDevice);

        StateMeteringDevice stateMeteringDevice = new StateMeteringDevice();
        stateMeteringDevice.setId(objectBaseID);
        stateMeteringDevice.setDateEvent((java.sql.Date) dateEvent);
        stateMeteringDevice.setMeteringDeviceId(instalMeteringDeviceDTO.getMeteringDeviceID());
        stateMeteringDevice.setState(instalMeteringDeviceDTO.isState());
        stateMeteringDeviceRepository.save(stateMeteringDevice);

        List<DifferentiationsMeteringDeviceDTO> dataDiffDTO = instalMeteringDeviceDTO.getDifferentiationsMDDTOs();
        differentiationsMeteringDeviceService.InstallDifferentiationsMeteringDevice(objectBaseID, dateEvent, instalMeteringDeviceDTO.getMeteringDeviceID(), dataDiffDTO);
    }
}
