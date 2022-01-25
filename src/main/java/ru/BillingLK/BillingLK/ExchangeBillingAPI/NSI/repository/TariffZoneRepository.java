package ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.repository;

import org.springframework.data.repository.CrudRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.TariffZone;

import java.util.UUID;

public interface TariffZoneRepository extends CrudRepository<TariffZone, String> {
}
