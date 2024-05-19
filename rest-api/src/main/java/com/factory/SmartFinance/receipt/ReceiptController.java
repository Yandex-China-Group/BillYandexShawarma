package com.factory.SmartFinance.receipt;

import com.factory.SmartFinance.jwt.JwtService;
import com.factory.SmartFinance.receipt.dto.ReceiptDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/receipt")
@RequiredArgsConstructor
public class ReceiptController {
    private final ReceiptService receiptService;
    private final JwtService jwtService;

    @PostMapping("/")
    public Long saveReceipt(HttpServletRequest request, @RequestBody ReceiptDTO receiptRequest) {
        Optional<String> token = jwtService.token(request);
        if (token.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Long userId = jwtService.extractId(token.get());
        return receiptService.saveReceipt(userId, receiptRequest);
    }
}
