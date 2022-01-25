package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Value.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class MeteringValuesDTO {
    private String meteringDeviceID;
    private String scaleID;
    private String tariffZoneID;
    private int value;
}
