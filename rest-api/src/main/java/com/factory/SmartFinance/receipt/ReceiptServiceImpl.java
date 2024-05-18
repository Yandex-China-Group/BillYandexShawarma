package com.factory.SmartFinance.receipt;

import com.factory.SmartFinance.bill.Bill;
import com.factory.SmartFinance.bill.BillRepository;
import com.factory.SmartFinance.receipt.client.ReceiptMetadataRetrieverClient;
import com.factory.SmartFinance.receipt.dto.ReceiptDTO;
import com.factory.SmartFinance.receipt.dto.ReceiptTransactionDataDTO;
import com.factory.SmartFinance.transaction.PaymentCategory;
import com.factory.SmartFinance.transaction.Transaction;
import com.factory.SmartFinance.transaction.TransactionRepository;
import com.factory.SmartFinance.transaction.TransactionType;
import com.factory.SmartFinance.user.User;
import com.factory.SmartFinance.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {
    private final ReceiptMetadataRetrieverClient retrieverClient;
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final BillRepository billRepository;

    @Override
    public Long saveReceipt(Long userId, ReceiptDTO receiptRequest) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
        );

        ReceiptTransactionDataDTO transactionData = retrieverClient.retrieveData(receiptRequest);
        // Пытаемся найти счет в нашей базе данных, если не находим то предпологаем что оплатили наличными.
        Bill bill = billRepository.findById(transactionData.getBillId()).orElse(null);

        if (bill != null) {
            if (bill.getOwner().getId() != user.getId()) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }
        }

        return transactionRepository.save(
                Transaction.builder()
                        .amount(transactionData.getAmount())
                        .createdAt(transactionData.getTime())
                        .bill(bill)
                        .paymentCategory(new PaymentCategory("Чек"))
                        // TODO: Лучше использовать ENUM'ы в качестве TransactionType
                        .transactionType(new TransactionType("Трата"))
                        .build()
        ).getId();
    }
}
