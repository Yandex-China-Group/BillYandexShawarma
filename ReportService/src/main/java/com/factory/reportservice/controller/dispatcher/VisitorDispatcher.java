package com.factory.reportservice.controller.dispatcher;

import com.factory.reportservice.controller.ReportRequestController;
import com.factory.reportservice.messaging.data.ReportRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
public class VisitorDispatcher {
    private ReportRequestController reportRequestController;

    public void dispatch(Class<?> type, Object dataClass) {
        if (type.equals(ReportRequest.class)) {
            reportRequestController.visit((ReportRequest) dataClass);
        }
    }
}