package ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.dto.BasePaymentDocumentDTO;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.dto.PaymentDocumentDTO;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.entity.Payment;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.entity.PaymentHeader;

@Mapper
public interface PaymentMapper {

    @Mapping(source = "dto.objectBaseID",target = "id")
    @Mapping(source = "dto.date",target = "dateEvent")
    @Mapping(target = "deleteMark", expression = "java(dto.isDelete())")
    PaymentHeader ToModelPaymentHeader(BasePaymentDocumentDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "baseDTO.objectBaseID",target = "objectBaseID")
    @Mapping(source = "documentDTO.paymentID",target = "foreignPaymentID")
    Payment ToModelPayment(BasePaymentDocumentDTO baseDTO, PaymentDocumentDTO documentDTO);
}
