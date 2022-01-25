package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Accounting_Point.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class StateAccountingPoint {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "date_event", updatable = false, nullable = false)
    private Date dateEvent;

    @Column(name = "accounting_point_id", updatable = false, nullable = false)
    private String accountingPointID;

    @Column(nullable = false)
    private boolean state;
}
