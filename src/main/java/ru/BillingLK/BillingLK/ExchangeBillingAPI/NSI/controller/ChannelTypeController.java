package ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.dto.request.ChannelTypedto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.service.ChannelTypeService;

@RestController
@RequestMapping("/api/v1/nsi")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ChannelTypeController {
    private final ChannelTypeService channelTypeService;

    @PostMapping("/addChannelType")
    public ResponseEntity addChannelType(@RequestBody ChannelTypedto channelType){
        var res = channelTypeService.registration(channelType);
        return ResponseEntity.ok(res);
    }
}
