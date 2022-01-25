package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Accounting_Point.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class AccountingPoint {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String service;

    @Column(nullable = false, length = 200)
    private String location;
}
