package com.factory.reportservice.doc.view;

import java.util.Date;

public record TransactionView(long id, Date createdAt, String paymentCategory, String transactionType) {
}
