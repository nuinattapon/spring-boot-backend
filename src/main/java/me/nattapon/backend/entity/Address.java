package me.nattapon.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "m_social")
public class Address extends BaseEntity {

    @Column(length = 120)
    private String line1;

    @Column(length = 120)
    private String line2;

    @Column(length = 120)
    private String zipcode;

    @ManyToOne
    @JoinColumn(name = "m_user_id", nullable = true)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getLine1(), address.getLine1()) && Objects.equals(getLine2(), address.getLine2()) && Objects.equals(getZipcode(), address.getZipcode()) && Objects.equals(getUser(), address.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLine1(), getLine2(), getZipcode(), getUser());
    }
}
