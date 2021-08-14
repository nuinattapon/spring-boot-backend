package me.nattapon.backend.api;

import me.nattapon.backend.business.ProductBusiness;
import me.nattapon.backend.exception.BaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductApi {

    private final ProductBusiness business;
    public ProductApi(ProductBusiness business) {
        this.business = business;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable("id") String id) throws BaseException {
        String response = business.getProductById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<String> getProductByIdUsingRequestParam(@RequestParam(name = "id") String id) throws BaseException {
        String response = business.getProductById(id);
        return ResponseEntity.ok(response);
    }
}


