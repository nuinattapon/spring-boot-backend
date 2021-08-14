package me.nattapon.backend.service;

import me.nattapon.backend.entity.User;
import me.nattapon.backend.exception.BaseException;
import me.nattapon.backend.exception.UserException;
import me.nattapon.backend.repository.UserRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean matchPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword,encodedPassword);
    }

    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);

    }

    public User update(User user) {
        return repository.save(user);
    }

    public User updateName(String id, String name) throws BaseException {
        Optional<User> opt = repository.findById(id);
        if(opt.isEmpty()) {
            throw UserException.notFound();
        }
        User user = opt.get();
        user.setName(name);
        return repository.save(user);
    }

    public void deleteById(String id){
        repository.deleteById(id);
    }

    public User create(String email, String password, String name) throws BaseException {
        // Validate
        if(Objects.isNull(email)) {
            // throw error email null\
            throw UserException.createEmailNull();
        }
        if(Objects.isNull(password)) {
            // throw error password null
            throw UserException.createPasswordNull();
        }
        if(Objects.isNull(name)) {
            // throw error name null
            throw UserException.createNameNull();
        }

        // Verify
        if(repository.existsByEmail(email)) {
            throw UserException.createEmailDuplicated();
        }
        // Save

        User entity = new User();
        entity.setPassword(passwordEncoder.encode(password));
        entity.setName(name);
        entity.setEmail(email);
        return repository.save(entity);
    }
}
