package ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.dto.request.TariffZonedto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.dto.request.TypeDifferentiationdto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.dto.response.response;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.TariffZone;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.TypeDifferentiation;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.repository.TariffZoneRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.repository.TypeDifferentiationRepository;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TypeDifferentiationService {
    private final TypeDifferentiationRepository typeDifferentiationRepository;
    private final TariffZoneRepository tariffZoneRepository;

    public response registration(TypeDifferentiationdto typeDifferentiationdto){
        TypeDifferentiation typeDifferentiation = new TypeDifferentiation();
        typeDifferentiation.setId(typeDifferentiationdto.getId());
        typeDifferentiation.setDelete(typeDifferentiationdto.isDelete());
        typeDifferentiation.setName(typeDifferentiationdto.getName());

        try {
            typeDifferentiationRepository.save(typeDifferentiation);
            var tariffZonesdto = typeDifferentiationdto.getTariffZones();
            for (TariffZonedto tariffZonedto:tariffZonesdto) {
                var tariffZoneOptional = tariffZoneRepository.findById(tariffZonedto.getId());
                if (tariffZoneOptional != null){
                    TariffZone tariffZone = tariffZoneOptional.get();
                    tariffZone.setTypeDifferentiation(typeDifferentiation);
                    tariffZoneRepository.save(tariffZone);
                }
            }
            return response.CreateResponse(true,"");
        }
        catch (Exception exception){
            return response.CreateResponse(false, exception.getMessage());
        }
    }
}
