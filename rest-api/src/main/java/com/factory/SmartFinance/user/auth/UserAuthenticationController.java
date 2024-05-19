package com.factory.SmartFinance.user.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.StringToClassMapItem;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Получение нового jwt токена пользователя", responses = {
            @ApiResponse(
                    responseCode = "200",
                    headers = @Header(name="Content-Type", description = "Тип данных"),
                    content = {
                            @Content(
                                    schema = @Schema(
                                            type = "object",
                                            properties = {
                                                    @StringToClassMapItem(key="jwt", value=String.class)
                                            }
                                    )
                            )
                    }
            )
    })
    public LoginResponse auth(@RequestBody LoginRequest request) {
        String jwt = authenticationService.auth(request.getLogin(), request.getPassword());
        return new LoginResponse(jwt);
    }
}
