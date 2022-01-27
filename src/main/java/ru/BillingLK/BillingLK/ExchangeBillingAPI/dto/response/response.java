package ru.BillingLK.BillingLK.ExchangeBillingAPI.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class response {
    private byte status;
    private byte secondcode;
    private String message;

    public static response CreateResponse(boolean result, String message){
        response res = new response();
        if (result == true){
            res.setStatus((byte) 1);
        }
        else {
            res.setStatus((byte) -1);
        }

        res.setMessage(message);
        return res;
    }
}
