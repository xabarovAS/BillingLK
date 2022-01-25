package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.entity.DifferentiationsMeteringDevice;

@Repository
public interface DifferentiationsMeteringDeviceRepository extends CrudRepository<DifferentiationsMeteringDevice, String> {
}
