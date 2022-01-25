package ru.BillingLK.BillingLK.ExchangeBillingAPI.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
public abstract class BaseRequestObject<DataObject> {
    private String taskID;
    private String action;
    private String objectBaseID;
    private Date date;
    private boolean isDelete;
    private List<DataObject> data = new ArrayList<>();
}
