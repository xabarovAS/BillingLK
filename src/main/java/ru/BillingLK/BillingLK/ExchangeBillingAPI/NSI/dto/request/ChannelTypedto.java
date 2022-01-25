package ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.dto.request;

import lombok.Getter;
import lombok.Setter;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.Scale;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ChannelTypedto{
    private String id;
    private boolean isDelete;
    private String name;
    private List<Scaledto> scales = new ArrayList<>();
}
