package me.nattapon.backend.repository;

import me.nattapon.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

//@SuppressWarnings("NullableProblems")
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByEmail(String email);

    @Override
    void deleteById(String s);

    boolean existsByEmail(String email);
}
