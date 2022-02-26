package ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.entity;


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
@Table(name = "payment_header")
public class PaymentHeader {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(nullable = false)
    private Date dateEvent;

    private boolean deleteMark;
}
