package me.nattapon.backend.api;

import me.nattapon.backend.entity.Product;
import me.nattapon.backend.exception.BaseException;
import me.nattapon.backend.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductApi {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ProductService service;
    public ProductApi(ProductService business) {
        this.service = business;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id) throws BaseException {
        Product response = service.getProductById(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) throws BaseException {
        Product entity = service.create(product);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") String id) throws BaseException {
        service.deleteById(id);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping
    public ResponseEntity<String>  deleteByIdUsingRequestParam(@RequestParam(name = "id") String id) throws BaseException {
        service.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
