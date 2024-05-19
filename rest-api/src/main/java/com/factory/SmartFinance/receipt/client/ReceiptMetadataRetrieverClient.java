package com.factory.SmartFinance.receipt.client;

import com.factory.SmartFinance.receipt.dto.ReceiptDTO;
import com.factory.SmartFinance.receipt.dto.ReceiptTransactionDataDTO;

public interface ReceiptMetadataRetrieverClient {
    public ReceiptTransactionDataDTO retrieveData(ReceiptDTO receiptDTO);
}
