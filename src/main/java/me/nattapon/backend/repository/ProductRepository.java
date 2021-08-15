package me.nattapon.backend.repository;

import me.nattapon.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@SuppressWarnings("NullableProblems")
public interface ProductRepository extends JpaRepository<Product,String> {

    Optional<Product> findByName(String name);

    @Override
    void deleteById(String s);

    boolean existsByName(String name);

}
