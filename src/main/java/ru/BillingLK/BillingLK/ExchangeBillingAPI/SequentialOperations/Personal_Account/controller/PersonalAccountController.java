package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.dto.BaseOpeningPersonalAccountdto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.dto.OpeningPersonalAccountdto;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Personal_Account.service.implementation.PersonalAccountServiceImpl;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.dto.response.response;

@RestController
@RequestMapping("/api/v1/PersonalAccount")
public class PersonalAccountController {

    @Autowired
    private PersonalAccountServiceImpl personalAccountService;

    @PostMapping("/OpeningPersonalAccount")
    public ResponseEntity<String> OpeningPersonalAccount(@RequestBody BaseOpeningPersonalAccountdto baseOpeningPersonalAccountdto) throws Exception {
        response res = response.CreateResponse(true, "");
        personalAccountService.RegistrationOpeningPersonalAccount(baseOpeningPersonalAccountdto);

        /*try {
            personalAccountService.RegistrationOpeningPersonalAccount(baseOpeningPersonalAccountdto);
        }
        catch (Exception ex){
            res = response.CreateResponse(false, ex.getMessage());
        }*/

        return ResponseEntity.ok("Success");
    }

    @PostMapping("/ClosePersonalAccount")
    public ResponseEntity<String> ClosePersonalAccount(@RequestBody OpeningPersonalAccountdto openingPersonalAccountdto){
        //var res = personalAccountService.RegistrationOpeningPersonalAccount(openingPersonalAccountdto);
        return ResponseEntity.ok("Success");
    }
}
