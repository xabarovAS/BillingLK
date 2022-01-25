package ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.dto.response.response;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.Scale;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.repository.ScaleRepository;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ScaleService {
    private final ScaleRepository scaleRepository;

    public response registration(Scale scale){
        try {
            scaleRepository.save(scale);
            return response.CreateResponse(true,"");
        }
        catch (Exception exception){
            return response.CreateResponse(false, exception.getMessage());
        }
    }
}
