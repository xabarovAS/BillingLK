package ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.controller;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.dto.BasePaymentDocumentDTO;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.service.implementation.PaymentServiceImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/Payments")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentController {

    private final PaymentServiceImpl paymentService;

    @GetMapping
    public ResponseEntity<String> GetPayments(){
        return ResponseEntity.ok("work");
    }

    @PostMapping("/RegistrationPayment")
    public ResponseEntity RegistrationPayment(@Valid @RequestBody BasePaymentDocumentDTO basePaymentDocumentDTO, @NotNull BindingResult bindingResult) throws Exception {

        paymentService.RegistrationPaymentDocument(basePaymentDocumentDTO);
        return new ResponseEntity(HttpStatus.OK);

    }


}
