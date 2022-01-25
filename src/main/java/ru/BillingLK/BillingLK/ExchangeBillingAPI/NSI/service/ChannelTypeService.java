package ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.dto.request.ChannelTypedto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.dto.request.Scaledto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.dto.response.response;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.ChannelType;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.Scale;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.repository.ChannelTypeRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.repository.ScaleRepository;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ChannelTypeService {
    private final ChannelTypeRepository channelTypeRepository;
    private final ScaleRepository scaleRepository;

    public response registration(ChannelTypedto channelTypedto){
        ChannelType channelType = new ChannelType();
        channelType.setId(channelTypedto.getId());
        channelType.setDelete(channelTypedto.isDelete());
        channelType.setName(channelTypedto.getName());

        try {
            channelTypeRepository.save(channelType);
            var scales = channelTypedto.getScales();
            for (Scaledto scaledto:scales) {
                var scaleOptional = scaleRepository.findById(scaledto.getId());
                if (scaleOptional != null){
                    Scale scale = scaleOptional.get();
                    scale.setChannelType(channelType);
                    scaleRepository.save(scale);
                }
            }

            return response.CreateResponse(true,"");
        }
        catch (Exception exception){
            return response.CreateResponse(false, exception.getMessage());
        }
    }
}

