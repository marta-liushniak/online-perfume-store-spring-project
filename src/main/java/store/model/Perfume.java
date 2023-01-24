package store.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "perfumes")
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brandName;
    private String fragrance;
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getFragrance() {
        return fragrance;
    }

    public void setFragrance(String fragrance) {
        this.fragrance = fragrance;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Perfume perfume = (Perfume) o;
        return Objects.equals(id, perfume.id)
                && Objects.equals(brandName, perfume.brandName)
                && Objects.equals(fragrance, perfume.fragrance)
                && Objects.equals(country, perfume.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brandName, fragrance, country);
    }

    @Override
    public String toString() {
        return "Brand{" + "id=" + id
                + ", brandName='" + brandName
                + '\'' + ", fragrance='" + fragrance
                + '\'' + ", country='" + country
                + '\'' + '}';
    }
}
