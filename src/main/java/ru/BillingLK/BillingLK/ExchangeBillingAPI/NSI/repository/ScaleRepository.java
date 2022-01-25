package ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.repository;

import org.springframework.data.repository.CrudRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.Scale;

import java.util.UUID;

public interface ScaleRepository extends CrudRepository<Scale, String> {
}
