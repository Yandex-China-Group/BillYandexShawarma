package com.factory.SmartFinance.user.auth;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserAuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping
    @Operation(summary = "Получение нового jwt токена пользователя")
    public LoginResponse auth(@RequestBody LoginRequest request) {
        String jwt = authenticationService.auth(request.getLogin(), request.getPassword());
        return new LoginResponse(jwt);
    }
}
