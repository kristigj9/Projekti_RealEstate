package com.example.realestate.service;

import com.example.realestate.model.App;
import com.example.realestate.model.Role;
import com.example.realestate.repository.AppRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class AppServiceImpl implements AppService {

    private final AppRepository repo;
    private final PasswordEncoder encoder;

    public AppServiceImpl(AppRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public App registerAdmin(String username, String rawPassword) {
        return createUser(username, rawPassword, Set.of(Role.ADMIN));
    }

    @Override
    public App registerAgent(String username, String rawPassword) {
        return createUser(username, rawPassword, Set.of(Role.AGENT));
    }

    @Override
    public App registerOwner(String username, String rawPassword) {
        return createUser(username, rawPassword, Set.of(Role.OWNER));
    }

    private App createUser(String username, String rawPassword, Set<Role> roles) {
        if (repo.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already exists");
        }

        App u = new App();
        u.setUsername(username);
        u.setPassword(encoder.encode(rawPassword));
        u.setRoles(roles);

        return repo.save(u);
    }
}
