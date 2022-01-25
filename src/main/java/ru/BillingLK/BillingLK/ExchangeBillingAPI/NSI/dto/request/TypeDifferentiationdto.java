package ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.dto.request;

import lombok.Getter;
import lombok.Setter;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.TariffZone;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class TypeDifferentiationdto {
    private String id;
    private boolean isDelete;
    private String name;
    private List<TariffZonedto> tariffZones = new ArrayList<>();

}
