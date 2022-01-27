package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class StatePersonalAccount {
    @Id
    //@GeneratedValue(generator = "uuid2")
    //@GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    //@Column(name = "object_base_id", updatable = false, nullable = false)
    //private String objectBaseID;

    @Column(name = "date_event", updatable = false, nullable = false)
    private Date dateEvent;

    @Column(name = "personal_account_id", updatable = false, nullable = false)
    private String personalAccountID;

    @Column(nullable = false)
    private boolean state;
}
