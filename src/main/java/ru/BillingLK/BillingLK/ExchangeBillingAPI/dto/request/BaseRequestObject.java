package ru.BillingLK.BillingLK.ExchangeBillingAPI.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @NotNull
    private List<DataObject> data = new ArrayList<>();
}
