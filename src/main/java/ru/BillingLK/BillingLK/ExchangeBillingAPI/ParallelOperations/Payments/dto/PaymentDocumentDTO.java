package ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class PaymentDocumentDTO {

    @NotNull
    private Date accruaPeriod;

    @NotNull
    private Date datePayment;

    @NotEmpty
    private String personalAccountID;

    @NotNull
    private int value;

    private String paymentID;

}
