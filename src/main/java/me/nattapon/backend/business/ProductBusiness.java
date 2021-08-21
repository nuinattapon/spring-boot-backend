package me.nattapon.backend.business;

import me.nattapon.backend.entity.Product;
import me.nattapon.backend.exception.BaseException;
import me.nattapon.backend.exception.ProductException;
import me.nattapon.backend.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class  ProductBusiness {

    private final ProductService service;

    public ProductBusiness(ProductService service) {
        this.service = service;
    }

    public Product getProductById(String id) throws BaseException {
        return service.getProductById(id);
    }

    public Product create(Product entity) throws BaseException {
        return service.create(entity);
    }

    public void deleteById(String id) throws BaseException {
        service.deleteById(id);
    }

    public List<Product> findAll() {
        return service.findAll();
    }

}
