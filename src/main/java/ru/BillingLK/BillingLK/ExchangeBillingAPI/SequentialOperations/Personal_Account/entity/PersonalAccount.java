package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.entity;

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
public class PersonalAccount {

    @Id
    //@GeneratedValue(generator = "uuid2")
    //@GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(nullable = false, length = 50)
    private String number;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String secondName;

    @Column(nullable = false, length = 50)
    private String middleName;

    @Column(nullable = false)
    private String address;

}
