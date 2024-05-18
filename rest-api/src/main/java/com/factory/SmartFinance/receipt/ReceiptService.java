package com.factory.SmartFinance.receipt;

import com.factory.SmartFinance.receipt.dto.ReceiptDTO;

public interface ReceiptService {
    Long saveReceipt(Long userId, ReceiptDTO receiptRequest);
}
