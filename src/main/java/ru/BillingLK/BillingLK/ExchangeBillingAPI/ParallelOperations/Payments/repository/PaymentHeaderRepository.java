package ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.repository;

import org.springframework.data.repository.CrudRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.entity.PaymentHeader;

public interface PaymentHeaderRepository extends CrudRepository<PaymentHeader, String> {
}
