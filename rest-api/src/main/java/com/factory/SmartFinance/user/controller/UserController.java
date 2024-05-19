package com.factory.SmartFinance.user.controller;

import com.factory.SmartFinance.jwt.JwtService;
import com.factory.SmartFinance.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.StringToClassMapItem;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final JwtService jwtService;
    private final UserService service;

    @Operation(summary = "Регистрация нового аккаунта",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    type = "object",
                                    properties = {
                                            @StringToClassMapItem(key="firstname", value=String.class),
                                            @StringToClassMapItem(key="lastname", value=String.class),
                                            @StringToClassMapItem(key="surname", value=String.class),
                                            @StringToClassMapItem(key="screenName", value=String.class),
                                            @StringToClassMapItem(key="login", value=String.class),
                                            @StringToClassMapItem(key="password", value=String.class)
                                    }
                            )
                    )
            ),
            responses = {
                @ApiResponse(
                        responseCode = "201"
                )
            }
    )
    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request) {
        service.register(
                request.getFirstName(),
                request.getLastName(),
                request.getSurname(),
                request.getScreenName(),
                request.getLogin(),
                request.getPassword()
        );
    }
    @Operation(summary = "Получение данных о текущем аккаунте",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            headers = @Header(name="Content-Type", description = "Тип данных"),
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    type = "object",
                                                    properties = {
                                                            @StringToClassMapItem(key="firstname", value=long.class),
                                                            @StringToClassMapItem(key="firstname", value=String.class),
                                                            @StringToClassMapItem(key="lastname", value=String.class),
                                                            @StringToClassMapItem(key="surname", value=String.class),
                                                            @StringToClassMapItem(key="screenName", value=String.class),
                                                    }
                                            )
                                    )
                            }
                    )
            }
    )
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/me")
    public UserDto me(HttpServletRequest request) {
        long userId = jwtService.extractId(jwtService.token(request).orElseThrow());
        return UserDto.from(service.user(userId));
    }

    @Operation(summary = "Обновление своего аккаунта")
    @SecurityRequirement(name = "Bearer Authentication")
    @PatchMapping("/update")
    public UserDto update(HttpServletRequest request, @RequestBody UpdateRequest updateRequest) {
        long userId = jwtService.extractId(jwtService.token(request).orElseThrow());
        service.updateUser(
                userId,
                updateRequest.getFirstName(),
                updateRequest.getLastName(),
                updateRequest.getSurname(),
                updateRequest.getScreenName()
        );
        return UserDto.from(service.user(userId));
    }
}
