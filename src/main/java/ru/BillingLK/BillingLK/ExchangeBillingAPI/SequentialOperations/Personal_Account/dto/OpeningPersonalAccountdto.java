package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.dto;

import lombok.Getter;
import lombok.Setter;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Accounting_Point.dto.ConnectAccountingPointdto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OpeningPersonalAccountdto {
    private String personalAccountID;
    private String personalAccount;
    private String firstName;
    private String secondName;
    private String middleName;
    private String address;
    private boolean state;

    // Точки учета
    private List<ConnectAccountingPointdto> MeteringPoints = new ArrayList<>();
}