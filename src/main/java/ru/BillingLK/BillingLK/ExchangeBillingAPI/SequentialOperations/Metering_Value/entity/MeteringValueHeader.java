package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Value.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "metering_value_header")
public class MeteringValueHeader {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(nullable = false)
    private Date dateEvent;

    private boolean deleteMark;

    @Column(nullable = false)
    private String actionMain;

    //@Column(nullable = false)
    //private String sourceValue;

}
