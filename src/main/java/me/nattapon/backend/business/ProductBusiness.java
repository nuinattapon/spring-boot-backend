package me.nattapon.backend.business;

import me.nattapon.backend.entity.Product;
import me.nattapon.backend.exception.BaseException;
import me.nattapon.backend.exception.ProductException;
import me.nattapon.backend.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductBusiness {

    private final ProductService service;

    public ProductBusiness(ProductService service) {
        this.service = service;
    }

    public Product getProductById(String id) throws BaseException {
        // Validate the given id
        if(id==null || id.isEmpty()) {
            throw ProductException.idNotFound();
        }
        // Get data from database
        Product product = service.getProductById(id);
        if(product == null) {
            throw ProductException.idNotFound();
        }
        return product;
    }

    public Product create(Product entity) throws BaseException {
        return service.create(entity.getName(), entity.getPrice());
    }

    public void deleteById(String id) throws BaseException {
        service.deleteById(id);
    }

    public List<Product> findAll() {
        return service.findAll();
    }

}
