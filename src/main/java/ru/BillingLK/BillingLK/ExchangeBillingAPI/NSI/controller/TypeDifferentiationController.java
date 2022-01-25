package ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.dto.request.TypeDifferentiationdto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity.TypeDifferentiation;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.service.TypeDifferentiationService;

@RestController
@RequestMapping("/api/v1/nsi")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TypeDifferentiationController {

    private final TypeDifferentiationService typeDifferentiationService;

    @PostMapping("/addTypeDifferentiation")
    public ResponseEntity addTypeDifferentiation(@RequestBody TypeDifferentiationdto typeDifferentiation){
        var res = typeDifferentiationService.registration(typeDifferentiation);
        return ResponseEntity.ok(res);
    }
}
