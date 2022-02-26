package ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.dto.BasePaymentDocumentDTO;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.entity.Payment;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.entity.PaymentHeader;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.mapper.PaymentMapper;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.repository.PaymentHeaderRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.repository.PaymentRepository;
import ru.BillingLK.BillingLK.ExchangeBillingAPI.ParallelOperations.Payments.service.PaymentService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentServiceImpl implements PaymentService {

    private final PaymentHeaderRepository paymentHeaderRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public void GetAll() {

    }

    @Override
    public void RegistrationPaymentInitialConversion() {

    }

    @Override
    @Transactional
    public void RegistrationPaymentDocument(BasePaymentDocumentDTO basePaymentDocumentDTO) throws Exception {
        var dataBasedto = basePaymentDocumentDTO.getData();
        if (dataBasedto.isEmpty()){
            throw new Exception("Не найденно данных для регистрации оплаты");
        }

        PaymentHeader paymentHeader = paymentMapper.ToModelPaymentHeader(basePaymentDocumentDTO);
        paymentHeaderRepository.save(paymentHeader);

        paymentRepository.deleteByObjectBaseID(basePaymentDocumentDTO.getObjectBaseID());
        List<Payment> payments = dataBasedto
                .stream()
                .map(element -> paymentMapper.ToModelPayment(basePaymentDocumentDTO, element))
                .collect(Collectors.toList());

        paymentRepository.saveAll(payments);
    }
}
