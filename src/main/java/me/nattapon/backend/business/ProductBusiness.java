package me.nattapon.backend.business;

import me.nattapon.backend.exception.BaseException;
import me.nattapon.backend.exception.ProductException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductBusiness {

    public String getProductById(String id) throws BaseException {
        // Get data from database
        if(Objects.equals("1234",id)) {
            throw ProductException.idNotFound();
        }
        return id;
    }
}
