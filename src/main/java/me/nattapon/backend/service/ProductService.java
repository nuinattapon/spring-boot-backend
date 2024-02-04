package me.nattapon.backend.service;

import me.nattapon.backend.entity.Product;
import me.nattapon.backend.exception.BaseException;
import me.nattapon.backend.exception.ProductException;
import me.nattapon.backend.repository.ProductRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Optional<Product> findByName(String name) {
        return repository.findByName(name);

    }

    public Product update(Product product) {
        return repository.save(product);
    }

    public Product updateName(String id, String name) throws BaseException {
        Optional<Product> opt = repository.findById(id);
        if (opt.isEmpty()) {
            throw ProductException.idNotFound();
        }
        Product product = opt.get();
        product.setName(name);
        return repository.save(product);
    }

    public void deleteById(String id) throws BaseException {
        Optional<Product> opt = repository.findById(id);
        if (opt.isEmpty()) {
            throw ProductException.idNotFound();
        }
        repository.deleteById(id);
    }

    public Product create(Product entity) throws BaseException {
        // Validate
        if (entity.getName() == null) {
            // throw error email null
            throw ProductException.createNameNull();
        }
        if (entity.getPrice() == 0) {
            // throw error password null
            throw ProductException.createPriceNull();
        }

        // Verify
        if (repository.existsByName(entity.getName())) {
            throw ProductException.createNameDuplicated();
        }
        // Save
        return repository.save(entity);
    }

    public Product getProductById(@NonNull String id) throws BaseException {

        // Get data from database
        Product product = repository.getProductById(id);
        if (product == null) {
            throw ProductException.idNotFound();
        }
        return product;
    }

    public List<Product> findAll() {
        return repository.findAllOrderByName();
    }

}
