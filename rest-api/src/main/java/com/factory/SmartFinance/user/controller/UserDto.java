package com.factory.SmartFinance.user.controller;

import com.factory.SmartFinance.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;
    private String firstName, lastName, surname, screenName;

    public static UserDto from(User user) {
        return UserDto
                .builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .surname(user.getSurname())
                .screenName(user.getScreenName())
                .build();
    }
}
