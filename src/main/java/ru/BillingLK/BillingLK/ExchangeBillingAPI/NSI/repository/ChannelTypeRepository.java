package ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.repository;

import org.springframework.data.repository.CrudRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.ChannelType;

import java.util.UUID;

public interface ChannelTypeRepository extends CrudRepository<ChannelType, String> {
}
