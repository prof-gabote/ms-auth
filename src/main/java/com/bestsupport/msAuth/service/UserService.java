package com.bestsupport.msAuth.service;

import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bestsupport.msAuth.model.User;
import com.bestsupport.msAuth.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User register(User user) {
        if (repo.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Usuario ya existe");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        user.setToken(UUID.randomUUID().toString());
        return repo.save(user);
    }

    public String login(String username, String password) {
        User user = repo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        return user.getToken();
    }
}
