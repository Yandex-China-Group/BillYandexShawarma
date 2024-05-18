package com.factory.SmartFinance.user.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String firstName, lastName, surname, screenName, login, password;
}
