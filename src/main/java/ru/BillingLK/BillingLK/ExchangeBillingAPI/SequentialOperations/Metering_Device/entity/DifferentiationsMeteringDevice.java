package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class DifferentiationsMeteringDevice {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "date_event", updatable = false, nullable = false)
    private Date dateEvent;

    @Column(name = "metering_device_id", updatable = false, nullable = false)
    private String meteringDeviceId;

    @Column(name = "scale_id", updatable = false,nullable = false)
    private String scaleID;

    @Column(name = "type_differentiation_id", updatable = false,nullable = false)
    private String typeDifferentiationID;
}
