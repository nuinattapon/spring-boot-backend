package me.nattapon.backend.repository;

import me.nattapon.backend.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("NullableProblems")
public interface ProductRepository extends JpaRepository<Product,String> {

    Optional<Product> findByName(String name);

    void deleteById(String s);

    boolean existsByName(String name);

    Product getProductById(String id);

    List<Product> findAll();

    @Query("select p from Product p order by p.name")
    List<Product> findAllOrderByName();

}
