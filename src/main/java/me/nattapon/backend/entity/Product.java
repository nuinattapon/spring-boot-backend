package me.nattapon.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;


@Entity(name="product")
public class Product extends BaseEntity {

    public Product() {
    }

    @Column(nullable = false, unique = true, length = 120)
    private String name;

    @Column(nullable = false)
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, price);
    }
}
