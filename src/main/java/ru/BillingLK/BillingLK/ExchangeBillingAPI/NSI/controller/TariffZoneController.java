package ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.TariffZone;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.service.TariffZoneService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nsi")
public class TariffZoneController {

    @Autowired
    private TariffZoneService tariffZoneService;

    @GetMapping("/")
    public List<TariffZone> getWork(){
        return tariffZoneService.findAll();
    }

    @PostMapping("/addTariffZone")
    public ResponseEntity addTariffZone(@RequestBody TariffZone tariffZone){
        var res = tariffZoneService.registration(tariffZone);
        return ResponseEntity.ok(res);
    }
}
