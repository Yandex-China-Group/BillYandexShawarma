package com.factory.SmartFinance.receipt.client;

import com.factory.SmartFinance.receipt.dto.ReceiptDTO;
import com.factory.SmartFinance.receipt.dto.ReceiptTransactionDataDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ReceiptMetadataRetrieverClientMock implements ReceiptMetadataRetrieverClient {

    @Override
    public ReceiptTransactionDataDTO retrieveData(ReceiptDTO receiptDTO) {
        return ReceiptTransactionDataDTO.builder()
                .amount(receiptDTO.getAmount())
                .time(receiptDTO.getTime())
                .transactionTitle("Receipt#" + UUID.randomUUID())
                .build();
    }
}
