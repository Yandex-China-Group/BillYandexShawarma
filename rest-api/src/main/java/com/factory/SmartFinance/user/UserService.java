package com.factory.SmartFinance.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    public void register(
            String firstName,
            String lastName,
            String surname,
            String screenName,
            String login,
            String password
    ) {
        checkLogin(login);
        User account = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .surname(surname)
                .screenName(screenName)
                .login(login)
                .password(passwordEncoder.encode(password))
                .build();
        repository.save(account);
    }

    public void updateUser(
            long userId,
            String firstName,
            String lastName,
            String surname,
            String screenName
    ) {
        User user = user(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setSurname(surname);
        user.setScreenName(screenName);
        repository.save(user);
    }

    public User user(long id) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "User with id %d doesnt exist".formatted(id)
            );

        return userOptional.get();
    }

    public User user(String login) {
        Optional<User> userOptional = repository.findByLogin(login);
        if (userOptional.isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "User with login %s doesnt exist".formatted(login)
            );

        return userOptional.get();
    }

    public void checkLogin(String login) {
        if (repository.findByLogin(login).isPresent())
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Login '%s' is already in use".formatted(login)
            );
    }
}
