package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.dto.DifferentiationsMeteringDeviceDTO;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.entity.DifferentiationsMeteringDevice;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.mapper.DifferentiationsMeteringDeviceMapper;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.repository.DifferentiationsMeteringDeviceRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DifferentiationsMeteringDeviceService {
    private final DifferentiationsMeteringDeviceMapper differentiationsMeteringDeviceMapper;
    private final DifferentiationsMeteringDeviceRepository differentiationsMDRepository;

    public void InstallDifferentiationsMeteringDevice(String objectBaseID, Date dateEvent, String meteringDeviceId, List<DifferentiationsMeteringDeviceDTO> data) throws Exception {
        if (data.isEmpty()){
            throw new Exception("Нет данных для регистрации вида дифференцированности прибора учета");
        }

        for (DifferentiationsMeteringDeviceDTO diffMDObject: data) {
            DifferentiationsMeteringDevice differentiationsMeteringDevice = differentiationsMeteringDeviceMapper.ToModel(diffMDObject);
            differentiationsMeteringDevice.setId(objectBaseID);
            differentiationsMeteringDevice.setDateEvent((java.sql.Date) dateEvent);
            differentiationsMeteringDevice.setMeteringDeviceId(meteringDeviceId);
            differentiationsMDRepository.save(differentiationsMeteringDevice);

            /*
            DifferentiationsMeteringDevice differentiationsMeteringDevice = new DifferentiationsMeteringDevice();
            differentiationsMeteringDevice.setId(objectBaseID);
            differentiationsMeteringDevice.setDateEvent((java.sql.Date) dateEvent);
            differentiationsMeteringDevice.setMeteringDeviceId(meteringDeviceId);
            differentiationsMeteringDevice.setScaleID(diffMDObject.getScaleID());
            differentiationsMeteringDevice.setTypeDifferentiationID(diffMDObject.getTypeDifferentiationID());
            differentiationsMDRepository.save(differentiationsMeteringDevice);*/

        }
    }

}
