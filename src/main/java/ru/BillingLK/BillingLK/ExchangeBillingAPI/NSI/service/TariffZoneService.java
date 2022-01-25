package ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.dto.response.response;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.TariffZone;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.repository.TariffZoneRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TariffZoneService {

    private final TariffZoneRepository tariffZoneRepository;

    public response registration(TariffZone tariffZone){
        try {
            tariffZoneRepository.save(tariffZone);
            return response.CreateResponse(true,"");
        }
        catch (Exception exception){
            return response.CreateResponse(false, exception.getMessage());
        }
    }

    /*public TariffZone findId(String id) throws Exception {
        UUID ids = UUID.fromString(id);
        Optional<TariffZone> t = tariffZoneRepository.findById(ids);
        if (t == null){
            throw new Exception("Нулл значение");
        }
        return t.get();
    }*/

    public List<TariffZone> findAll(){
        return (List<TariffZone>) tariffZoneRepository.findAll();

    }
}
