package me.nattapon.backend.exception;

public class ProductException extends BaseException {
    public ProductException(String code) {
        super("product." + code);
    }

    // id.not.found
    public static ProductException idNotFound() {
        return new ProductException("id.not.found");
    }
}
