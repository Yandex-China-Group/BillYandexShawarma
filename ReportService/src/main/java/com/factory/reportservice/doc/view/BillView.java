package com.factory.reportservice.doc.view;

import java.util.Set;

public record BillView(String title, String note, Set<TransactionView> transactions) {
}
