package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Accounting_Point.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Accounting_Point.dto.ConnectAccountingPointdto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Accounting_Point.entity.AccountingPoint;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Accounting_Point.entity.OwnerAccountingPoint;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Accounting_Point.entity.StateAccountingPoint;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Accounting_Point.repository.AccountingPointRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Accounting_Point.repository.OwnerAccountingPointRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Accounting_Point.repository.StateAccountingPointRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.service.MeteringDeviceService;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountingPointService {
    private final AccountingPointRepository accountingPointRepository;
    private final StateAccountingPointRepository stateAccountingPointRepository;
    private final OwnerAccountingPointRepository ownerAccountingPointRepository;
    private final MeteringDeviceService meteringDeviceService;

    public void ConnectAccountingPoint(String objectBaseID, Date dateEvent, String ownerAccountingPointID, List<ConnectAccountingPointdto> data) throws Exception {
        if (data.isEmpty()){
            throw new Exception("Нет данных для регистрации точек учета");
        }

        for (ConnectAccountingPointdto connectAccountingPoint: data) {
            AccountingPoint accountingPoint = new AccountingPoint();
            accountingPoint.setId(connectAccountingPoint.getMeteringPointID());
            accountingPoint.setName(connectAccountingPoint.getName());
            accountingPoint.setService(connectAccountingPoint.getService());
            accountingPoint.setLocation(connectAccountingPoint.getLocation());
            accountingPointRepository.save(accountingPoint);

            StateAccountingPoint stateAccountingPoint = new StateAccountingPoint();
            stateAccountingPoint.setId(objectBaseID);
            stateAccountingPoint.setDateEvent((java.sql.Date) dateEvent);
            stateAccountingPoint.setAccountingPointID(objectBaseID);
            stateAccountingPoint.setState(connectAccountingPoint.isState());
            stateAccountingPointRepository.save(stateAccountingPoint);

            OwnerAccountingPoint ownerAccountingPoint = new OwnerAccountingPoint();
            ownerAccountingPoint.setId(objectBaseID);
            ownerAccountingPoint.setDateEvent((java.sql.Date) dateEvent);
            ownerAccountingPoint.setAccountingPointID(ownerAccountingPointID);
            ownerAccountingPointRepository.save(ownerAccountingPoint);

            meteringDeviceService.InstalMeteringDevice(objectBaseID, dateEvent, connectAccountingPoint.getMeteringPointID(), connectAccountingPoint.getInstalMeteringDeviceDTO());
        }
    }
}
