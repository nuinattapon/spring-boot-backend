package me.nattapon.backend.exception;

public class ProductException extends BaseException {
    public ProductException(String code) {
        super("product." + code);
    }

    // SEARCH Exception
    public static ProductException idNotFound() {
        return new ProductException("id.not.found");
    }
    public static ProductException nameNotFound() {
        return new ProductException("name.not.found");
    }

    // CREATE Exception
    public static ProductException createNameNull() {
        return new ProductException("create.name.null");
    }
    public static ProductException createPriceNull() {
        return new ProductException("create.price.null");
    }
    public static ProductException createNameDuplicated() {
        return new ProductException("create.name.duplicated");
    }
}
