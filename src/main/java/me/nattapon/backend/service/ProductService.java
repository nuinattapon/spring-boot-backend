package me.nattapon.backend.service;

import me.nattapon.backend.entity.Product;
import me.nattapon.backend.exception.BaseException;
import me.nattapon.backend.exception.ProductException;
import me.nattapon.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

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
        if(opt.isEmpty()) {
            throw ProductException.idNotFound();
        }
        Product product = opt.get();
        product.setName(name);
        return repository.save(product);
    }

    public void deleteById(String id){
        repository.deleteById(id);
    }

    public Product create(String name, Double price) throws BaseException {
        // Validate
        if(name == null) {
            // throw error email null\
            throw ProductException.createNameNull();
        }
        if(price == 0) {
            // throw error password null
            throw ProductException.createPriceNull();
        }

        // Verify
        if(repository.existsByName(name)) {
            throw ProductException.createNameDuplicated();
        }
        // Save
        Product entity = new Product();
        entity.setName(name);
        entity.setPrice(price);
        return repository.save(entity);
    }
}
