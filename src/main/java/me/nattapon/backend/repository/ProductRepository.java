package me.nattapon.backend.repository;

import me.nattapon.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,String> {

    Optional<Product> findByName(String name);

    void deleteById(@NonNull String id);

    boolean existsByName(String name);

    Product getProductById(String id);

    @Query("select p from Product p order by p.name")
    List<Product> findAllOrderByName();

}
