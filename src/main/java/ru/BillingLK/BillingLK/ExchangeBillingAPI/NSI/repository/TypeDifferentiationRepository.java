package ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.repository;

import org.springframework.data.repository.CrudRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.TypeDifferentiation;

import java.util.UUID;

public interface TypeDifferentiationRepository extends CrudRepository<TypeDifferentiation, String> {
}
