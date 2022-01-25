package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Accounting_Point.dto;

import lombok.Getter;
import lombok.Setter;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.dto.DifferentiationsMeteringDeviceDTO;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.dto.InstalMeteringDeviceDTO;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ConnectAccountingPointdto {
    private String meteringPointID;
    private String name;
    private String service;
    private String location;
    private boolean state;
    private InstalMeteringDeviceDTO instalMeteringDeviceDTO;
}
