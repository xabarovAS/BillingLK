package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Value.repository;

import org.springframework.data.repository.CrudRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Value.entity.MeteringValues;

public interface MeteringValuesRepository extends CrudRepository<MeteringValues, String> {
}
