package ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {

    @Modifying
    @Query("delete from Payment p where p.objectBaseID=:objectBaseID")
    void deleteByObjectBaseID(@Param("objectBaseID") String objectBaseID);
}
