package ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.entity.PaymentHeader;

public interface PaymentHeaderRepository extends JpaRepository<PaymentHeader, String> {
}
