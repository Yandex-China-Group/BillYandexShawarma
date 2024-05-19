package com.factory.reportservice.doc.view;

import java.util.Set;

public record UserView(String screenName, String firstName, String lastName, Set<BillView> bills) {
}
