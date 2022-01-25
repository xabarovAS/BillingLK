package ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.Scale;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.service.ScaleService;

@RestController
@RequestMapping("/api/v1/nsi")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ScaleController {
    private final ScaleService scaleService;

    @PostMapping("/addScale")
    public ResponseEntity addScale(@RequestBody Scale scale){
        var res = scaleService.registration(scale);
        return ResponseEntity.ok(res);
    }
}
