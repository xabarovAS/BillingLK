package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "metering_devices")
public class MeteringDevice {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(nullable = false)
    private String factoryNumber;

    @Column(nullable = false)
    private String channelTypeID;

    @Column(nullable = false)
    private String meteringDeviceTypeName;

    @Column(name = "accounting_point_id",nullable = false)
    private String accountingPointID;
}
