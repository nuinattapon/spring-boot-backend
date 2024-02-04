package me.nattapon.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "m_user", uniqueConstraints = {@UniqueConstraint(name="email_unique",columnNames = {"email"})})
public class User extends BaseEntity {

    @Column(nullable = false, length = 120)
    private String email;

    @JsonIgnore
    @Column(nullable = false, length = 120)
    private String password;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 60)
    private String role;

    @OneToOne(mappedBy = "user", orphanRemoval = true)
    private Social social;

    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Address> addresses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getName(), user.getName()) && Objects.equals(getRole(), user.getRole()) && Objects.equals(getSocial(), user.getSocial());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPassword(), getName(), getRole(), getSocial());
    }
}
