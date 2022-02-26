package ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "payments")
public class Payment {
    @Id
    @Column(name = "id", updatable = false, nullable = false, length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "object_base_id", updatable = false, nullable = false)
    private String objectBaseID;

    @Column(nullable = false)
    private Date accruaPeriod;

    @Column(nullable = false)
    private Date datePayment;

    @Column(nullable = false)
    private String personalAccountID;

    @Column(nullable = false)
    private int value;

    private String foreignPaymentID;
}
