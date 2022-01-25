package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.dto.BaseOpeningPersonalAccountdto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.dto.OpeningPersonalAccountdto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.service.PersonalAccountService;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.dto.response.response;

import java.util.List;

@RestController
@RequestMapping("/api/v1/PersonalAccount")
public class PersonalAccountController {

    @Autowired
    private PersonalAccountService personalAccountService;

    @PostMapping("/OpeningPersonalAccount")
    public ResponseEntity OpeningPersonalAccount(@RequestBody BaseOpeningPersonalAccountdto baseOpeningPersonalAccountdto) {
        var res = personalAccountService.RegistrationOpeningPersonalAccount(baseOpeningPersonalAccountdto);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/ClosePersonalAccount")
    public ResponseEntity ClosePersonalAccount(@RequestBody OpeningPersonalAccountdto openingPersonalAccountdto){
        //var res = personalAccountService.RegistrationOpeningPersonalAccount(openingPersonalAccountdto);
        return ResponseEntity.ok(new response());
    }
}
