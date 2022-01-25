package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Value.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "metering_values")
public class MeteringValues {
    @Id
    @Column(name = "id", updatable = false, nullable = false, length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "object_base_id", updatable = false, nullable = false)
    private String objectBaseID;

    @Column(name = "metering_device_id", updatable = false, nullable = false)
    private String meteringDeviceID;

    @Column(name = "scale_id", updatable = false, nullable = false)
    private String scaleID;

    @Column(name = "tariff_zone_id", updatable = false, nullable = false)
    private String tariffZoneID;

    private int value;
}
