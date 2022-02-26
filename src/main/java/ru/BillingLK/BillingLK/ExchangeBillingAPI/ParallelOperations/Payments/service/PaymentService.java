package ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.service;

import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.dto.BasePaymentDocumentDTO;

public interface PaymentService {
    public void GetAll();
    public void RegistrationPaymentInitialConversion();
    public void RegistrationPaymentDocument(BasePaymentDocumentDTO basePaymentDocumentDTO) throws Exception;
}
