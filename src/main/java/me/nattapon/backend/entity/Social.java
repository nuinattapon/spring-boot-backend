package me.nattapon.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Social extends BaseEntity {

    @Column(length = 120)
    private String facebook;

    @Column(length = 120)
    private String line;

    @Column(length = 120)
    private String instagram;

    @Column(length = 60)
    private String tiktok;

    @OneToOne
    @JoinColumn(name="m_user_id", nullable = true)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Social social = (Social) o;
        return Objects.equals(getFacebook(), social.getFacebook()) && Objects.equals(getLine(), social.getLine()) && Objects.equals(getInstagram(), social.getInstagram()) && Objects.equals(getTiktok(), social.getTiktok()) && Objects.equals(getUser(), social.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFacebook(), getLine(), getInstagram(), getTiktok(), getUser());
    }
}
