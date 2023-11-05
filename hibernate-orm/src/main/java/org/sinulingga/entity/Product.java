package org.sinulingga.entity;

import jakarta.persistence.*;
import org.sinulingga.definition.Status;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(length = 36)
    private String id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "category_id", nullable = true)
    )
    private Set<Category> categories = new HashSet<>();

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "code", length = 20, nullable = true, unique = true)
    private String code;

    @Column(name = "stock", nullable = false)
    private Long stock;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "is_active", nullable = true)
    private Status isActive;

    public Product() {

    }

    public Product(String id, String name, String code, Long stock, Status isActive) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.stock = stock;
        this.isActive = Objects.isNull(isActive) ? Status.NOT_ACTIVE : isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Status isActive() {
        return isActive;
    }

    public void setActive(Status active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", categories=" + categories +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", stock=" + stock +
                ", isActive=" + isActive +
                '}';
    }
}
