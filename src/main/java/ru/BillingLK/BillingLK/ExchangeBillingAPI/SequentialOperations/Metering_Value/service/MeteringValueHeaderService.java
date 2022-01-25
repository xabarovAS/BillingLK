package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Value.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Value.dto.BaseMeteringValuesDTO;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Value.dto.MeteringValuesDTO;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Value.entity.MeteringValueHeader;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Value.entity.MeteringValues;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Value.repository.MeteringValueHeaderRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Value.repository.MeteringValuesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MeteringValueHeaderService {

    private final MeteringValueHeaderRepository meteringValueHeaderRepository;
    private final MeteringValuesRepository meteringValuesRepository;

    public void RegistrationMeteringValues(BaseMeteringValuesDTO baseMeteringValuesDTO){

        MeteringValueHeader HeaderDoc = new MeteringValueHeader();
        HeaderDoc.setId(baseMeteringValuesDTO.getObjectBaseID());
        HeaderDoc.setDate(baseMeteringValuesDTO.getDate());
        HeaderDoc.setDelete(baseMeteringValuesDTO.isDelete());
        HeaderDoc.setAction(baseMeteringValuesDTO.getAction());
        meteringValueHeaderRepository.save(HeaderDoc);

        List<MeteringValuesDTO> meteringValuesDTO = baseMeteringValuesDTO.getData();
        for (MeteringValuesDTO lineValuesDTO: meteringValuesDTO){
            MeteringValues newLine = new MeteringValues();
            newLine.setObjectBaseID(baseMeteringValuesDTO.getObjectBaseID());
            newLine.setMeteringDeviceID(lineValuesDTO.getMeteringDeviceID());
            newLine.setScaleID(lineValuesDTO.getScaleID());
            newLine.setTariffZoneID(lineValuesDTO.getTariffZoneID());
            newLine.setValue(lineValuesDTO.getValue());
            meteringValuesRepository.save(newLine);
        }

    }

}
