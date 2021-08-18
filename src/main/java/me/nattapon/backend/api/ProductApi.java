package me.nattapon.backend.api;

import me.nattapon.backend.business.ProductBusiness;
import me.nattapon.backend.entity.Product;
import me.nattapon.backend.exception.BaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductApi {

    private final ProductBusiness business;
    public ProductApi(ProductBusiness business) {
        this.business = business;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id) throws BaseException {
        Product response = business.getProductById(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAll() throws BaseException {
        return ResponseEntity.ok(business.findAll());
    }

//    @GetMapping
//    public ResponseEntity<Product> getProductByIdUsingRequestParam(@RequestParam(name = "id") String id) throws BaseException {
//        Product response = business.getProductById(id);
//        return ResponseEntity.ok(response);
//    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) throws BaseException {
        Product entity = business.create(product);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") String id) throws BaseException {
        business.deleteById(id);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping
    public ResponseEntity<String>  deleteByIdUsingRequestParam(@RequestParam(name = "id") String id) throws BaseException {
        business.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
